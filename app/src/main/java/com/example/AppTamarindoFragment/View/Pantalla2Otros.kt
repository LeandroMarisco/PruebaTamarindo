package com.example.AppTamarindoFragment.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.AppTamarindoFragment.Adaptadores.AdaptadorPantalla2
import com.example.AppTamarindoFragment.Adaptadores.OnItemClickListner
import com.example.AppTamarindoFragment.R
import com.example.varios.Clases.TipoDeMueble

class Pantalla2Otros : AppCompatActivity() {

    var otros = ArrayList<TipoDeMueble>()
    var gridOtros: RecyclerView? = null
    var adaptador: AdaptadorPantalla2? = null
    var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla2)

        Toast.makeText(this, "Otros Muebles", Toast.LENGTH_SHORT).show()
        addOtros()
        gridOtros = findViewById(R.id.RecyclerPantalla2)
        gridOtros?.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        gridOtros?.layoutManager = layoutManager
        gridOtros?.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        adaptador = AdaptadorPantalla2(otros, object : OnItemClickListner {
            override fun onItemClick(vista: View, position: Int) {
                Toast.makeText(applicationContext,otros.get(position).nombreProduct, Toast.LENGTH_SHORT).show()
                val bundle = Bundle()
                bundle.putInt("Foto", otros.get(position).foto)
                bundle.putString("Nombre", otros.get(position).nombreProduct)
                val intent = Intent(vista.context, DetalleMuebles::class.java)
                intent.putExtra("Codigo", otros.get(position).articulo)
                intent.putExtras(bundle)
                vista.context.startActivity(intent)
            }
        })
        gridOtros?.adapter = adaptador
    }
    private fun addOtros() {
        otros.add(TipoDeMueble("Boedo", 95111, R.drawable.otros1))
        otros.add(TipoDeMueble("Praga", 3214, R.drawable.otros2))
        otros.add(TipoDeMueble("Oslo", 459143, R.drawable.otros3))
        otros.add(TipoDeMueble("Cali", 122544, R.drawable.otros4))
        otros.add(TipoDeMueble("Lima", 122544, R.drawable.otros5))
        otros.add(TipoDeMueble("Lyon", 122544, R.drawable.otros6))

    }
}