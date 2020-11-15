package ch.zli.m223.punchclock.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/***
 * This class was created by Jason Banyer
 * Date: 14.11.2020
 *
 * Description of this class:
 * This Class encodes the Password to Sign Up into BCrypt, with a stamina-level of 10.
 *
 */
@Configuration
public class ApplicationPasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
