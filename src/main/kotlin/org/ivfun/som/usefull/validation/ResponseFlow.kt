package org.ivfun.som.usefull.validation

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.http.ResponseEntity

/**
 * Created by: jonathan
 * DateTime: 2018-02-17 06:43
 **/
interface ResponseFlow<T>
{
    fun findOne(repository: MongoRepository<T, String>, id: String): ResponseEntity<Any>

    fun findAll(repository: MongoRepository<T, String>): ResponseEntity<Any>

    fun create(repository: MongoRepository<T, String>, any: T): ResponseEntity<Any>

    fun update(repository: MongoRepository<T, String>, any: T): ResponseEntity<Any>

    fun delete(repository: MongoRepository<T, String>, id: String): ResponseEntity<Any>
}