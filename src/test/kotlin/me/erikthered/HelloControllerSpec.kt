package me.erikthered

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.hamcrest.Matchers
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert

object HelloControllerSpec: Spek({
    describe("HelloController suite") {
        var embeddedServer: EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        var client = HttpClient.create(embeddedServer.url)

        it("test /hello responds with 'Hello World'") {
            val resp = client.toBlocking().retrieve("/hello")
            Assert.assertThat(resp, Matchers.comparesEqualTo("Hello World"))
        }

        afterGroup {
            client.close()
            embeddedServer.close()
        }
    }
})