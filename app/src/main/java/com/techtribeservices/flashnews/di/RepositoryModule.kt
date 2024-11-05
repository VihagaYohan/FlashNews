package com.techtribeservices.flashnews.di

import com.techtribeservices.flashnews.data.web.NewsApi
import com.techtribeservices.flashnews.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(api:NewsApi): NewsRepository {
        return NewsRepository(api)
    }
}