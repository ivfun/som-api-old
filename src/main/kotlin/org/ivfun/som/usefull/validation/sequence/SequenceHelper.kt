package org.ivfun.som.usefull.validation.sequence
import kotlin.reflect.KProperty1

/**
 * Created by: jonathan
 * DateTime: 2018-02-24 23:20
 **/
class SequenceHelper
(
        val sequence:String?=null,
        val increment:Int?=1,
        val contains:Boolean?=false,
        val field : KProperty1<Any, *>?=null
)