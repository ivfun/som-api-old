package org.ivfun.som.usefull.treatment.sequence.obj

import org.springframework.data.mongodb.repository.MongoRepository
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.javaField

object SequenceFriendlyId
{
    fun <T> setFriendlyId(repository: MongoRepository<T, String>, any: T)
    {
        val findOne: T = repository.findOne(getId(any!!))
        set(any, findOne!!)
    }

    private fun set(any: Any, findOne: Any)
    {
        val get: Long = getFriendlyId(findOne)

        any.javaClass
                .kotlin
                .memberProperties
                .forEach { member ->
                    if (member.name == "friendly_id")
                    {
                        member.javaField!!.trySetAccessible()
                        member.javaField!!.set(any, get)
                    }
                }
    }

    private fun getId(any: Any): String
    {
        var get: String = ""

        any.javaClass.kotlin.memberProperties.stream().forEach { k ->
            if (k.name == "id")
            {
                get = k.get(any) as String
            }
        }

        return get
    }


    private fun getFriendlyId(any: Any): Long
    {
        var get: Long = 0

        any.javaClass.kotlin.memberProperties.stream().forEach { k ->
            if (k.name == "friendly_id")
            {
                get = k.get(any) as Long
            }
        }

        return get
    }

}

