package org.ivfun.som.document

import org.ivfun.som.usefull.validation.annotation.IsRequiredToCreate
import org.ivfun.som.usefull.validation.annotation.IsRequiredToUpdate
import org.ivfun.som.usefull.validation.annotation.IsUniqueField
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Created by: jonathan
 * DateTime: 2018-02-11 04:01
 **/
@Document(collection = "component")
data class Component
(
        @Id
        @IsRequiredToUpdate
        val id: String? = null,

        @Field(value = "description")
        @IsRequiredToCreate
        @IsUniqueField
        val description: String? = null,

        @Field(value = "other")
        @IsRequiredToCreate
        val other: String? = null
)