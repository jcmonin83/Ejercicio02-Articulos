package pp.developer.ejercicio02.Services

import android.opengl.Matrix
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import pp.developer.ejercicio02.Models.Respuesta
import pp.developer.ejercicio02.Models.RespuestaResult
import pp.developer.ejercicio02.R

class RespuestaResultViewHolder (view: View): RecyclerView.ViewHolder(view){
    val img= view.findViewById<ImageView>(R.id.ivLogo)
    val titulo= view.findViewById<TextView>(R.id.title)
    val fecha= view.findViewById<TextView>(R.id.date)
    fun  bind(respuestaResult:RespuestaResult){
        Picasso.get().load(respuestaResult.media.first().media_data.first().url).into(img);
        titulo.text = respuestaResult.title
        fecha.text = respuestaResult.updated.toString()
    }
}