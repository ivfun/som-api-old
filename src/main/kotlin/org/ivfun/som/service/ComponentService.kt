package org.ivfun.som.service

import org.ivfun.som.document.Component
import org.springframework.http.ResponseEntity

/**
 * Created by: jonathan
 * DateTime: 2018-02-12 16:08
 **/
interface ComponentService
{
    fun getAll(): Any

    fun save(component: Component): ResponseEntity<Any>
}