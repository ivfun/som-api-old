package org.ivfun.som.resource
import org.ivfun.som.document.Component
import org.ivfun.som.service.ComponentService
import org.ivfun.som.usefull.validation.impl.Fields
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
    @GetMapping(value = ["/fields-to-save"])
    fun getFieldsToSave():Map<String,Any> = Fields.getFieldsToSave(Component())

    @GetMapping()
    fun findAll():ResponseEntity<Any> = service.findAll()

    @GetMapping(value = ["/{id}"])
    fun findOne(@PathVariable id : String):ResponseEntity<Any> = service.findOne(id)

    @PostMapping()
    fun create(@RequestBody component: Component):ResponseEntity<Any>  = service.create(component)

    @PutMapping()
    fun update(@RequestBody component: Component):ResponseEntity<Any>  = service.update(component)

    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable id : String):ResponseEntity<Any>  = service.delete(id)

}