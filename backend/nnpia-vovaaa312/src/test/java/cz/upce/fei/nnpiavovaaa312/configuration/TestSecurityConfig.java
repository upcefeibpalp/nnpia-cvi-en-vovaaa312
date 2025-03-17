package cz.upce.fei.nnpiavovaaa312.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/*
* Oddělená konfigurace pouze pro testování.
* */
@Configuration
public class TestSecurityConfig {
    /*
    * Vypni veškerou autentifikaci a autorizaci pro testovací třídy. Jakýkoliv request bude v rámci testů bude vždy
    * povolen. Vypni také CSRF ochranu.
    * */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
