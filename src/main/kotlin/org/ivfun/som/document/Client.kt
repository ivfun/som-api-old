package org.ivfun.som.document

import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by: jonathan
 * DateTime: 2018-02-11 03:51
 **/
@Document(collection = "client")
class Client
(
 val id: String?= null,
 val cnpj: String?= null,
 val description: String?= null
)