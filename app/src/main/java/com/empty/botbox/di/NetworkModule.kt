package com.empty.botbox.di

import com.empty.botbox.App
import com.empty.botbox.network.BotApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(App::class)
class NetworkModule {

    companion object {
        @Provides
        @Singleton
        fun providePokemonApiService(): BotApiServices        {
            return Retrofit.Builder()
                .baseUrl(" https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(BotApiServices::class.java)
        }
    }
}