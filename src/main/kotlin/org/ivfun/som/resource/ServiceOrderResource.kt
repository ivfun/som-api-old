package org.ivfun.som.resource
import org.ivfun.som.document.ServiceOrder
import org.ivfun.som.service.ServiceOrderService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by: jonathan
 * DateTime: 2018-02-11 02:50
 **/
@RestController
@RequestMapping(value = ["/service-order"])
class ServiceOrderResource (val service: ServiceOrderService)
{
    @GetMapping()
    fun get(): Any = service.getAll()

    @PostMapping()
    fun post(serviceOrder: ServiceOrder) = service.save(serviceOrder)
}