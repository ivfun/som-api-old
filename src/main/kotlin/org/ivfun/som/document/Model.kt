package org.ivfun.som.document

import org.ivfun.som.usefull.validation.annotation.AutoIncrement
import org.ivfun.som.usefull.validation.annotation.IsRequiredToCreate
import org.ivfun.som.usefull.validation.annotation.IsRequiredToUpdate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Created by: jonathan
 * DateTime: 2018-02-11 03:18
 **/
@Document(collection = "model")
data class Model
(
        @Id
        @IsRequiredToUpdate
        val id: String? = null,

        @Indexed(unique = true)
        @Field(value = "friendly_id")
        @AutoIncrement(sequence = "model", increment = 1)
        val friendly_id: Long? = null,

        @IsRequiredToCreate
        @Indexed(unique = true)
        @Field(value = "description")
        val description: String? = null
)