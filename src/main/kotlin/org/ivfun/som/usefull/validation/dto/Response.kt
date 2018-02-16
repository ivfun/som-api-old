package org.ivfun.som.usefull.validation.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.ArrayList

/**
 * Created by: jonathan
 * DateTime: 2018-02-14 02:56
 **/
class Response
{
    @JsonIgnore
    val entity  : Any
    val errors  : Map<String, ArrayList<String>>

    constructor(entity: Any, errors: Map<String, ArrayList<String>>)
    {
        this.errors = errors
        this.entity = entity
    }

    constructor(entity: Any)
    {
        this.errors = mapOf()
        this.entity = entity
    }

    @JsonIgnore
    fun getResponse() : ResponseEntity<Any>
    {
        if(isValid())
        {
            return ResponseEntity(entity, HttpStatus.OK)
        }
        return ResponseEntity(this, HttpStatus.NOT_ACCEPTABLE)
    }

    @JsonIgnore
    fun isValid() : Boolean
    {
        var valid : Boolean = true
        return try
        {
            errors.forEach { k, v ->
                if (valid)
                {
                    valid = v.size==0
                }
            }

            valid
        }
        catch (e :Exception)
        {
            false
        }
    }
}