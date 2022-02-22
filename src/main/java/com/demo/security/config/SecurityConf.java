package com.demo.security.config;

import com.demo.security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {
    @Autowired
    private AccountService accountService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.authorizeRequests().antMatchers("/superadmin/**").access("hasRole('ROLE_SUPER_ADMIN')")
                .antMatchers("/admin/**").access("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')").
                antMatchers("/employee/**").access("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')").
                and().formLogin().loginPage("/account/login")
                .loginProcessingUrl("/account/process-login")
                .defaultSuccessUrl("/account/welcome")
                .failureUrl("/account/login?err=")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout().logoutUrl("/account/logout")
                .logoutSuccessUrl("/account/login?logout");

    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder ) throws Exception{
     builder.userDetailsService(accountService);
    }
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
