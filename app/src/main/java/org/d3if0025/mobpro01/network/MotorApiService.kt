package org.d3if0025.mobpro01.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.d3if0025.mobpro01.model.Motor
import org.d3if0025.mobpro01.model.OpStatus
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

private const val BASE_URL = "https://tangguhsatria.my.id/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MotorApiService {
    @GET("json.php")
    suspend fun getMotor(
        @Query("auth") userId: String
    ): List<Motor>

    @Multipart
    @POST("json.php")
    suspend fun postMotor(
        @Part("auth") userId: String,
        @Part("nama") nama: RequestBody,
        @Part("tahun") tahun: RequestBody,
        @Part("jenis") jenis: RequestBody,
        @Part image: MultipartBody.Part
    ): OpStatus

    @DELETE("json.php")
    suspend fun deleteMotor(
        @Query("auth") userId: String,
        @Query("id") id: String
    ): OpStatus
}

object MotorApi {
    val service: MotorApiService by lazy {
        retrofit.create(MotorApiService::class.java)
    }
    fun getMotorUrl(gambar: String): String {
        return "$BASE_URL$gambar"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }
