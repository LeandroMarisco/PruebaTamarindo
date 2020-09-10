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

class Pantalla2Percheros : AppCompatActivity() {

    private var gridPercheros : RecyclerView? = null
    var adaptador: AdaptadorPantalla2? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var percheros = ArrayList<TipoDeMueble>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla2)

        Toast.makeText(this, "Percheros", Toast.LENGTH_SHORT).show()

        addPercheros()

        gridPercheros = findViewById(R.id.RecyclerPantalla2)
        gridPercheros?.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)

        gridPercheros?.layoutManager = layoutManager
        gridPercheros?.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        adaptador = AdaptadorPantalla2(percheros, object : OnItemClickListner {
            override fun onItemClick(vista: View, position: Int) {
                Toast.makeText(
                    applicationContext,
                    percheros.get(position).nombreProduct,
                    Toast.LENGTH_SHORT
                ).show()
                val bundle = Bundle()
                bundle.putInt("Foto", percheros.get(position).foto)
                bundle.putString("Nombre", percheros.get(position).nombreProduct)
                val intent = Intent(vista.context, DetalleMuebles::class.java)
                intent.putExtra("Codigo", percheros.get(position).articulo)
                intent.putExtras(bundle)
                vista.context.startActivity(intent)
            }
        })
        gridPercheros?.adapter = adaptador
    }
        fun addPercheros () {
            percheros.add(TipoDeMueble("Erico", 95111, R.drawable.perchero1))
            percheros.add(TipoDeMueble("Nompa", 32145, R.drawable.perchero2))
            percheros.add(TipoDeMueble("Willy", 45913, R.drawable.perchero3))
            percheros.add(TipoDeMueble("Kun", 122544, R.drawable.perchero))
        }
    }




