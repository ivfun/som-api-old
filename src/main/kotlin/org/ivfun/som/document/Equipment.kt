package org.ivfun.som.document

import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by: jonathan
 * DateTime: 2018-02-11 03:55
 **/
@Document(collection = "equipment")
data class Equipment
(
        val id: String? = null,
        val id_client: String? = null,
        val id_model: String? = null,
        val serial_number: String? = null,
        val description: String? = null
)