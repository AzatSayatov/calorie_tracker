package com.sayatcode.tracker_domain.use_cases

import com.sayatcode.tracker_domain.model.TrackedFood
import com.sayatcode.tracker_domain.repository.TrackerRepository

class DeleteTrackedFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(trackedFood: TrackedFood) {
        repository.deleteTrackedFood(trackedFood)
    }
}