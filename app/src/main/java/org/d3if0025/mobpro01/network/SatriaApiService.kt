package org.d3if0025.mobpro01.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if0025.mobpro01.model.Satria
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.telutizen.my.id/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface SatriaApiService {
    @GET("satria")
    suspend fun getSatria(): List<Satria>
}

object SatriaApi {
    val service: SatriaApiService by lazy {
        retrofit.create(SatriaApiService::class.java)
    }

    fun getSatriaUrl(gambar: String): String {
        return "$BASE_URL$gambar"
    }
}
enum class ApiStatus { LOADING, SUCCESS, FAILED }