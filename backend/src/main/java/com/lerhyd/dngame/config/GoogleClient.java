package com.lerhyd.dngame.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.Arrays;

@SuppressWarnings("Duplicates")
@EnableOAuth2Client
@Configuration
public class GoogleClient {

    private final String clientId = "162273111165-0sqsq7sh199fqnph5oh64ir6hcd7e42n.apps.googleusercontent.com";
    private final String clientSecret = "k8Vl60knsN74GghTA12gS-8V";
    private final String accessTokenUri = "https://www.googleapis.com/oauth2/v3/token";
    private final String userAuthorizationUri = "https://accounts.google.com/o/oauth2/auth";
    private final String redirectUri = "http://localhost:1234/login/google";

    @Bean(name = "googleResourceDetails")
    public OAuth2ProtectedResourceDetails googleResourceDetails() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(accessTokenUri);
        details.setUserAuthorizationUri(userAuthorizationUri);
        details.setPreEstablishedRedirectUri(redirectUri);
        details.setScope(Arrays.asList("email"));
        details.setUseCurrentUri(false);
        return details;
    }

    @Bean(name = "googleRestTemplate")
    public OAuth2RestTemplate googleRestTemplate(@Qualifier("googleResourceDetails") OAuth2ProtectedResourceDetails googleResourceDetails, OAuth2ClientContext context) {
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(googleResourceDetails, context);
        return restTemplate;
    }
}
