package com.kiienkoromaniuk.coctailshelper.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kiienkoromaniuk.coctailshelper.Values
import com.kiienkoromaniuk.coctailshelper.data.remote.CoctailsDataSource
import com.kiienkoromaniuk.coctailshelper.data.remote.CoctailsService
import com.kiienkoromaniuk.coctailshelper.data.repository.CoctailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl(Values.baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    fun provideCoctailsService(retrofit: Retrofit): CoctailsService = retrofit.create(CoctailsService::class.java)

    @Provides
    fun provideCoctailsDataSource(service: CoctailsService) = CoctailsDataSource(service)

    @Provides
    fun provideCoctailsRepository(remote: CoctailsDataSource) = CoctailsRepository(remote)
}