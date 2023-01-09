package service;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/name").permitAll()
                .antMatchers("/salary").hasAnyRole(Roles.MANAGER.name(), Roles.EMPLOYEE.name())
                .antMatchers("/phone").hasRole(Roles.EMPLOYEE.name())
                .anyRequest()
                .authenticated();
    }

}
