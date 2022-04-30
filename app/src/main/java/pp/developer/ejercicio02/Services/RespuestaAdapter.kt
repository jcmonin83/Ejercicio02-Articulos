package pp.developer.ejercicio02.Services

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import pp.developer.ejercicio02.MainActivity
import pp.developer.ejercicio02.Models.Respuesta
import pp.developer.ejercicio02.Models.RespuestaResult
import pp.developer.ejercicio02.R

class RespuestaAdapter (val respuestasResult: List<RespuestaResult>): RecyclerView.Adapter<RespuestaResultViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RespuestaResultViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  RespuestaResultViewHolder(layoutInflater.inflate(R.layout.arituclo_detalle,parent,false))
    }

    override fun onBindViewHolder(holder: RespuestaResultViewHolder, position: Int) {
        val items: RespuestaResult = respuestasResult[position]
        holder.itemView.setOnClickListener {
            val act:MainActivity? = holder.itemView.context as MainActivity
            val webView = act?.findViewById<WebView>(R.id.wvNavegador)
            webView!!.loadUrl(items.url)
        }
        holder.bind(items)
    }

    override fun getItemCount(): Int {
        return  respuestasResult.size
    }
}