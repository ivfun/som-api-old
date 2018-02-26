package org.ivfun.som.security.service.impl

import org.ivfun.som.security.service.TokenService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
 * Created by: jonathan
 * DateTime: 2018-02-25 14:24
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableTransactionManagement
class Request(val tokenService: TokenService) : WebSecurityConfigurerAdapter()
{

    @Bean
    @Throws(Exception::class)
    fun filterBean(): AuthFilter
    {
        val authAuthFilter: AuthFilter = AuthFilter(tokenService)
        authAuthFilter.setAuthenticationManager(super.authenticationManager())
        return authAuthFilter
    }

    override
    fun configure(http: HttpSecurity?)
    {
        http!!
        http
            .csrf()
            .disable()
            .exceptionHandling()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET,"/**").permitAll()
            .antMatchers(HttpMethod.PUT,"/**").permitAll()
            .antMatchers(HttpMethod.POST,"/**").permitAll()
            .antMatchers(HttpMethod.DELETE,"/**").permitAll()
            .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .exceptionHandling()

        http.addFilterBefore(filterBean(), UsernamePasswordAuthenticationFilter::class.java)
    }

}