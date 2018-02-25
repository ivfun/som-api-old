package org.ivfun.som.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
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
class RequestConfiguration: WebSecurityConfigurerAdapter()
{

    @Bean
    @Throws(Exception::class)
    fun filterBean(): AuthFilter
    {
        val authAuthFilter: AuthFilter = AuthFilter()
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
            .antMatchers("/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .exceptionHandling()

        http.addFilterBefore(filterBean(), UsernamePasswordAuthenticationFilter::class.java)
    }

}