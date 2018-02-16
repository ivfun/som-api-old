package org.ivfun.som.usefull.validation

import org.ivfun.som.usefull.validation.annotation.IsRequiredToSave
import org.ivfun.som.usefull.validation.dto.Response
import java.util.ArrayList
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.javaField

/**
 * Created by: jonathan
 * DateTime: 2018-02-15 23:31
 **/
object Validation
{
    fun toSave(any: Any) : Response
    {
        val mapOf:Map<String, ArrayList<String>> = mapOf("is_required_to_save" to makeValidation(any, IsRequiredToSave::class.java))
        return Response(any, mapOf)
    }

    private fun makeValidation(any: Any, annotation: Class<out Annotation>) : ArrayList<String>
    {
        val field = ArrayList<String>()
        any.javaClass
           .kotlin
           .memberProperties
           .forEach{ memberProperty ->
               try
               {
                   if (memberProperty.javaField!!.isAnnotationPresent(annotation))
                   {
                       if (memberProperty.get(any) == null)
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
}