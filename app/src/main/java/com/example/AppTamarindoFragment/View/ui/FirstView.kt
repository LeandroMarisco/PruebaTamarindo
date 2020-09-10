package com.example.AppTamarindoFragment.View.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.AppTamarindoFragment.Clases.Muebles
import com.example.AppTamarindoFragment.R
import com.example.AppTamarindoFragment.model.OnClickListener
import com.example.AppTamarindoFragment.model.RecyclerAdapterMueble
import kotlinx.android.synthetic.main.fragment_first_view.*


class FirstView : Fragment(), OnClickListener {

    var fotoF: Int? = null
    var nombreF: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            fotoF = it.getInt("foto")
            nombreF = it.getString("nombre")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_view, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recycler_fragment.adapter = RecyclerAdapterMueble(requireContext(), addMuebles(), this)
        //sin el layoutManager no se muestran nuestos items
        recycler_fragment.layoutManager = LinearLayoutManager(requireContext())

        // le agrego unas lineas para dividir cada item
        recycler_fragment.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun addMuebles(): ArrayList<Muebles> {
        return object : ArrayList<Muebles>() {
            init {
                add(Muebles("Mesas", R.drawable.mesa1, R.drawable.mesa1))
                add(Muebles("Estanteria", R.drawable.estanteria2, R.drawable.estanteria2))
                add(Muebles("Percheros", R.drawable.perchero2, R.drawable.perchero2))
                add(Muebles("Otros Muebles", R.drawable.otros1, R.drawable.otros1))
            }
        }

    }


    override fun onImageClick(foto: Int) {

        val bundle = Bundle()
        bundle.putInt("foto", foto)
        findNavController().navigate(R.id.action_firstView_to_imageDetail, bundle)

    }

    override fun onItemClik(name: String, foto: Int) {
        val bundle = Bundle()
        bundle.putInt("foto", foto)
        bundle.putString("nombre", name)

        when (name) {
            "Mesas" -> {
                findNavController().navigate(R.id.action_firstView_to_mesasFragment)
            }
            "Estanteria" -> {
                findNavController().navigate(R.id.action_firstView_to_estanteriasFragment)
            }
            "Percheros" -> {
                findNavController().navigate(R.id.action_firstView_to_percherosFragment)
            }
            "Otros Muebles" -> {
                findNavController().navigate(R.id.action_firstView_to_otros)
            }
        }


    }

}