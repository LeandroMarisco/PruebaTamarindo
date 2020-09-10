package com.example.AppTamarindoFragment.View

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.AppTamarindoFragment.R

class DetalleMuebles : AppCompatActivity() {

    var imagen: ImageView? = null
    var nombrep: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_muebles)

        nombrep = findViewById<View>(R.id.nombreMueble) as TextView
        imagen = findViewById<View>(R.id.fotoDetalle) as ImageView
        var codigop = findViewById<TextView>(R.id.codigoMueble)

        nombrep?.text = "Nombre: " + intent.getStringExtra("Nombre")
        imagen!!.setImageResource(intent.extras?.getInt("Foto")!!)
        codigop?.text = "Cod: " + intent.getStringExtra("Codigo")

    }
}












