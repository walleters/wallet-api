package configurations.api

import com.fasterxml.jackson.databind.SerializationFeature
import controllers.account
import controllers.wallet
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.jackson.jackson
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun Application.module() {
    install(DefaultHeaders)
    install(CallLogging)
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    wallet()
    account()
}

fun main() {
    embeddedServer(Netty, 8080, module = Application::module).start()
}