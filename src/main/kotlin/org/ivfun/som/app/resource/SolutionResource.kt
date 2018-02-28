package org.ivfun.som.app.resource

import org.ivfun.som.app.document.Solution
import org.ivfun.som.app.repository.SolutionRepository
import org.ivfun.som.usefull.treatment.resource.GenericResource
import org.ivfun.som.usefull.treatment.response.ResponseTreatment
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by: jonathan
 * DateTime: 2018-02-20 15:20
 **/
@RestController
@RequestMapping(value = ["/solution"])
class SolutionResource(solutionRepository: SolutionRepository,
                       responseTreatment: ResponseTreatment<Solution>)
: GenericResource<Solution>(solutionRepository, responseTreatment)