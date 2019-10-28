package com.ys.hospital.config.security;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;


/**
 * <Description> <br>
 *
 * @author henley<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2017年1月13日 <br>
 */
@EnableWebSecurity
public class CustomizedWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private CustomizedUserAuthorityInfoService customizedUserAuthorityInfoService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/wx/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/**/*.js").permitAll()
                .antMatchers("/**/*.css").permitAll()
                .antMatchers("/**/*.fonts").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().maximumSessions(1).sessionRegistry(new SessionRegistryImpl())
                .and()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/page/index")
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customizedUserAuthorityInfoService).passwordEncoder(new BCryptPasswordEncoder());
    }


}