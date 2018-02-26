package org.ivfun.som.app.resource.generic

import org.ivfun.som.usefull.validation.ResponseFlow
import org.ivfun.som.usefull.validation.impl.obj.Fields
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Created by: jonathan
 * DateTime: 2018-02-20 16:02
 **/
open class GenericResource<T>(private val repository: MongoRepository<T,String>,
                              private val response: ResponseFlow<T>)
{
    @GetMapping(value = ["/fields-to-save"])
    open fun getFieldsToSave(any:T): Map<String, Any> = Fields.getFieldsToSave(any!!)

    @GetMapping()
    open fun findAll(): ResponseEntity<Any> = response.findAll(repository)

    @GetMapping(value = ["/{id}"])
    open fun findOne(@PathVariable id: String): ResponseEntity<Any> = response.findOne(repository, id)

    @PostMapping()
    open fun create(@RequestBody any: T): ResponseEntity<Any> = response.create(repository, any)

    @PutMapping()
    open fun update(@RequestBody any: T): ResponseEntity<Any> = response.update(repository, any)

    @DeleteMapping(value = ["/{id}"])
    open fun delete(@PathVariable id: String): ResponseEntity<Any> = response.delete(repository, id)
}