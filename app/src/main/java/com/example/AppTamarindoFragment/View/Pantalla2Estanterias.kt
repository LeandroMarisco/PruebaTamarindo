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

class Pantalla2Estanterias : AppCompatActivity() {

    var estanterias = ArrayList<TipoDeMueble>()
    var gridEstanterias: RecyclerView? = null
    var adaptador: AdaptadorPantalla2? = null
    var layoutManager: RecyclerView.LayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla2)

        Toast.makeText(this, "Estanterias", Toast.LENGTH_SHORT).show()

        addEstanterias()
        gridEstanterias = findViewById(R.id.RecyclerPantalla2)
        gridEstanterias!!.setHasFixedSize(true)


        layoutManager = LinearLayoutManager(this)
        gridEstanterias?.layoutManager = layoutManager
        gridEstanterias?.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        adaptador = AdaptadorPantalla2(estanterias, object : OnItemClickListner {
            override fun onItemClick(vista: View, position: Int) {
                Toast.makeText(
                    applicationContext,
                    estanterias.get(position).nombreProduct,
                    Toast.LENGTH_SHORT
                ).show()
                val bundle = Bundle()
                bundle.putInt("Foto", estanterias.get(position).foto)
                bundle.putString("Nombre", estanterias.get(position).nombreProduct)
                val intent = Intent(vista.context, DetalleMuebles::class.java)
                intent.putExtra("Codigo", estanterias.get(position).articulo)
                intent.putExtras(bundle)
                vista.context.startActivity(intent)
            }
        })

        gridEstanterias!!.adapter = adaptador
    }

    private fun addEstanterias() {
        estanterias.add(TipoDeMueble("Bachiller", 576231, R.drawable.estanteria1))
        estanterias.add(TipoDeMueble("Lienzo", 797331, R.drawable.estanteria2))
        estanterias.add(TipoDeMueble("Paraiso", 123568, R.drawable.estanteria3))
        estanterias.add(TipoDeMueble("Stanly", 573521, R.drawable.estanteria4))
        estanterias.add(TipoDeMueble("Forlan", 4657445, R.drawable.estanterias))
    }
}


