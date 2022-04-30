package pp.developer.ejercicio02.Models

import com.google.gson.annotations.SerializedName
import java.util.*

data class RespuestaResult(
    @SerializedName("title" ) var title:String,
    @SerializedName("updated") val updated:String,
    @SerializedName("url") val url:String,
    @SerializedName("media") val media:List<Media>
    )
