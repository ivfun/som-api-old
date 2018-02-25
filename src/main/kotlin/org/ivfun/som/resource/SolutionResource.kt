package org.ivfun.som.resource

import org.ivfun.som.document.Solution
import org.ivfun.som.repository.SolutionRepository
import org.ivfun.som.resource.generic.DefaultResource
import org.ivfun.som.usefull.validation.ResponseFlow
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by: jonathan
 * DateTime: 2018-02-20 15:20
 **/
@RestController
@RequestMapping(value = ["/solution"])
class SolutionResource(val solutionRepository: SolutionRepository, val responseFlow: ResponseFlow<Solution>)
: DefaultResource<Solution>(solutionRepository,responseFlow)
