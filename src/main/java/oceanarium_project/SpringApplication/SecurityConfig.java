package oceanarium_project.SpringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/","/index").permitAll()
                        .requestMatchers("/resources/static/**").permitAll()
                        .requestMatchers("/main").authenticated()
               //         .requestMatchers("/resources/static/**").permitAll()
               //         .requestMatchers("/main").authenticated()
                )


                .formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                              //  .defaultSuccessUrl("/main")
                                .permitAll()
                )
                .logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .logoutUrl("/index")
                                .logoutSuccessUrl("/login")
                                .permitAll()
                );


                /*
                .csrf(AbstractHttpConfigurer::disable)

                //.authorizeHttpRequests((authorize) ->
                //        authorize.anyRequest().authenticated())
                .formLogin(
                        form -> form
                                .loginPage("/login")
                                // .loginProcessingUrl("/login")
                                //.defaultSuccessUrl("/index")
                                .permitAll()
                )
                .logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                                .logoutUrl("/index")
                                .logoutSuccessUrl("/index")
                );
                */

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }


}

/*
////////////////////////////////
DLA TEGO DZIALAJĄ STARE HTML:
////////////////////////////////////////



public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/","/index").permitAll()
               //         .requestMatchers("/resources/static/**").permitAll()
               //         .requestMatchers("/main").authenticated()
                                .anyRequest().authenticated()
                )


                .formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                              //  .defaultSuccessUrl("/main")
                                .permitAll()
                )
                .logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                             //   .logoutUrl("/logout")
                            //    .logoutSuccessUrl("/login")
                                .permitAll()
                );
        return http.build();
                }
 */