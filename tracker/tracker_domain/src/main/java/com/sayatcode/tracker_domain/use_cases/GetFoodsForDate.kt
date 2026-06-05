package com.sayatcode.tracker_domain.use_cases

import com.sayatcode.tracker_domain.model.TrackedFood
import com.sayatcode.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetFoodsForDate(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(date: LocalDate): Flow<List<TrackedFood>>{
        return repository.foodsForDate(date)
    }
}