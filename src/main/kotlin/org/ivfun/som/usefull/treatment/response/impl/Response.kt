package org.ivfun.som.usefull.treatment.response.impl

import com.fasterxml.jackson.annotation.JsonIgnore
import org.ivfun.som.usefull.treatment.validation.obj.Validation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

/**
 * Created by: jonathan
 * DateTime: 2018-02-14 02:56
 **/
class Response
{
    @JsonIgnore
    val entity: Any
    val errors: Map<String, Any>

    constructor(entity: Any, errors: Map<String, Any>)
    {
        this.errors = errors
        this.entity = entity
    }

    constructor(entity: Any)
    {
        this.errors = mapOf(Validation.is_valid_key to true)
        this.entity = entity
    }

    @JsonIgnore
    fun get(): ResponseEntity<Any>
    {
        if (isValid())
        {
            return ResponseEntity(entity, HttpStatus.OK)
        }
        return ResponseEntity(errors, HttpStatus.NOT_ACCEPTABLE)
    }

    @JsonIgnore
    fun isValid(): Boolean
    {
        return try
        {
           return  errors[Validation.is_valid_key] as Boolean
        }
        catch (e: Exception)
        {
            false
        }
    }
}