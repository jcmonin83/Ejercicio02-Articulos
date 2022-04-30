package pp.developer.ejercicio02.Models

import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("media-metadata") val media_data:List<Imagenes>
)
