package org.ivfun.som.document

import org.ivfun.som.usefull.validation.annotation.IsRequiredToCreate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Created by: jonathan
 * DateTime: 2018-02-11 04:01
 **/
@Document(collection = "solution")
data class Solution
(
        @Id
        val id: String? = null,
        @IsRequiredToCreate
        @Field(value ="description" )
        val description: String? = null
)