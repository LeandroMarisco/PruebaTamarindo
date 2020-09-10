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

class Pantalla2Mesas : AppCompatActivity(){

    var gridMesas: RecyclerView? = null
    var adaptador: AdaptadorPantalla2? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var mesas = ArrayList<TipoDeMueble>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla2)

        Toast.makeText(this, "Mesas" , Toast.LENGTH_SHORT).show()
        addMesas()
        gridMesas = findViewById(R.id.RecyclerPantalla2)
        gridMesas?.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        gridMesas?.layoutManager = layoutManager
        gridMesas?.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        adaptador = AdaptadorPantalla2(mesas, object : OnItemClickListner{
            override fun onItemClick(vista: View, position: Int) {
                    Toast.makeText(applicationContext, mesas.get(position).nombreProduct, Toast.LENGTH_SHORT).show()
                val bundle = Bundle()
                bundle.putInt("Foto", mesas.get(position).foto)
                bundle.putString("Nombre", mesas.get(position).nombreProduct)
                val intent = Intent(vista.context, DetalleMuebles::class.java)
                intent.putExtra("Codigo", mesas.get(position).articulo)
                intent.putExtras(bundle)
                vista.context.startActivity(intent)

            }
        })
        gridMesas?.adapter = adaptador
    }
    private fun addMesas() {
        mesas.add(TipoDeMueble("Simon", 65440, R.drawable.mesa1))
        mesas.add(TipoDeMueble("Amelie", 58710, R.drawable.mesa2))
        mesas.add(TipoDeMueble("Malevo", 78678, R.drawable.mesa3))
        mesas.add(TipoDeMueble("Chari", 25710, R.drawable.mesa4))
        mesas.add(TipoDeMueble("Bari", 18754, R.drawable.mesa7))
        mesas.add(TipoDeMueble("Nieve", 34125, R.drawable.mesa8))

    }
}