package pl.psomocnik.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private ResourceServerTokenServices tokenServices;

   // @Autowired CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Value("${resource-ids}")
    private String resourceIds;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(resourceIds).tokenServices(tokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/pet/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/pet").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/pet/**").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/pet/**").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.GET, "/api/disease").permitAll()
                .antMatchers(HttpMethod.POST, "/api/disease").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/disease").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.GET, "/api/photos/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/findPet").permitAll()
                .antMatchers(HttpMethod.GET, "/api/user/**").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/user").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/user/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/user/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/role/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/register").permitAll()
               // .and().oauth2Login().successHandler(customAuthenticationSuccessHandler)
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}


