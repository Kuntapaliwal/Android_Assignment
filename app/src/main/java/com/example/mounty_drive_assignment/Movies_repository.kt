package com.example.mounty_drive_assignment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KFunction1

object Movies_repository {
    private val api: Api
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(Api::class.java)
    }

    fun getTopRatedMovies(
        page: Int = 1,
        onSuccess: (movies: List<Movie>) -> Unit,
        onError: KFunction1<Throwable, Unit>
    ) {
        api.getTOPRatedMovies(page = page)
            .enqueue(object : Callback<moviesResponses> {
                override fun onResponse(
                    call: Call<moviesResponses>,
                    response: Response<moviesResponses>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke(Throwable(""))
                        }
                    } else {
                        onError.invoke(Throwable(""))
                    }
                }

                override fun onFailure(call: Call<moviesResponses>, t: Throwable) {
                    onError.invoke(Throwable(""))
                }
            })
    }


    fun getUpcomingMovies(
        page: Int = 1,
        onSuccess: (movies: List<Movie>) -> Unit,
        onError: KFunction1<Throwable, Unit>
    ) {
        api.getUpcomingMovies(page = page)
            .enqueue(object : Callback<moviesResponses> {
                override fun onResponse(
                    call: Call<moviesResponses>,
                    response: Response<moviesResponses>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke(Throwable(""))
                        }
                    } else {
                        onError.invoke(Throwable(""))
                    }
                }

                override fun onFailure(call: Call<moviesResponses>, t: Throwable) {
                    onError.invoke(Throwable(""))
                }
            })
    }

}













