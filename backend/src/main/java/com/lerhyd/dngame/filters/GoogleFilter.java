package com.lerhyd.dngame.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lerhyd.dngame.dao.RoleDao;
import com.lerhyd.dngame.dao.RuleDao;
import com.lerhyd.dngame.dao.UserDao;
import com.lerhyd.dngame.generators.PasswordGenerator;
import com.lerhyd.dngame.model.Role;
import com.lerhyd.dngame.model.Rule;
import com.lerhyd.dngame.model.User;
import lombok.Data;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@SuppressWarnings("Duplicates")
public class GoogleFilter extends AbstractAuthenticationProcessingFilter {

    private OAuth2RestTemplate restTemplate;

    private UserDao userDao;

    private RoleDao roleDao;

    private RuleDao ruleDao;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public GoogleFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(authenticationManagerNone());
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        try {
            try {

                OAuth2AccessToken accessToken = restTemplate.getAccessToken();

                String idToken = accessToken.getAdditionalInformation().get("id_token").toString();
                Jwt token = JwtHelper.decode(idToken);

                Map<String, String> authInfo = new ObjectMapper().readValue(token.getClaims(), Map.class);

                String email = authInfo.get("email");

                if (userDao.findUserByGoogleEmail(email) == null || userDao.findUserByGoogleEmail(email).getPassword().equals(bCryptPasswordEncoder.encode(idToken))){
                    User userEntity = new User();
                    userEntity.setRegistrationDate(LocalDateTime.now());
                    String sub = authInfo.get("sub");
                    String emailLogin = email.substring(0, email.indexOf('@'));
                    PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                            .useDigits(true)
                            .build();
                    try {
                        while (userDao.existsById(sub)){
                            int subInt = Integer.parseInt(sub);
                            subInt++;
                            sub = String.valueOf(subInt);
                        }
                    } catch (NumberFormatException e){
                        while (userDao.existsById(authInfo.get("sub"))){
                            sub = passwordGenerator.generate(8);
                        }
                    }

                    userEntity.setLogin(emailLogin + sub);
                    userEntity.setGoogleEmail(email);
                    userEntity.setNeuralEmail(email);
                    Role userRole = roleDao.findById("google").get();
                    userEntity.setRoles(new HashSet<>(Arrays.asList(userRole)));
                    List<Rule> rules = ruleDao.findAll();
                    userEntity.setRules(rules);
                    userEntity.setPassword(bCryptPasswordEncoder.encode(idToken));
                    userEntity.setLastVisitTime(LocalDateTime.now());
                    userEntity.setConfirmed(true);
                    userDao.save(userEntity);

                }
                User userEntity = userDao.findUserByGoogleEmail(email);
                List<SimpleGrantedAuthority> authorities = userEntity
                        .getRoles()
                        .stream()
                        .map(e -> new SimpleGrantedAuthority(e.getRole()))
                        .collect(Collectors.toList());
                org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(userEntity.getLogin(), userEntity.getPassword(), authorities);
                return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            } catch (InvalidTokenException e) {
                throw new BadCredentialsException("Could not obtain user details from token", e);
            }
        } catch (OAuth2Exception e) {
            throw new BadCredentialsException("Error token", e);
        }

    }

    public AuthenticationManager authenticationManagerNone() {
        AuthenticationManager authenticationManager = authentication -> {
            throw new UnsupportedOperationException("No authentication should be done with this AuthenticationManager");
        };
        return authenticationManager;
    }

}
