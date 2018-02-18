package org.ivfun.som.usefull.validation.impl

import org.ivfun.som.usefull.validation.annotation.IsRequiredToCreate
import java.util.ArrayList
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.javaField

object Fields
{
    fun getFieldsToSave(any: Any): Map<String, Any>
    {
       return getFields(any, IsRequiredToCreate::class.java )
    }

    private fun getFields(any: Any, annotation: Class<out Annotation>): Map<String, Any>
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
                            field.add(memberProperty.name)
                        }
                    }
                    catch (e: Exception)
                    {
                        println("ué")
                    }

                }


        return  mapOf("entity" to  getEntityName(any),"required_fields_to_save" to field)
    }

    fun getEntityName(any: Any) : String
    {
        val list :List<String> = any.javaClass.toString().split('.')
        return list.last().toLowerCase()
    }
}