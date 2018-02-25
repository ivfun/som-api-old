package org.ivfun.som.security

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by: jonathan
 * DateTime: 2018-02-25 14:16
 **/

class AuthFilter : UsernamePasswordAuthenticationFilter()
{
    @Throws(IOException::class, ServletException::class)
    override
    fun doFilter(servletRequest: ServletRequest?, servletResponse: ServletResponse?, filter: FilterChain?)
    {
        val response:HttpServletResponse = servletResponse as HttpServletResponse
        val request:HttpServletRequest = servletRequest as HttpServletRequest

        response.setHeader("Access-Control-Allow-Origin", "*")
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH")
        response.setHeader("Access-Control-Max-Age", "3600")
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Accept-Encoding, Content-Encoding")

        filter!!.doFilter(request, response)
    }
}