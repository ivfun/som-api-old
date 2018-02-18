package org.ivfun.som.service

import org.ivfun.som.document.Component
import org.springframework.http.ResponseEntity

/**
 * Created by: jonathan
 * DateTime: 2018-02-12 16:08
 **/
interface ComponentService
{
    fun findOne(id: String): ResponseEntity<Any>

    fun findAll(): ResponseEntity<Any>

    fun create(component: Component): ResponseEntity<Any>

    fun update(component: Component): ResponseEntity<Any>

    fun delete(id: String): ResponseEntity<Any>
}