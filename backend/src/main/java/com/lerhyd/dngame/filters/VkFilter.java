package com.lerhyd.dngame.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lerhyd.dngame.dao.RoleDao;
import com.lerhyd.dngame.dao.RuleDao;
import com.lerhyd.dngame.dao.UserDao;
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
public class VkFilter extends AbstractAuthenticationProcessingFilter {

    private OAuth2RestTemplate restTemplate;

    private UserDao userDao;

    private RoleDao roleDao;

    private RuleDao ruleDao;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public VkFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(authenticationManagerNone());
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        try {
            try {

                OAuth2AccessToken accessToken = restTemplate.getAccessToken();

                String userId = accessToken.getAdditionalInformation().get("user_id").toString();

                String email = accessToken.getAdditionalInformation().get("email").toString();
                String emailLogin = email.substring(0, email.indexOf('@'));

                if (userDao.findUserByVkId(Integer.parseInt(userId)) == null){
                    User userEntity = new User();
                    userEntity.setRegistrationDate(LocalDateTime.now());
                    while (userDao.existsById(userId)){
                        int idInt = Integer.parseInt(userId);
                        idInt++;
                        userId = String.valueOf(idInt);
                    }
                    userEntity.setLogin(emailLogin + userId);
                    userEntity.setVkId(Integer.parseInt(userId));
                    userEntity.setNeuralEmail(email);
                    Role userRole = roleDao.findById("vk").get();
                    userEntity.setRoles(new HashSet<>(Arrays.asList(userRole)));
                    List<Rule> rules = ruleDao.findAll();
                    userEntity.setRules(rules);
                    userEntity.setPassword(bCryptPasswordEncoder.encode(userId));
                    userEntity.setLastVisitTime(LocalDateTime.now());
                    userEntity.setConfirmed(true);
                    userDao.save(userEntity);

                }
                User userEntity = userDao.findUserByVkId(Integer.parseInt(userId));
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