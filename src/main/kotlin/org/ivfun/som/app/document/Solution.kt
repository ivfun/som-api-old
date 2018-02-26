package org.ivfun.som.app.document

import org.ivfun.som.usefull.validation.annotation.AutoIncrement
import org.ivfun.som.usefull.validation.annotation.IsRequiredToCreate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
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

        @Indexed(unique = true)
        @Field(value = "friendly_id")
        @AutoIncrement(sequence = "solution", increment = 1)
        val friendly_id: Long? = null,

        @IsRequiredToCreate
        @Field(value ="description" )
        val description: String? = null


)