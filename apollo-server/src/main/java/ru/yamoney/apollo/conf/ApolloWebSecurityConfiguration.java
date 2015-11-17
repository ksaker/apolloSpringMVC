package ru.yamoney.apollo.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 * ApolloWebSecurityConfiguration
 * <p></p>
 *
 * @author Platonov Alexey
 * @version 1.0 17.11.15
 */
//TODO: Delete only for tests
@Configuration
public class ApolloWebSecurityConfiguration {

    /**
     * Configure access through certificate
     */
    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class ApolloWebSecurityAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserDetailsService userDetailsService;

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests().anyRequest().permitAll()
                    .and()
                    .x509().subjectPrincipalRegex("CN=(.*?),").userDetailsService(userDetailsService);
        }

    }
}
