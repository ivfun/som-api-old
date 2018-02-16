package org.ivfun.som.resource
import org.ivfun.som.document.Component
import org.ivfun.som.service.ComponentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Created by: jonathan
 * DateTime: 2018-02-11 02:50
 **/
@RestController
@RequestMapping(value = ["/component"])
class ComponentResource(val service: ComponentService)
{
    @GetMapping()
    fun get(): Any = service.getAll()

    @PostMapping()
    fun post(@RequestBody component: Component) : ResponseEntity<Any> = service.save(component)
}