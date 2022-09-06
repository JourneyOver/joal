package org.araymond.joal.web.config.security;

import org.araymond.joal.web.annotations.ConditionalOnWebUi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Created by raymo on 29/07/2017.
 */
@ConditionalOnWebUi
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final String pathPrefix;
    private final boolean shouldDisableFrameOptions;

    public WebSecurityConfig(
            @Value("${joal.ui.path.prefix}") final String pathPrefix,
            @Value("${joal.iframe.enabled:false}") final boolean shouldDisableFrameOptions
    ) {
        this.pathPrefix = pathPrefix;
        this.shouldDisableFrameOptions = shouldDisableFrameOptions;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        if (this.shouldDisableFrameOptions) {
            http.headers().frameOptions().disable();
        }

        http
                .httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/" + this.pathPrefix).permitAll()
                .antMatchers("/" + this.pathPrefix + "/ui/**").permitAll()
                .anyRequest().denyAll();
    }

}
