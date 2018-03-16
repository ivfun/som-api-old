package org.ivfun.som.app.repository

import org.ivfun.som.app.document.Problem
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by: jonathan
 * DateTime: 2018-03-13 11:01
 **/
interface ProblemRepository : MongoRepository<Problem, String>
