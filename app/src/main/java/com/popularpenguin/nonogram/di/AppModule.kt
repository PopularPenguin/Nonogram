package com.popularpenguin.nonogram.di

import com.popularpenguin.nonogram.repository.NonogramRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRepository(): NonogramRepository {
        return NonogramRepository()
    }
}