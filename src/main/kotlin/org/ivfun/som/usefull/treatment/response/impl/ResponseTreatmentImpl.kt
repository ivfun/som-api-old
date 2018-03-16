package org.ivfun.som.usefull.treatment.response.impl

import org.ivfun.som.usefull.treatment.response.ResponseTreatment
import org.ivfun.som.usefull.treatment.sequence.impl.SequenceHelper
import org.ivfun.som.usefull.treatment.sequence.impl.SequenceService
import org.ivfun.som.usefull.treatment.sequence.obj.SequenceFriendlyId
import org.ivfun.som.usefull.treatment.validation.obj.Errors
import org.ivfun.som.usefull.treatment.validation.obj.Fields
import org.ivfun.som.usefull.treatment.validation.obj.Validation
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

/**
 * Created by: jonathan
 * DateTime: 2018-02-17 06:43
 **/
@Service
class ResponseTreatmentImpl<T>(val sequence: SequenceService) : ResponseTreatment<T>
{

    override
    fun findOne(repository: MongoRepository<T, String>, id: String): ResponseEntity<Any>
    {
        val toFindOne: T = repository.findOne(id)
        val mapOf: MutableMap<String, Any> = mutableMapOf()

        if (toFindOne == null)
        {
            mapOf["id"] = id
            mapOf["not_found"] = true
            return Response(mapOf).get()
        }
        return Response(mapOf(Fields.getEntityName(toFindOne) to toFindOne)).get()
    }

    override
    fun findAll(repository: MongoRepository<T, String>): ResponseEntity<Any>
    {
        val findAll: List<T> = repository.findAll()
        val mapOf: MutableMap<String, Any> = mutableMapOf()
        if (findAll.isEmpty())
        {
            mapOf["id"] = "\u2200"
            mapOf["not_found"] = true
            return Response(mapOf).get()
        }
        else
        {
            mapOf[Fields.getEntityName(findAll[0]!!).plus('s')] = findAll
        }
        return Response(mapOf).get()
    }

    override
    fun create(repository: MongoRepository<T, String>, any: T): ResponseEntity<Any>
    {
        val toSave: Response = Validation.toCreate(any!!)

        if (toSave.isValid())
        {
            val sequenceHelper: SequenceHelper = sequence.containsAutoIncrement(any)
            if (sequenceHelper.contains!!)
            {
                sequence.setNext(any, sequenceHelper)
            }
            return trySave(repository, any)
        }
        return toSave.get()
    }

    override
    fun update(repository: MongoRepository<T, String>, any: T): ResponseEntity<Any>
    {
        val toUpdate: Response = Validation.toUpdate(any!!)

        SequenceFriendlyId.setFriendlyId(repository, any)

        if (toUpdate.isValid())
        {
            return trySave(repository, any)
        }
        return toUpdate.get()
    }

    override
    fun delete(repository: MongoRepository<T, String>, id: String): ResponseEntity<Any>
    {
        val find: T = repository.findOne(id)
        val mapOf: MutableMap<String, Any> = mutableMapOf()
        val toDelete: Boolean = find != null
        mapOf["id"] = id
        mapOf["deleted"] = toDelete
        if (toDelete)
        {
            repository.delete(id)
        }
        return Response(mapOf).get()
    }

    private fun trySave(repository: MongoRepository<T, String>, any: T): ResponseEntity<Any>
    {
        return try
        {
            Response(mapOf(Fields.getEntityName(any!!) to repository.save(any)!!)).get()
        }
        catch (e: Exception)
        {
            Errors.get(e.message!!, any!!)
        }
    }
}