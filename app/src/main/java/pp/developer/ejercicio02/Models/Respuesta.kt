package pp.developer.ejercicio02.Models

import com.google.gson.annotations.SerializedName

data class Respuesta(
    @SerializedName("status")var status:String,
    @SerializedName("copyright")var copyright:String,
    @SerializedName("num_results")var num_results:Int,
    @SerializedName("results")var results:List<RespuestaResult> )