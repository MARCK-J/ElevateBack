package ucb.edu.bo.Elevate.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class CorsConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Desactiva la protección CSRF si es necesario
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/api/v1/user/**").permitAll()  // Permite el acceso a los endpoints de /api/v1/user sin autenticación
                    .anyRequest().authenticated()  // Requiere autenticación para cualquier otra solicitud
            )
            .cors();  // Activa CORS

        return http.build();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // Permitir solicitudes desde cualquier origen
        config.addAllowedHeader("*"); // Permitir cualquier encabezado
        config.addAllowedMethod("*"); // Permitir cualquier método (GET, POST, etc.)
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
