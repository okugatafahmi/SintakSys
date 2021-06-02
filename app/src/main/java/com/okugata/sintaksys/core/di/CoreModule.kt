package com.okugata.sintaksys.core.di

import com.okugata.sintaksys.core.data.SintaksysRepository
import com.okugata.sintaksys.core.data.source.remote.RemoteDataSource
import com.okugata.sintaksys.core.data.source.remote.network.ApiService
import com.okugata.sintaksys.domain.repository.ISintaksysRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://asia-southeast2-capstone-314601.cloudfunctions.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { RemoteDataSource(get()) }
    single<ISintaksysRepository> {
        SintaksysRepository(
            get()
        )
    }
}