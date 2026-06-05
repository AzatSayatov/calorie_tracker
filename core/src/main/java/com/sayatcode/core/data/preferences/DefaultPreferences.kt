package com.sayatcode.core.data.preferences

import android.content.SharedPreferences
import androidx.core.content.edit
import com.sayatcode.core.domain.model.ActivityLevel
import com.sayatcode.core.domain.model.Gender
import com.sayatcode.core.domain.model.GoalType
import com.sayatcode.core.domain.model.UserInfo
import com.sayatcode.core.domain.preferences.Preferences

class DefaultPreferences(
    private val sharedPreferences: SharedPreferences
): Preferences {
    override fun saveGender(gender: Gender) {
        sharedPreferences.edit {
            putString(Preferences.KEY_GENDER, gender.name)
        }
    }

    override fun saveShouldShowOnboarding(show: Boolean) {
        sharedPreferences.edit{
            putBoolean(Preferences.KEY_SHOULD_SHOW_ONBOARDING,show)
        }
    }

    override fun loadShouldShowOnBoarding(): Boolean {
       return sharedPreferences.getBoolean(
            Preferences.KEY_SHOULD_SHOW_ONBOARDING,true
        )
    }

    override fun saveAge(age: Int) {
        sharedPreferences.edit {
            putInt(Preferences.KEY_AGE, age)
        }
    }

    override fun saveWeight(weight: Float) {
        sharedPreferences.edit {
            putFloat(Preferences.KEY_WEIGHT,weight)
        }
    }

    override fun saveHeight(height: Int) {
        sharedPreferences.edit {
            putInt(Preferences.KEY_HEIGHT, height)
        }
    }

    override fun saveActivityLevel(activityLevel: ActivityLevel) {
        sharedPreferences.edit {
            putString(Preferences.KEY_ACTIVITY_LEVEL,activityLevel.name)
        }
    }

    override fun saveGoalType(goalType: GoalType) {
        sharedPreferences.edit {
            putString(Preferences.KEY_GOAL_TYPE,goalType.name)
        }
    }

    override fun saveCarbRatio(ratio: Float) {
        sharedPreferences.edit {
            putFloat(Preferences.KEY_CARB_RATIO,ratio)
        }
    }

    override fun saveProteinRatio(ratio: Float) {
        sharedPreferences.edit {
            putFloat(Preferences.KEY_PROTEIN_RATIO,ratio)
        }
    }

    override fun saveFatRatio(ratio: Float) {
        sharedPreferences.edit {
            putFloat(Preferences.KEY_FAT_RATIO,ratio)
        }
    }

    override fun loadUserInfo(): UserInfo {
        val age = sharedPreferences.getInt(Preferences.KEY_AGE, -1)
        val height = sharedPreferences.getInt(Preferences.KEY_HEIGHT, -1)
        val weight = sharedPreferences.getFloat(Preferences.KEY_WEIGHT, -1f)
        val genderString = sharedPreferences.getString(Preferences.KEY_GENDER, null)
        val activityLevelString = sharedPreferences
            .getString(Preferences.KEY_ACTIVITY_LEVEL, null)
        val goalType = sharedPreferences.getString(Preferences.KEY_GOAL_TYPE, null)
        val carbRatio = sharedPreferences.getFloat(Preferences.KEY_CARB_RATIO, -1f)
        val proteinRatio = sharedPreferences.getFloat(Preferences.KEY_PROTEIN_RATIO, -1f)
        val fatRatio = sharedPreferences.getFloat(Preferences.KEY_FAT_RATIO, -1f)

        return UserInfo(
            gender = Gender.fromString(genderString ?: "male"),
            age = age,
            weight = weight,
            height = height,
            activityLevel = ActivityLevel.fromString(activityLevelString ?: "medium"),
            goalType = GoalType.fromString(goalType ?: "keep_weight"),
            carbRatio = carbRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio
        )
    }
}