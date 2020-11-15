package ch.zli.m223.punchclock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/***
 * This class was created by Jason Banyer
 * Date: 12.11.2020
 *
 * Description of this class:
 * This class modifies the default loginform and permits certain pages to be visited, without having to login.
 *
 * Additionally Users and Admins are created and added by using the UserBuilder.
 * They receive a Username and a Password which will be recognised and accepted by the loginform.
 *
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable() // Spring by default tries to secure the API
                .authorizeRequests()
                .antMatchers("/css/*", "/js/*") //Whitelisting following pages. * means all
                .permitAll()
                .antMatchers("/**").hasRole(ApplicationBenutzerRole.BENUTZER.name()) //will protect anything that has to do with Benutzer
                .antMatchers(HttpMethod.PUT, "/update/**").hasAuthority(ApplicationBenutzerPermission.BENUTZER_WRITE.name())
                .antMatchers(HttpMethod.DELETE, "/delete/**").hasAuthority(ApplicationBenutzerPermission.BENUTZER_WRITE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        //We want to authorize requests any requests must be authenticated and the mechanism is by using basic HTTP.
        //No GUI, but a basic login now.
        //Problem with basic auth is, that you can't logout.
    }


    @Override
    @Bean
    protected UserDetailsService userDetailsService() { //To create a new User just paste in here. and below
        UserDetails annaSmithUser = User.builder()
                .username("annasmith")
                .password(passwordEncoder.encode("password")) //Encrypts the Password in BCRYPT
                .roles(ApplicationBenutzerRole.BENUTZER.name()) //ROLE_BENUTZER
                .build();

        UserDetails jasonUser = User.builder()
                .username("jason")
                .password(passwordEncoder.encode("jason"))
                .roles(ApplicationBenutzerRole.BENUTZER.name()) //ROLE_ADMIN
                .build();

        UserDetails lindaUser = User.builder()
                .username("linda")
                .password(passwordEncoder.encode("password123"))
                .roles(ApplicationBenutzerRole.ADMINISTRATOR.name()) //ROLE_ADMIN
                .build();

        return new InMemoryUserDetailsManager( //All Users and Admins go in here.
                annaSmithUser,
                lindaUser,
                jasonUser
        );

    }
}
