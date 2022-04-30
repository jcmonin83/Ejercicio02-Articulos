package pp.developer.ejercicio02

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pp.developer.ejercicio02.Models.Respuesta
import pp.developer.ejercicio02.Models.RespuestaResult
import pp.developer.ejercicio02.Services.APIService
import pp.developer.ejercicio02.Services.RespuestaAdapter
import pp.developer.ejercicio02.Services.Retrofit2Service
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var apiKey:String ="f0PNAK79UFGARYxhI5RGcVjpYvSnJD7w\n"
    private lateinit var adapter:RespuestaAdapter
    private val articulos = mutableListOf<RespuestaResult>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callSubRoutine("emailed/1")
    }
    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }

    fun callSubRoutine(path:String){
        CoroutineScope(Dispatchers.IO).launch {
//            //emailed/7.json?api-key=f0PNAK79UFGARYxhI5RGcVjpYvSnJD7w
            val call: Response<Respuesta> = Retrofit2Service().getRetrofit().create(APIService::class.java).getRespuesta("emailed/7.json?api-key=${apiKey}")
            val rest: Respuesta? = call.body()
            runOnUiThread {
                if(call.isSuccessful){
                    //findViewById<TextView>(R.id.txtVTitulo).text = rest!!.results.first().title
                    initReycler(findViewById(R.id.recyclerView), rest!!)
                    adapter.notifyDataSetChanged()
                }else{
                    Message("Error:",call.message())
                }
            }
        }
    }

    fun initReycler(recyclerView:RecyclerView,articulo:Respuesta){
        recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        adapter=RespuestaAdapter(articulo.results)
        recyclerView.adapter=adapter
    }
    fun Message(evento:String, mensaje:String){
        Toast.makeText(this,"${evento}. ${mensaje}",Toast.LENGTH_SHORT).show()
    }

    fun btnTitulo_Click(view: View) {
        callSubRoutine("7")
    }
}