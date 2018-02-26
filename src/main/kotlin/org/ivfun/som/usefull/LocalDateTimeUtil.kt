package org.ivfun.som.usefull

import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.ZonedDateTime

/**
 * Created by: jonathan
 * DateTime: 2018-02-11 04:22
 **/
object LocalDateTimeUtil
{
    private val zoneUTC: ZonedDateTime = ZonedDateTime.now(ZoneOffset.UTC)

    fun now(): LocalDateTime = zoneUTC.toLocalDateTime()

    fun timezone(i: Long): LocalDateTime = zoneUTC.toLocalDateTime().plusHours(i)

    fun timezone(localDateTime: LocalDateTime, i: Long): LocalDateTime = localDateTime.plusHours(i)

    fun toLocalDateTime(any: Map<String,String>): LocalDateTime
    {
        return try
        {
            val year:Int = any["year"].toString().toInt()
            val month:Int = any["monthValue"].toString().toInt()
            val day:Int = any["dayOfMonth"].toString().toInt()
            val hour:Int = any["hour"].toString().toInt()
            val minute:Int = any["minute"].toString().toInt()
            val second:Int = any["second"].toString().toInt()
            LocalDateTime.of(year, month, day, hour, minute, second)
        }
        catch (e:Exception)
        {
            throw Exception("invalid map to convert to localdatetime")
        }
    }
}