package org.ivfun.som.usefull.treatment.validation.obj

import org.ivfun.som.usefull.treatment.validation.annotation.IsRequiredToCreate
import org.springframework.data.mongodb.core.index.Indexed
import java.util.*
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.javaField

object Fields
{
    fun getFieldsToSave(any: Any): Map<String, Any>
    {
        return getFields(any, IsRequiredToCreate::class.java, "required_fields_to_save")
    }

    fun getFieldsUnique(any: Any): Map<String, Any>
    {
        return getFields(any, Indexed::class.java, "unique_fields")
    }

    private fun getFields(any: Any, annotation: Class<out Annotation>, key: String): Map<String, Any>
    {
        val field = ArrayList<String>()
        any.javaClass
                .kotlin
                .memberProperties
                .forEach { memberProperty ->
                    if (memberProperty.javaField!!.isAnnotationPresent(annotation))
                    {
                        field.add(memberProperty.name)
                    }
                }
        return mapOf("entity" to getEntityName(any), key to field)
    }

    fun getEntityName(any: Any): String
    {
        val list: List<String> = any.javaClass.toString().split('.')
        return list.last().toLowerCase()
    }
}