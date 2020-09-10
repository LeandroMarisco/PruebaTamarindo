package com.example.AppTamarindoFragment.model

import com.example.AppTamarindoFragment.Clases.Muebles
import com.example.AppTamarindoFragment.R
import com.example.AppTamarindoFragment.base.Resource
import com.example.varios.Clases.TipoDeMueble


class DataSource {

    val generateEstanterias = Resource.Success(
        listOf(
            TipoDeMueble("Bachiller", "576231", R.drawable.estanteria1),
            TipoDeMueble("Lienzo", "797331", R.drawable.estanteria2),
            TipoDeMueble("Paraiso", "123568", R.drawable.estanteria3),
            TipoDeMueble("Stanly", "573521", R.drawable.estanteria4),
            TipoDeMueble("Forlan", "4657445", R.drawable.estanterias)
        )
    )

    val generatePercheros = Resource.Success(
        listOf(
            TipoDeMueble("Erico", "95111", R.drawable.perchero1),
            TipoDeMueble("Nompa", "32145", R.drawable.perchero2),
            TipoDeMueble("Willy", "45913", R.drawable.perchero3),
            TipoDeMueble("Kun", "122544", R.drawable.perchero)
        )
    )

    val generateOtrosMuebles = Resource.Success(
        listOf(
            TipoDeMueble("Boedo", "95111", R.drawable.otros1),
            TipoDeMueble("Praga", "32145", R.drawable.otros2),
            TipoDeMueble("Oslo", "459143", R.drawable.otros3),
            TipoDeMueble("Cali", "122544", R.drawable.otros4),
            TipoDeMueble("Lima", "122544", R.drawable.otros5),
            TipoDeMueble("Lyon", "122544", R.drawable.otros6)
        )
    )

    val generateMesas = Resource.Success(
        listOf(
            TipoDeMueble("Simon", "65440", R.drawable.mesa1),
            TipoDeMueble("Amelie", "58710", R.drawable.mesa2),
            TipoDeMueble("Malevo", "78678", R.drawable.mesa3),
            TipoDeMueble("Chari", "25710", R.drawable.mesa4),
            TipoDeMueble("Bari", "18754", R.drawable.mesa7),
            TipoDeMueble("Nieve", "54125", R.drawable.mesa8)
        )
    )
}