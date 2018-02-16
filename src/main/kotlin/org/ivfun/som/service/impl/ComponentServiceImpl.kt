package org.ivfun.som.service.impl

import org.ivfun.som.document.Component
import org.ivfun.som.repository.ComponentRepository
import org.ivfun.som.service.ComponentService
import org.ivfun.som.usefull.validation.Validation
import org.ivfun.som.usefull.validation.dto.Response
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

/**
 * Created by: jonathan
 * DateTime: 2018-02-12 16:07
 **/
@Service
class ComponentServiceImpl(val repository: ComponentRepository)
: ComponentService
{
    override
    fun getAll() : Any = mapOf("components" to repository.findAll())

    override
    fun save(component: Component) : ResponseEntity<Any>
    {
        val toSave:Response = Validation.toSave(component)

        if (toSave.isValid())
        {
            return Response(repository.save(component)).getResponse()
        }
        return toSave.getResponse()
    }

}