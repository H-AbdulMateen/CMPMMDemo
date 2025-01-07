package com.abdulmateen.cmpmmdemo.feature.products.data.network.ktor

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.fullPath
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class FakeKtorProductDataSource {
    companion object Factory{
        fun build(type: FakeProductDataSourceResponseType): RemoteProductsDataSource{
            val mockEngine = HttpClient(MockEngine){
                expectSuccess = false
                install(ContentNegotiation) {
                    json(Json {
                        explicitNulls = false
                        ignoreUnknownKeys = true
                        isLenient = true
                        prettyPrint = true
                        encodeDefaults = true
                        classDiscriminator = "#class"
                    })
                }
                engine {
                    addHandler { request ->
                        when (request.url.fullPath) {
                            "/products" -> {
                                when(type){
                                    FakeProductDataSourceResponseType.SuccessData -> {
                                        respond(
                                            content = FakeProductDataGenerator.jsonData,
                                            status = HttpStatusCode.OK,
                                            headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                                        )
                                    }
                                    FakeProductDataSourceResponseType.Empty -> {
                                        respond(
                                            content = FakeProductDataGenerator.empty,
                                            status = HttpStatusCode.OK,
                                            headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                                        )
                                    }
                                }

                            }
                            else -> error("Unhandled request: ${request.url.fullPath}")
                        }
                    }
                }
            }
            return KtorProductsDataSource(mockEngine)
        }
    }
}