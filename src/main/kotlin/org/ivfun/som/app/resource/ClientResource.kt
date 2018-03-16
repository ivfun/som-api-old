package org.ivfun.som.app.resource

import org.ivfun.som.app.document.Client
import org.ivfun.som.app.repository.ClientRepository
import org.ivfun.som.usefull.treatment.resource.GenericResource
import org.ivfun.som.usefull.treatment.response.ResponseTreatment
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by: jonathan
 * DateTime: 2018-03-13 11:03
 **/
@RestController
@RequestMapping(value = ["/client"])
class ClientResource(clientRepository: ClientRepository,
                     responseTreatment: ResponseTreatment<Client>)
    : GenericResource<Client>(clientRepository, responseTreatment)