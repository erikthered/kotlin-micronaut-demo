package me.erikthered

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("me.erikthered")
                .mainClass(Application.javaClass)
                .start()
    }
}