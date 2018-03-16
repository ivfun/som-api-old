package org.ivfun.som.app.repository

import org.ivfun.som.app.document.Model
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by: jonathan
 * DateTime: 2018-03-13 11:01
 **/
interface ModelRepository : MongoRepository<Model, String>
