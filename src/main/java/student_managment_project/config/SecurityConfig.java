package student_managment_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {
        http
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers(
                                        HttpMethod.GET,
                                        "/api/public/**"
                                ).permitAll()

                                .requestMatchers(
                                      HttpMethod.GET,
                                      "/api/admin"
                                ).hasRole("ADMIN")

                                .requestMatchers(
                                        HttpMethod.GET,
                                        "/api/user"
                                ).authenticated()
                                .anyRequest().denyAll()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){

        UserDetails student = User.builder()
                .username("student")
                .password(passwordEncoder.encode("student123"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails test = User.builder()
                .username("test")
                .password(passwordEncoder.encode("test123"))
                .roles("TEST")
                .build();

        return new InMemoryUserDetailsManager(
                student,
                test,
                admin
        );
    }

    // 155 yerde istifade edilib
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
