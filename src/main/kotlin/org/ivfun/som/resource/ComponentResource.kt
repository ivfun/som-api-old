package org.ivfun.som.resource

import org.ivfun.som.document.Component
import org.ivfun.som.repository.ComponentRepository
import org.ivfun.som.resource.generic.ResponseGeneric
import org.ivfun.som.usefull.validation.ResponseFlow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by: jonathan
 * DateTime: 2018-02-11 02:50
 **/
@RestController
@RequestMapping(value = ["/component"])
class ComponentResource(val componentRepository: ComponentRepository, val responseFlow: ResponseFlow<Component>)
: ResponseGeneric<Component>(componentRepository,responseFlow)
{
    @GetMapping(value = ["/by-description/{description}"])
    fun findByDescription(@PathVariable description: String) = componentRepository.findByDescription(description)

}