package com.sayatcode.onboarding_domain.use_case

import com.sayatcode.core.R
import com.sayatcode.core.util.UiText

class ValidateNutrientGoals {

    operator fun invoke(
        carbsRatioText: String,
        proteinRationText: String,
        fatRatioText: String
    ): Result{
        val carbsRatio = carbsRatioText.toIntOrNull()
        val proteinRatio = proteinRationText.toIntOrNull()
        val fatRatio = proteinRationText.toIntOrNull()
        if (carbsRatio == null || proteinRatio == null || fatRatio == null){
            return Result.Error(UiText.StringResource(R.string.error_invalid_values))
        }
        if (carbsRatio + proteinRatio + fatRatio != 100){
            return Result.Error(UiText.StringResource(R.string.error_not_100_percent))
        }else{
            return Result.Success(
                carbsRatio / 100f,
                proteinRatio / 100f,
                fatRatio / 100f
            )
        }
    }

    sealed class Result{
        data class Success(
            val carbsRatio: Float,
            val proteinRatio:Float,
            val fatRatio: Float
        ): Result()

        data class Error(
            val message: UiText
        ): Result()
    }
}