package pp.developer.ejercicio02.Services

import pp.developer.ejercicio02.Models.Respuesta
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getRespuesta(@Url url:String): Response<Respuesta>
}