package org.ivfun.som.resource

import org.ivfun.som.document.Component
import org.ivfun.som.repository.ComponentRepository
import org.ivfun.som.resource.generic.DefaultResource
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
: DefaultResource<Component>(componentRepository,responseFlow)
