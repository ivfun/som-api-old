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
        val toFindOne:T = repository.findOne(id)

        if (toFindOne != null)
        {
            return Response(toFindOne).get()
        }
        val mapOf: MutableMap<String,Any> = mutableMapOf()
        mapOf["id"]  = id
        mapOf["not_found"]  = true
        return Response(mapOf).get()
    }

    override
    fun findAll(repository : MongoRepository<T, String>, any:T): ResponseEntity<Any>
    {
        val mapOf = mapOf(Fields.getEntityName(any!!).plus('s') to repository.findAll())
        return Response(mapOf).get()
    }

    override
    fun createFlow(repository : MongoRepository<T, String>, any:T): ResponseEntity<Any>
    {
        val toSave: Response = Validation.toCreate(any!!)

        if (toSave.isValid())
        {
            return Response(repository.save(any)!!).get()
        }
        return toSave.get()
    }

    override
    fun updateFlow(repository: MongoRepository<T, String>, any: T): ResponseEntity<Any>
    {
        val toUpdate: Response = Validation.toUpdate(any!!)

        if (toUpdate.isValid())
        {
            return Response(repository.save(any)!!).get()
        }
        return toUpdate.get()
    }

    override
    fun deleteFlow(repository: MongoRepository<T, String>, id: String): ResponseEntity<Any>
    {
        val toDelete:T = repository.findOne(id)
        val mapOf: MutableMap<String,Any> = mutableMapOf()
        mapOf["id"]  = id
        if (toDelete != null)
        {
            repository.delete(id)
            mapOf["deleted"] =  true
        }
        else
        {
            mapOf["deleted"]  = false
            mapOf["cause"] = "not found"
        }
        return Response(mapOf).get()
    }
}