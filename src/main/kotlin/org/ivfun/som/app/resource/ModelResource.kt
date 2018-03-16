package org.ivfun.som.app.resource

import org.ivfun.som.app.document.Model
import org.ivfun.som.app.repository.ModelRepository
import org.ivfun.som.usefull.treatment.resource.GenericResource
import org.ivfun.som.usefull.treatment.response.ResponseTreatment
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by: jonathan
 * DateTime: 2018-03-13 11:03
 **/
@RestController
@RequestMapping(value = ["/model"])
class ModelResource(modelRepository: ModelRepository,
                    responseTreatment: ResponseTreatment<Model>)
    : GenericResource<Model>(modelRepository, responseTreatment)