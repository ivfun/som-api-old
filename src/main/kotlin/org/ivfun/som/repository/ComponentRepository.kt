package org.ivfun.som.repository

import org.ivfun.som.document.Component
import org.ivfun.som.usefull.validation.annotation.IsUniqueField
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by: jonathan
 * DateTime: 2018-02-12 16:03
 **/
interface ComponentRepository : MongoRepository<Component, String>
{
    @IsUniqueField
    fun findByDescription(description: String): List<Component>
}