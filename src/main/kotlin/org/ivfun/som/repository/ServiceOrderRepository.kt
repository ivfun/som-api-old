package org.ivfun.som.repository

import org.ivfun.som.document.ServiceOrder
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by: jonathan
 * DateTime: 2018-02-12 16:03
 **/
interface ServiceOrderRepository : MongoRepository<ServiceOrder, String>
{
}