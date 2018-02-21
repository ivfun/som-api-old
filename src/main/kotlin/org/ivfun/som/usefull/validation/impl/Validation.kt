package org.ivfun.som.usefull.validation.impl

import org.ivfun.som.usefull.validation.annotation.IsRequiredToCreate
import org.ivfun.som.usefull.validation.annotation.IsRequiredToUpdate
import org.ivfun.som.usefull.validation.annotation.IsUniqueField
import org.ivfun.som.usefull.validation.model.Response
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.javaField

/**
 * Created by: jonathan
 * DateTime: 2018-02-15 23:31
 **/
object Validation
{
    fun toCreate(any: Any): Response
    {
        val mapOf: Map<String, ArrayList<String>> = mapOf("is_required_to_create" to makeValidation(any, IsRequiredToCreate::class.java))
        return Response(any, mapOf)
    }

    fun toUpdate(any: Any): Response
    {
        val mapOf: Map<String, ArrayList<String>> = mapOf("is_required_to_update" to makeValidation(any, IsRequiredToUpdate::class.java))
        return Response(any, mapOf)
    }

    private fun makeValidation(any: Any, annotation: Class<out Annotation>): ArrayList<String>
    {
        val field = ArrayList<String>()
        any.javaClass
           .kotlin
           .memberProperties
           .forEach { memberProperty ->
               try
               {
                   if (memberProperty.javaField!!.isAnnotationPresent(annotation))
                   {
                       val value: Any? = memberProperty.get(any)
                       if (isNullOrIsEmpty(value))
                       {
                           field.add(memberProperty.name)
                       }
                   }
               }
               catch (e: Exception)
               {
                   println("ué")
               }

           }
        return field
    }

    private fun isNullOrIsEmpty(value: Any?): Boolean
    {
        return value == null || value.toString().isEmpty()
    }
}