package org.ivfun.som.usefull.validation.sequence

import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by: jonathan
 * DateTime: 2018-02-12 16:03
 **/
interface SequenceRepository : MongoRepository<Sequence, String>
{
    fun findByName(name:String) : List<Sequence>
}