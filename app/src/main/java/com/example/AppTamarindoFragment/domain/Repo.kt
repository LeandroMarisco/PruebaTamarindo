package com.example.AppTamarindoFragment.base

import com.example.varios.Clases.TipoDeMueble


interface Repo {
    suspend fun getMuebleList(): Resource<List<TipoDeMueble>>
}