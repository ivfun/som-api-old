package org.ivfun.som.service

import org.ivfun.som.document.ServiceOrder

/**
 * Created by: jonathan
 * DateTime: 2018-02-12 16:08
 **/
interface ServiceOrderService
{
    fun getAll(): Any

    fun save(serviceOrder: ServiceOrder): Any
}