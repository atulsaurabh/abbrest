/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suyojan.abbrest.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 *
 * @author Suyojan
 */

@Configuration
public class AbbRestSecurityConfiguration extends WebSecurityConfigurerAdapter
{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance()).
                withUser("REST_CLIENT").
                password("INDIA").roles("ABBCLIENT");
    }
    
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
            .antMatchers("/abbrest/update","/abbrest/retrieve").fullyAuthenticated().and().authorizeRequests().anyRequest()
            .hasRole("ABBCLIENT")
            .and()
            .authorizeRequests()
            .and().httpBasic();
                
    }
    
}
