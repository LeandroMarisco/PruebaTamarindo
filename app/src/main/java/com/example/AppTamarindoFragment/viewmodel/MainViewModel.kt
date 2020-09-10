package com.example.AppTamarindoFragment.View

import androidx.lifecycle.*
import com.example.AppTamarindoFragment.base.Repo
import com.example.AppTamarindoFragment.base.Resource

import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repo: Repo) : ViewModel() {

    //le pasamos un nuevo parametro para buscar
    //vamos a escribir un string para buscar el nombre del trago
    private val mueblesData = MutableLiveData<String>()

    //hacemos un setUp al Muteable live data de un stringn que va a hacer el nombre del trago que estoy buscando
    fun setMueble(MuebleName: String) {
        mueblesData.value = MuebleName
    }

    init {
        setMueble("mueble")
    }

    //voy a buscar la info entonces lo hago en segundo plano (IO)
    //el distinctUntilChange uan vez busque algo y me lo trajo, si yo no modifique el nombre de la busqueda,
    //entonces no me vuelve a busca, si busque mojito, me trae la lista de mojito y si yo vuelvo
    // a tocar en buscar no me cambia nada

    val fetchMuebleList = mueblesData.distinctUntilChanged().switchMap { nombreMueble ->
        liveData(Dispatchers.IO) {
            //viene con el KTX del LiveData, dentro del emit le pasamos que lo queres qye vata emitiendo
            //este liveData es escuchado por la ui entonces se va a disparar lo que estemos escuchando
            emit(Resource.Loading())
            try {
                emit(repo.getMuebleList())
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }

    }
}
