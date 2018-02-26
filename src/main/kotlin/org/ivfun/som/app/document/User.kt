package org.ivfun.som.app.document

import org.ivfun.som.usefull.validation.annotation.AutoIncrement
import org.ivfun.som.usefull.validation.annotation.IsRequiredToCreate
import org.ivfun.som.usefull.validation.annotation.IsRequiredToUpdate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Created by: jonathan
 * DateTime: 2018-02-25 16:03
 **/
@Document(collection = "user")
data class User
(
        @Id
        @IsRequiredToUpdate
        val id: String? = null,

        @Indexed(unique = true)
        @Field(value = "friendly_id")
        @AutoIncrement(sequence = "user", increment = 1)
        val friendly_id: Long? = null,

        @IsRequiredToCreate
        @Indexed(unique = true)
        @Field(value = "email")
        val email: String? = null,

        @IsRequiredToCreate
        @Field(value = "password")
        val password: String? = null,

        @IsRequiredToCreate
        @Field(value = "name")
        val name: String? = null,

        @IsRequiredToCreate
        @Field(value = "time_zone")
        val time_zone: String? = null
)