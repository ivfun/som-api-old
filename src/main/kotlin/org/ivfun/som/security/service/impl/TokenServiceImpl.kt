package org.ivfun.som.security.service.impl

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.ivfun.som.app.document.User
import org.ivfun.som.security.service.TokenService
import org.ivfun.som.usefull.DateUTC
import org.ivfun.som.usefull.LocalDateTimeUtil
import org.springframework.stereotype.Service
import java.time.LocalDateTime

/**
 * Created by: jonathan
 * DateTime: 2018-02-25 18:20
 **/
@Service
class TokenServiceImpl : TokenService
{
    private val secret: String ="28064212"
    private val expired: String ="expired-in"
    private val expiration: Long =300L

    override
    fun generateToken(): Map<String, String>
    {
        val claims: MutableMap<String, Any> = mutableMapOf()
        claims[expired] = this.getExpiration()
        return mapOf("token" to generateToken(claims))
    }

    override
    fun generateToken(user:User): Map<String, String>
    {
        val claims: MutableMap<String, Any> = mutableMapOf()
        claims[expired] = this.getExpiration()
        claims["id"] = user.id!!
        claims["email"] = user.email!!
        claims["time_zone"] = user.time_zone!!
        claims["friendly_id"] = user.friendly_id!!
        return mapOf("token" to generateToken(claims))
    }

    private fun generateToken(claims: Map<String, Any>): String
    {
        return Jwts.builder()
                   .setClaims(claims)
                   .setExpiration(DateUTC.nowPlusLong(expiration))
                   .signWith(SignatureAlgorithm.HS512, secret)
                   .compact()
    }

    private fun getExpiration(): java.time.LocalDateTime =  LocalDateTimeUtil.now().plusSeconds(expiration)

    override
    fun check(token: String):Boolean
    {
        return try
        {
            val claims:Claims = getClaimsFromToken(token)
            val expired: LocalDateTime = LocalDateTimeUtil.toLocalDateTime(claims[expired] as Map<String, String>)
            val now: LocalDateTime = LocalDateTimeUtil.now()
            now.isBefore(expired)
        }
        catch (e:Exception)
        {
            false
        }
    }

    private fun getClaimsFromToken(token: String): Claims
    {
        return try
        {
            Jwts.parser()
                .setSigningKey(this.secret)
                .parseClaimsJws(token)
                .body

        }
        catch (e: Exception)
        {
            throw NullPointerException("invalid token to getClaimsFromToken")
        }
    }

}