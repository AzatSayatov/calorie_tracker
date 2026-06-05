package com.sayatcode.tracker_domain.di

import com.sayatcode.core.domain.preferences.Preferences
import com.sayatcode.tracker_domain.repository.TrackerRepository
import com.sayatcode.tracker_domain.use_cases.CalculateMealNutrients
import com.sayatcode.tracker_domain.use_cases.DeleteTrackedFood
import com.sayatcode.tracker_domain.use_cases.GetFoodsForDate
import com.sayatcode.tracker_domain.use_cases.SearchFood
import com.sayatcode.tracker_domain.use_cases.TrackFood
import com.sayatcode.tracker_domain.use_cases.TrackerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @Provides
    @ViewModelScoped
    fun provideTrackFoodUseCases(
        preferences: Preferences,
        repository: TrackerRepository
    ): TrackerUseCases{
        return TrackerUseCases(
            trackFood = TrackFood(repository),
            searchFood = SearchFood(repository),
            getFoodsForDate = GetFoodsForDate(repository),
            deleteTrackedFood = DeleteTrackedFood(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences)
        )
    }
}