package org.ivfun.som.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.ivfun.som.usefull.validation.annotation.IsRequiredToSave

/**
 * Created by: jonathan
 * DateTime: 2018-02-11 04:01
 **/
@Document(collection = "component")
data class Component
(
    @Id
    val id: String? = null,

    @Field(value = "description")
    @IsRequiredToSave
    val description: String? = null,

    @Field(value = "other")
    @IsRequiredToSave
    val other: String? = null
)