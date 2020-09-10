package com.example.AppTamarindoFragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.AppTamarindoFragment.Adaptadores.AdaptadorPantalla1
import com.example.AppTamarindoFragment.Adaptadores.OnMuebleItemClickListner
import com.example.AppTamarindoFragment.Clases.Muebles
import com.example.AppTamarindoFragment.View.Pantalla2Estanterias
import com.example.AppTamarindoFragment.View.Pantalla2Mesas
import com.example.AppTamarindoFragment.View.Pantalla2Otros
import com.example.AppTamarindoFragment.View.Pantalla2Percheros

class MainActivity : AppCompatActivity(),OnMuebleItemClickListner {
    var grid : RecyclerView? = null
    var adaptador : AdaptadorPantalla1? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var muebles = ArrayList<Muebles>()

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(1500)
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       addMuebles()
        grid = findViewById(R.id.RecyclerPantalla1)
        grid?.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        grid?.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        grid?.layoutManager = layoutManager

        adaptador =AdaptadorPantalla1(muebles, this)
        grid?.adapter = adaptador
    }

    fun addMuebles(){
        muebles.add(Muebles("Mesas",R.drawable.mesa1,R.drawable.mesa1 ))
        muebles.add(Muebles("Estanteria",R.drawable.estanteria2,R.drawable.estanteria2))
        muebles.add(Muebles("Percheros",R.drawable.perchero2,R.drawable.perchero2))
        muebles.add(Muebles("Otros Muebles", R.drawable.otros1, R.drawable.otros1))
    }

    override fun onItemClick(item: Muebles, position: Int) {

        when(item.name){
            "Mesas" -> { var intent = Intent(this, Pantalla2Mesas::class.java)
                startActivity(intent)}
            "Estanteria" -> { var intent = Intent(this, Pantalla2Estanterias::class.java)
                startActivity(intent)}
            "Percheros" -> {var intent = Intent(this, Pantalla2Percheros::class.java)
                startActivity(intent)}
            "Otros Muebles" -> {var intent = Intent(this, Pantalla2Otros::class.java)
                startActivity(intent)}
        }
    }
}
