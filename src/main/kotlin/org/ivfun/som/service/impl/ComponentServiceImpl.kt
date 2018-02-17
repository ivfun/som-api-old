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
    fun getAll() : ResponseEntity<Any> = responseFlow.findAll(repository,Component())

    override
    fun save(component: Component) : ResponseEntity<Any> = responseFlow.saveFlow(repository, component)
}