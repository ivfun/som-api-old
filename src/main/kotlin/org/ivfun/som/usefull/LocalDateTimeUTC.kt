package org.ivfun.som.usefull

import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.ZonedDateTime

/**
 * Created by: jonathan
 * DateTime: 2018-02-11 04:22
 **/
class LocalDateTimeUTC
{
    private val zonedDateTime: ZonedDateTime = ZonedDateTime.now(ZoneOffset.UTC)

    /**
     * Getting coordinated universal time
     */
    fun now(): LocalDateTime = zonedDateTime.toLocalDateTime()

    /**
     * Setting timezone in coordinated universal time
     */
    fun timezone(i:Long): LocalDateTime = zonedDateTime.toLocalDateTime().plusHours(i)

    /**
     * Setting timezone in localDateTine
     */
    fun timezone(localDateTime: LocalDateTime, i:Long): LocalDateTime = localDateTime.plusHours(i)
}