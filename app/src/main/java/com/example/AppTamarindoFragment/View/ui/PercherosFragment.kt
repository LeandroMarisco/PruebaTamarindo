package com.example.AppTamarindoFragment.View.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.AppTamarindoFragment.R
import com.example.AppTamarindoFragment.model.RecyclerAdapterList
import com.example.varios.Clases.TipoDeMueble
import kotlinx.android.synthetic.main.recycler_list_detalle_fragmens.*

class PercherosFragment : Fragment(), RecyclerAdapterList.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recycler_list_detalle_fragmens, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

    }

    override fun onImageClick(foto: Int) {
        val bundle = Bundle()
        bundle.putInt("foto", foto)
        findNavController().navigate(R.id.action_percherosFragment_to_imageDetail, bundle)
    }

    override fun onItemClik(name: String, foto: Int, cod: String) {
        val bundle = Bundle()
        bundle.putInt("foto", foto)
        bundle.putString("nombre", name)
        bundle.putString("cod", cod)
        findNavController().navigate(R.id.action_percherosFragment_to_secondView, bundle)

    }

    private fun setupRecyclerView() {
        Listrecycler_fragment.layoutManager = LinearLayoutManager(requireContext())
        Listrecycler_fragment.adapter = RecyclerAdapterList(requireContext(), addPercheros(), this)

        Listrecycler_fragment.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun addPercheros(): ArrayList<TipoDeMueble> {
        return object : ArrayList<TipoDeMueble>() {
            init {
                add(TipoDeMueble("Erico", "95111", R.drawable.perchero1))
                add(TipoDeMueble("Nompa", "32145", R.drawable.perchero2))
                add(TipoDeMueble("Willy", "45913", R.drawable.perchero3))
                add(TipoDeMueble("Kun", "122544", R.drawable.perchero))
            }
        }
    }

}