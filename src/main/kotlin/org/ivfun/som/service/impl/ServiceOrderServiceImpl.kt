package org.ivfun.som.service.impl

import org.ivfun.som.document.ServiceOrder
import org.ivfun.som.repository.ServiceOrderRepository
import org.ivfun.som.service.ServiceOrderService
import org.springframework.stereotype.Service

/**
 * Created by: jonathan
 * DateTime: 2018-02-12 16:07
 **/
@Service
class ServiceOrderServiceImpl(val repository: ServiceOrderRepository)
: ServiceOrderService
{
    override
    fun getAll() : Any = mapOf("ordem_servico" to repository.findAll())

    override
    fun save(serviceOrder: ServiceOrder) : Any = repository.save(serviceOrder)
}