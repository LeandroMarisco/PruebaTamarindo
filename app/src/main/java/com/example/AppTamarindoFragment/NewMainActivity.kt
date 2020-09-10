package com.example.AppTamarindoFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.AppTamarindoFragment.R

class NewMainActivity : AppCompatActivity() {

        //creo la instancia de NavController
        private lateinit var navController: NavController

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_new_main)
            //uso ese instancia y le digo que el nav_host_fragment es el contenedor de los fragments
            navController = findNavController(R.id.nav_host_fragment)
            //Con esto se crea la toolbar con la flechita para atras
            NavigationUI.setupActionBarWithNavController(this, navController)
        }

        //Con esta funcion cerramos el vuelta a atras
        override fun onSupportNavigateUp(): Boolean {
            return navController.navigateUp()
        }



}
