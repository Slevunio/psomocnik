package pl.psomocnik.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/pet**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/pet").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/pet/**").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/pet/**").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.GET, "/api/disease").permitAll()
                .antMatchers(HttpMethod.POST, "/api/disease").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/disease").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.GET, "/api/photos**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/findPet").permitAll()
                .antMatchers(HttpMethod.GET, "/api/user**").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/user").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/user/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/user/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/register").permitAll()
                .antMatchers(HttpMethod.POST, "/api/login").permitAll().and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add a filter to validate the tokens with every request
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }


    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}