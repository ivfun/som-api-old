package org.ivfun.som.service.impl

import org.ivfun.som.document.Component
import org.ivfun.som.repository.ComponentRepository
import org.ivfun.som.service.ComponentService
import org.ivfun.som.usefull.validation.ResponseFlow
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

/**
 * Created by: jonathan
 * DateTime: 2018-02-12 16:07
 **/
@Service
class ComponentServiceImpl(val repository: ComponentRepository,
                           val responseFlow: ResponseFlow<Component>)
: ComponentService
{
    override
    fun findOne(id : String):ResponseEntity<Any> = responseFlow.findOne(repository,id)

    override
    fun findAll():ResponseEntity<Any> = responseFlow.findAll(repository,Component())

    override
    fun create(component: Component):ResponseEntity<Any> = responseFlow.createFlow(repository, component)

    override
    fun update(component: Component): ResponseEntity<Any> = responseFlow.updateFlow(repository, component)

    override
    fun delete(id : String): ResponseEntity<Any> = responseFlow.deleteFlow(repository,id)
}