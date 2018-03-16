package org.ivfun.som.app.resource

import org.ivfun.som.app.document.Component
import org.ivfun.som.app.repository.ComponentRepository
import org.ivfun.som.usefull.treatment.resource.GenericResource
import org.ivfun.som.usefull.treatment.response.ResponseTreatment
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by: jonathan
 * DateTime: 2018-02-11 02:50
 **/
@RestController
@RequestMapping(value = ["/component"])
class ComponentResource(componentRepository: ComponentRepository,
                        responseTreatment: ResponseTreatment<Component>)
    : GenericResource<Component>(componentRepository, responseTreatment)
