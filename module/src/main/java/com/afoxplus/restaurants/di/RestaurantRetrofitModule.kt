package com.afoxplus.restaurants.di

import android.content.Context
import android.os.Build
import com.afoxplus.network.annotations.MockService
import com.afoxplus.network.interceptors.BaseInterceptor
import com.afoxplus.uikit.extensions.convertToString
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Invocation
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class RestaurantRetrofitModule {

    @RestaurantBaseURL
    @Provides
    fun provideBaseUrl(): String = "https://3rc0fxqgwk.execute-api.us-east-1.amazonaws.com/dev/"

    @RestaurantInterceptor
    @Provides
    fun provideInterceptor(
        @ApplicationContext appContext: Context
    ): Interceptor = BaseInterceptor(
        context = appContext
    ) { chain: Interceptor.Chain ->
        val request = chain.request()
        val invocation: Invocation? = request.tag(Invocation::class.java)
        invocation?.method()?.let { method ->
            val mockService = method.getAnnotation(MockService::class.java)
            if (mockService != null && mockService.jsonFileName.isNotEmpty()) {
                return@BaseInterceptor setUpMockInterceptor(
                    mockService.jsonFileName,
                    appContext,
                    chain
                )
            } else return@BaseInterceptor setUpInterceptor(chain)
        } ?: return@BaseInterceptor setUpInterceptor(chain)
    }

    @RestaurantRetrofit
    @Provides
    fun providerRetrofit(
        @RestaurantBaseURL baseUrl: String,
        @RestaurantOkHttpClient client: OkHttpClient,
        @RestaurantGsonConverterFactory gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @RestaurantOkHttpClient
    @Provides
    fun providerOkHttpClient(
        @RestaurantHttpLoggingInterceptor httpLoggingInterceptor: HttpLoggingInterceptor,
        @RestaurantInterceptor apiInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(apiInterceptor)
            .build()
    }

    @RestaurantGsonConverterFactory
    @Provides
    fun providerGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @RestaurantHttpLoggingInterceptor
    @Provides
    fun providerHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    private fun setUpMockInterceptor(
        jsonFileName: String,
        context: Context,
        chain: Interceptor.Chain
    ): Response {
        val request = chain.request()
        return Response.Builder()
            .request(request)
            .protocol(Protocol.HTTP_1_1)
            .message("")
            .code(200)
            .body(getMockResponseBody(context, jsonFileName))
            .build()
    }

    private fun setUpInterceptor(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
            .addHeader("device", "${Build.MANUFACTURER} ${Build.MODEL}")
            .build()
        return chain.proceed(requestBuilder)
    }

    private fun getMockResponseBody(context: Context, jsonFileName: String): ResponseBody? {
        val inputStream = context.assets.open(jsonFileName)
        return inputStream.convertToString()?.toResponseBody(BaseInterceptor.JSON_MEDIA_TYPE)
    }
}