package org.ivfun.som.document

import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by: jonathan
 * DateTime: 2018-02-11 04:01
 **/
@Document(collection = "Solution")
data class Solution
(
 val id: String? = null,
 val description: String? = null
)