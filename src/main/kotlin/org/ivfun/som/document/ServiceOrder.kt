package org.ivfun.som.document

import org.ivfun.som.enums.ServiceOrderStatus
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

/**
 * Created by: jonathan
 * DateTime: 2018-02-11 03:18
 **/
@Document(collection = "service_order")
data class ServiceOrder
(
        val id: String? = null,
        val id_equipment: String? = null,
        val nf_number: Long? = null,
        val dt_hr_utc_start: LocalDateTime? = null,
        val dt_hr_utc_end: LocalDateTime? = null,
        val status: ServiceOrderStatus? = ServiceOrderStatus.CLOSE
)