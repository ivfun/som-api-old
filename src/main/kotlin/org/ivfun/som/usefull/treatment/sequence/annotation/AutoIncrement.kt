package org.ivfun.som.usefull.treatment.sequence.annotation

/**
 * Created by: jonathan
 * DateTime: 2018-02-14 03:25
 **/
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class AutoIncrement
(
    val sequence: String,
    val increment: Int
)


