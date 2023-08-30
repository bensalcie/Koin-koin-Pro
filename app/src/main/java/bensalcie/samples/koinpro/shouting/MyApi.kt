package bensalcie.samples.koinpro.shouting

import retrofit2.http.GET

interface MyApi {
    @GET("my/endpoint")
    fun callApi()
}