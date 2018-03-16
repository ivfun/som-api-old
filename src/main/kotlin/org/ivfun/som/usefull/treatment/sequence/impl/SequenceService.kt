package org.ivfun.som.usefull.treatment.sequence.impl

import org.ivfun.som.usefull.treatment.sequence.SequenceRepository
import org.ivfun.som.usefull.treatment.sequence.annotation.AutoIncrement
import org.springframework.stereotype.Service
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.javaField

/**
 * Created by: jonathan
 * DateTime: 2018-02-24 22:19
 **/
@Service
class SequenceService(val repository: SequenceRepository)
{

    fun containsAutoIncrement(any: Any): SequenceHelper
    {
        var sequence: String = ""
        var increment: Int = 1
        var contains: Boolean = false
        var field: KProperty1<Any, *>? = null

        any.javaClass
                .kotlin
                .memberProperties
                .forEach { memberProperty ->
                    if (memberProperty.javaField!!.isAnnotationPresent(AutoIncrement::class.java))
                    {
                        sequence = memberProperty.javaField!!.getDeclaredAnnotation(AutoIncrement::class.java).sequence
                        increment = memberProperty.javaField!!.getDeclaredAnnotation(AutoIncrement::class.java).increment
                        contains = true
                        field = memberProperty

                    }
                }
        return SequenceHelper(sequence, increment, contains, field)
    }

    fun setNext(any: Any, helper: SequenceHelper)
    {
        val next: Long = next(helper.sequence!!, helper.increment!!)
        helper.field!!.javaField!!.trySetAccessible()
        helper.field.javaField!!.set(any, next)

    }

    private fun next(name: String, increment: Int): Long
    {
        val current: Sequence = getSequence(name)
        val value: Long = current.value!! + increment
        val next: Sequence = Sequence(current.id, current.name, value)
        repository.save(next)
        return value
    }

    private fun getSequence(name: String): Sequence
    {
        return if (!repository.findByName(name).isEmpty())
        {
            repository.findByName(name)[0]
        }
        else
        {
            Sequence(null, name, 0)
        }
    }
}

