package com.sayatcode.tracker_domain.use_cases

data class TrackerUseCases(
    val trackFood: TrackFood,
    val searchFood: SearchFood,
    val deleteTrackedFood: DeleteTrackedFood,
    val getFoodsForDate: GetFoodsForDate,
    val calculateMealNutrients: CalculateMealNutrients
)
