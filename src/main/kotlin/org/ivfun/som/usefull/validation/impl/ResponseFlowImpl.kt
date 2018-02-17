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
    fun findAll(repository : MongoRepository<T, String>, any:T): ResponseEntity<Any>
    {
        val mapOf = mapOf(Fields.getEntityName(any!!).plus('s') to repository.findAll())
        return Response(mapOf).getResponse()
    }

    override
    fun saveFlow(repository : MongoRepository<T, String>, any:T): ResponseEntity<Any>
    {
        val toSave: Response = Validation.toSave(any!!)

        if (toSave.isValid())
        {
            return Response(repository.save(any)!!).getResponse()
        }
        return toSave.getResponse()
    }
}