package com.example.omgupsandroidapp.data.remote.dto.rating

data class GetRating(
    val KN: Any,
    val averageRatings: List<Double>,
    val positions: Positions,
    val ratingData: List<RatingData>
)