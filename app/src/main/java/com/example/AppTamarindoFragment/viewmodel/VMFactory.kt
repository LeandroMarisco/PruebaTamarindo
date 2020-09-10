package com.example.AppTamarindoFragment.View

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.AppTamarindoFragment.base.Repo

//aca mando la interface que es la que necesito
// creo el factory que necesito para pasar el ViewModel del Main activity {}

class VMFactory (private val repo: Repo): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }


}