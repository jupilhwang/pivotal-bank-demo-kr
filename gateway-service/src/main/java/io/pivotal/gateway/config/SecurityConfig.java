package io.pivotal.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

//@Configuration
//public class SecurityConfig {
//    @Bean
//    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
//        return http
//                .csrf().disable()
//                .authorizeExchange()
//                .anyExchange().permitAll()
//                .and()
//                .build();
//    }
//
//}
//
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http)    {
        http.authorizeExchange().anyExchange().permitAll();
        return http.build();
    }
}

