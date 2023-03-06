package com.example.springsecuritybasicauthentication.configs

import com.example.springsecuritybasicauthentication.adapters.gateways.mongodb.UserRepository
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity.RequestMatcherConfigurer
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.validation.annotation.Validated
import javax.sql.DataSource
import uk.co.caeldev.springsecuritymongo.MongoUserDetailsManager

@Validated
@EnableWebSecurity
@ConfigurationProperties(prefix = "authorization")
data class SecurityConfig(
    val endpoints: List<EndpointProperties>,
    val dataSource: DataSource,
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .securityMatchers { getAntMatchers(it) }
            .authorizeHttpRequests { getAntMatchers(it) }
            .httpBasic(withDefaults())
            .csrf().disable()
        return http.build()
    }

    @Bean
    fun users(userRepository: UserRepository): MongoUserDetailsManager {
        return MongoUserDetailsManager(userRepository)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    private fun getAntMatchers(requestMatcherConfigurer: RequestMatcherConfigurer): RequestMatcherConfigurer {
        endpoints.forEach {
            it.methods.forEach { method -> requestMatcherConfigurer.requestMatchers(method, it.path) }
        }
        return requestMatcherConfigurer
    }

    private fun getAntMatchers(
        authorizeHttpRequestsConfigurer: AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry,
    ): AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry {
        endpoints.forEach {
            it.methods.forEach { method ->
                authorizeHttpRequestsConfigurer.requestMatchers(method, it.path).hasAnyRole(*it.roles.toTypedArray())
            }
        }
        return authorizeHttpRequestsConfigurer
    }
}

data class EndpointProperties(
    @field:NotBlank val path: String,
    @field:NotEmpty val methods: List<HttpMethod>,
    @field:NotEmpty val roles: List<String>,
)