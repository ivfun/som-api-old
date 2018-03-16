package org.ivfun.som.app.resource

import org.ivfun.som.app.document.Problem
import org.ivfun.som.app.repository.ProblemRepository
import org.ivfun.som.usefull.treatment.resource.GenericResource
import org.ivfun.som.usefull.treatment.response.ResponseTreatment
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by: jonathan
 * DateTime: 2018-03-13 11:03
 **/
@RestController
@RequestMapping(value = ["/problem"])
class ProblemResource(problemRepository: ProblemRepository,
                      responseTreatment: ResponseTreatment<Problem>)
    : GenericResource<Problem>(problemRepository, responseTreatment)