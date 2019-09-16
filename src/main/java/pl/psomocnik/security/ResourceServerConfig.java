package pl.psomocnik.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${resource-ids}")
    private String resourceIds;

    @Override
    public void configure (ResourceServerSecurityConfigurer resources){
        resources.resourceId(resourceIds).tokenServices(tokenServices);
    }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/controller/pet/**").permitAll()
                .antMatchers(HttpMethod.POST, "/controller/pet").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/controller/pet/**").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/controller/pet/**").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.GET, "/controller/disease").permitAll()
                .antMatchers(HttpMethod.POST, "/controller/disease").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/controller/disease").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.GET, "/controller/photos/**").permitAll()
                .antMatchers(HttpMethod.POST, "/controller/findPet").permitAll()
                .antMatchers(HttpMethod.GET, "/controller/user/**").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.POST, "/controller/user").hasAnyAuthority("MODERATOR", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/controller/user/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/controller/user/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/controller/role/**").permitAll()
                .antMatchers(HttpMethod.POST, "/controller/register").permitAll()
                .antMatchers(HttpMethod.POST, "/controller/login").permitAll()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}

