package ucb.edu.bo.Elevate.Config;

import java.util.Arrays;

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

    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Desactiva la protección CSRF si es necesario
            .authorizeHttpRequests(authorizeRequests -> 
                authorizeRequests
                    .requestMatchers("/api/v1/user/**").permitAll()  // Permitir el acceso a los endpoints de /api/v1/user sin autenticación
                    .anyRequest().authenticated()  // Requiere autenticación para cualquier otra solicitud
            )
            .cors();  // Activa CORS

        return http.build();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        // Configuración de CORS
        config.setAllowedOrigins(Arrays.asList("*"));  // Permitir solicitudes desde cualquier origen
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));  // Métodos permitidos
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "X-Requested-With"));  // Encabezados permitidos
        config.setExposedHeaders(Arrays.asList("Authorization"));  // Exponer encabezados necesarios
        config.setAllowCredentials(true);  // Permitir el envío de cookies o credenciales
        
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
