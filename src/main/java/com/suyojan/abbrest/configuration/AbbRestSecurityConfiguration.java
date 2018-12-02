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
 * @author Atul Saurabh
 * @version 1.0
 * Configures the security aspect of the project.
 */

@Configuration
public class AbbRestSecurityConfiguration extends WebSecurityConfigurerAdapter
{



    /**
     * 
     * @param authenticationManagerBuilder Manages authentication process for the allowed user
     * @throws Exception The exception will be thrown if the method is unable to create in memory user 
     * and/or unable to assign role to the user. 
     */
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        /*
            Create the user called REST_CLIENT in memory only. 
            Put the user REST_CLIENT in the role of ABBCLIENT.
        */
        authenticationManagerBuilder.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance()).
                withUser("REST_CLIENT").
                password("INDIA").roles("ABBCLIENT");
    }
    
    
    /**
     * 
     * @param http Instance of type HttpSecurity. Responsible for configuring/
     * providing security inside the application
     * @throws Exception  
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
           Disabling cross site reference
        */
        http.csrf().disable();
        /*
            If url /abbrest/update or /abbrest/retrieve hits 
            try to authenticate and authorize the user by verifying
            authentication header sent by the client.
            If client is not verified or not autheticated then http 401 error 
            is generated.
        */
        http.authorizeRequests()
            .antMatchers("/abbrest/update","/abbrest/retrieve").fullyAuthenticated().and().authorizeRequests().anyRequest()
            .hasRole("ABBCLIENT")
            .and()
            .authorizeRequests()
            .and().httpBasic();
                
    }
    
}
