package me.erikthered

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import strikt.api.expectThat
import strikt.assertions.isEqualTo

object GoodbyeControllerSpec : Spek({
    describe("GoodbyeController") {
        var embeddedServer: EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        var client = HttpClient.create(embeddedServer.url)

        it("test /goodbye responds with 'Bye bye'") {
            val resp = client.toBlocking().retrieve("/goodbye")
            expectThat(resp).isEqualTo("Bye bye")
        }

        afterGroup {
            client.close()
            embeddedServer.close()
        }
    }
})