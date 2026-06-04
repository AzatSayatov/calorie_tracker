package com.sayatcode.onboarding_domain.di

import com.sayatcode.onboarding_domain.use_case.ValidateNutrientGoals
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object OnboardingDomainModule {
    @Provides
    @ViewModelScoped
    fun provideValidateNutrientGoals(): ValidateNutrientGoals{
        return ValidateNutrientGoals()
    }
}