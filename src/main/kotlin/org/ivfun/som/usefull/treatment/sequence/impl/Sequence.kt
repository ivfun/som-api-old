package org.ivfun.som.usefull.treatment.sequence.impl

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Created by: jonathan
 * DateTime: 2018-02-24 22:07
 **/
@Document(collection = "sequence")
class Sequence
(
    @Id
    val id: String? = null,
    @Indexed(unique = true)
    @Field(value = "name")
    val name: String? = null,
    val value: Long? = 0
)