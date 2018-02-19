package org.ivfun.som

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SomApiApplication

fun main(args: Array<String>)
{
    SpringApplication.run(SomApiApplication::class.java, *args)
}
