package me.erikthered

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import strikt.api.expectThat
import strikt.assertions.isEqualTo

object HelloControllerSpec: Spek({
    describe("HelloController") {
        var embeddedServer: EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        var client = HttpClient.create(embeddedServer.url)

        it("test /hello responds with 'Hello World'") {
            val resp = client.toBlocking().retrieve("/hello")
            expectThat(resp).isEqualTo("Hello World")
        }

        it("test /hello responds with 'Hello Steve'") {
            val resp = client.toBlocking().retrieve("/hello?name=Steve")
            expectThat(resp).isEqualTo("Hello Steve")
        }

        afterGroup {
            client.close()
            embeddedServer.close()
        }
    }
})