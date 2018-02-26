package org.ivfun.som.app.repository

import org.ivfun.som.app.document.Solution
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by: jonathan
 * DateTime: 2018-02-12 16:03
 **/
interface SolutionRepository : MongoRepository<Solution, String>
{

}