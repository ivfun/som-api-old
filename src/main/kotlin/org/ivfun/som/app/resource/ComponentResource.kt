package org.ivfun.som.app.resource

import org.ivfun.som.app.document.Component
import org.ivfun.som.app.repository.ComponentRepository
import org.ivfun.som.app.resource.generic.GenericResource
import org.ivfun.som.usefull.validation.ResponseFlow
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by: jonathan
 * DateTime: 2018-02-11 02:50
 **/
@RestController
@RequestMapping(value = ["/component"])
class ComponentResource(val componentRepository: ComponentRepository, val responseFlow: ResponseFlow<Component>)
: GenericResource<Component>(componentRepository,responseFlow)
