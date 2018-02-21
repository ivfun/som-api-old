package org.ivfun.som.usefull.validation.impl

import org.ivfun.som.usefull.validation.ResponseFlow
import org.ivfun.som.usefull.validation.model.Response
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

/**
 * Created by: jonathan
 * DateTime: 2018-02-17 06:43
 **/
@Service
class ResponseFlowImpl<T> : ResponseFlow<T>
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
            return Response(mapOf(Fields.getEntityName(any) to repository.save(any)!!)).get()
        }
        return toSave.get()
    }

    override
    fun update(repository: MongoRepository<T, String>, any: T): ResponseEntity<Any>
    {
        val toUpdate: Response = Validation.toUpdate(any!!)

        if (toUpdate.isValid())
        {
            return Response(repository.save(any)!!).get()
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
}