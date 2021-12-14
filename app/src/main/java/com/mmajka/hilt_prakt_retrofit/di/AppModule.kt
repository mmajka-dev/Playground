package com.mmajka.hilt_prakt_retrofit.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mmajka.hilt_prakt_retrofit.data.CategoryRepository
import com.mmajka.hilt_prakt_retrofit.data.remote.AuthInterceptor
import com.mmajka.hilt_prakt_retrofit.data.remote.CategoryRemoteDataSource
import com.mmajka.hilt_prakt_retrofit.data.remote.CategoryService
import com.mmajka.hilt_prakt_retrofit.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideHttpClient(authInterceptor: AuthInterceptor) = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(Constants.serviceUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideInterceptor() = AuthInterceptor()

    @Provides
    fun provideGson() = GsonBuilder().create()

    @Provides
    fun provideCategoryService(retrofit: Retrofit) = retrofit.create(CategoryService::class.java)

    @Provides
    fun provideRemoteCategoryDataSource(categoryService: CategoryService) = CategoryRemoteDataSource(categoryService)

    @Provides
    fun provideRepository(remote: CategoryRemoteDataSource) = CategoryRepository(remote)
}