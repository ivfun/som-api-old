package org.ivfun.som.usefull.treatment.validation.obj

import org.ivfun.som.usefull.treatment.response.impl.Response
import org.ivfun.som.usefull.treatment.validation.ErrorKey
import org.springframework.http.ResponseEntity

object Errors
{

    fun get(details: String, any: Any): ResponseEntity<Any>
    {
        val mapOf: MutableMap<String, Any> = mutableMapOf()
        val cause: ErrorKey = getCause(details)
        mapOf[Validation.is_valid_key] = false
        mapOf[cause.toString().toLowerCase()] = true
        mapOf["fields"] = getFields(cause, any)
        mapOf["details"] = details
        return Response("invalid", mapOf.toMap()).get()
    }

    private fun getFields(cause: ErrorKey, any: Any): Map<String, Any>
    {
        return when (cause)
        {
            ErrorKey.DUPLICATE_KEY_EXCEPTION ->
            {
                Fields.getFieldsUnique(any)
            }
            else ->
            {
                mapOf<String, String>()
            }
        }

    }

    private fun getCause(details: String): ErrorKey
    {
        if (details.contains("DuplicateKeyException"))
        {
            return ErrorKey.DUPLICATE_KEY_EXCEPTION
        }
        return ErrorKey.GENERIC_EXCEPTION
    }
}