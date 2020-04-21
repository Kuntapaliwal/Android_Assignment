package com.example.mounty_drive_assignment
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call
interface Api {
    @GET("movie/upcoming")
    fun getUpcomingMovies(
        @Query("api_key") apiKey: String = "fbcbc53a0e35c043fdf3000f5878e201",
        @Query("page") page: Int
    ): Call<moviesResponses>

    @GET("movie/top_rated")
    fun  getTOPRatedMovies(
        @Query("api_key") apiKey: String = "fbcbc53a0e35c043fdf3000f5878e201",
        @Query("page") page: Int
    ): Call<moviesResponses>


}