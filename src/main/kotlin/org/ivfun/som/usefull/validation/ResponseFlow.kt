package org.ivfun.som.usefull.validation

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.http.ResponseEntity

/**
 * Created by: jonathan
 * DateTime: 2018-02-17 06:43
 **/
interface ResponseFlow<T>
{
    fun findAll(repository: MongoRepository<T, String>, any: T): ResponseEntity<Any>

    fun createFlow(repository : MongoRepository<T, String>, any:T): ResponseEntity<Any>

    fun updateFlow(repository : MongoRepository<T, String>, any:T): ResponseEntity<Any>

    fun deleteFlow(repository: MongoRepository<T, String>, id: String): ResponseEntity<Any>
    fun findOne(repository: MongoRepository<T, String>, id: String): ResponseEntity<Any>
}