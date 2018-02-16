package org.ivfun.som.document

import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by: jonathan
 * DateTime: 2018-02-11 03:18
 **/
@Document(collection = "service_order")
data class Model
(
 val id: String?= null,
 val description: String?= null
)