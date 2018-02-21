package org.ivfun.som.usefull.validation.annotation

/**
 * Created by: jonathan
 * DateTime: 2018-02-14 03:25
 **/
@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class IsUniqueField
