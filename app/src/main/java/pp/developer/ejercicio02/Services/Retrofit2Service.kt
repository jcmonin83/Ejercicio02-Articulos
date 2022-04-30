package pp.developer.ejercicio02.Services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit2Service {

    public fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.nytimes.com/svc/mostpopular/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            //.addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
    public fun callRetrofit( path: String){

    }
}