package edu.mum.cs.cs425.demos.elibrary_springsec_1.config;

import edu.mum.cs.cs425.demos.elibrary_springsec_1.service.ElibraryUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;


    public WebSecurityConfig(ElibraryUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                .antMatchers("/resources/static/**", "/images/**", "/css/**", "/eregistrar/public/**").permitAll()
                .antMatchers("/", "/eregistrar").permitAll()
                .antMatchers("/eregistrar/secured/services/admin/**").hasRole("ADMIN")
                .antMatchers("/eregistrar/secured/services/registrar/**").hasRole("REGISTRAR")
                .antMatchers("/eregistrar/secured/services/student/**").hasRole("STUDENT")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/eregistrar/public/login")
                .defaultSuccessUrl("/eregistrar/secured/home")
                .failureUrl("/eregistrar/public/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/eregistrar/public/logout"))
                .logoutSuccessUrl("/eregistrar/public/login?logout")
                .permitAll()
                .and()
                .exceptionHandling();
    }
}
