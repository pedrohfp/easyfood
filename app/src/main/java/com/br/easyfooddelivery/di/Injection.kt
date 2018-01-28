package com.br.easyfooddelivery.di

import android.content.Context
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.lazy
import com.github.salomonbrys.kodein.singleton
import com.github.salomonbrys.kodein.instance
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Injection(private val context: Context, private val baseUrl: String) {
    val graph = Kodein.lazy {
        bind<Cache>() with singleton {
            val cacheSize = 10 * 1024 * 1024
            Cache(context.applicationContext.cacheDir, cacheSize.toLong())
        }

        bind<Gson>() with singleton {
            GsonBuilder().create()
        }

        bind<OkHttpClient>() with singleton {
            OkHttpClient.Builder()
                    .cache(instance())
                    .addInterceptor(instance())
                    .build()
        }

        bind<Retrofit>() with singleton {
            Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(instance()))
                    .baseUrl(baseUrl)
                    .client(instance())
                    .build()
        }

        bind<HttpLoggingInterceptor>() with singleton {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
        }
    }
}
