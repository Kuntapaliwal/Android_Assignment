package com.example.mounty_drive_assignment
import com.google.gson.annotations.SerializedName

data class moviesResponses (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("total_pages") val pages: Int
)