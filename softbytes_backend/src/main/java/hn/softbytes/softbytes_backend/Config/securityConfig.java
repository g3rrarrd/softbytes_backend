package hn.softbytes.softbytes_backend.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class securityConfig {
    
   @Bean
   public UserDetailsService userDetailsService(){

        var user = User.withUsername("Gerardo")
                    .password("1234")
                    .roles("ADMIN")
                    .build();

        return new InMemoryUserDetailsManager(user);
   }

   @Bean
   public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
   }

}
