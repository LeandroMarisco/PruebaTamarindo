package com.example.AppTamarindoFragment.base


import android.content.ContentValues.TAG
import android.util.Log
import com.example.AppTamarindoFragment.View.ui.OtrosFragmens
import com.example.AppTamarindoFragment.model.DataSource
import com.example.varios.Clases.TipoDeMueble


//creo la implementacion de donde tengo la lista
class RepoImp(private val dataSource: DataSource): Repo {

    var datos = OtrosFragmens()
    // traigo una Resorce de la lista que necesito
    suspend override fun getMuebleList(): Resource<List<TipoDeMueble>> {


        Log.d(TAG, "${datos.nombreF}")
        return when (datos.nombreF) {
             "Mesas" -> {
                return dataSource.generateMesas
            }
            "Estanteria" -> {
                return dataSource.generateEstanterias
            }
            "Percheros" -> {
                return dataSource.generatePercheros
            }
            "Otros Muebles" -> {
                return dataSource.generateOtrosMuebles
            }
            else -> {
                dataSource.generateEstanterias
            }
        }

    }

}

