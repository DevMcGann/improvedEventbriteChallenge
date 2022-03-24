package com.gsoft.improvedeventbritechallenge.di

import com.gsoft.improvedeventbritechallenge.data.repository.EventRepository
import com.gsoft.improvedeventbritechallenge.data.repository.EventRepositoryImpl
import com.gsoft.improvedeventbritechallenge.network.EventService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesMovieRepository(
        apiService: EventService,


    ): EventRepository {
        return EventRepositoryImpl(
            apiService = apiService,
        )
    }


}