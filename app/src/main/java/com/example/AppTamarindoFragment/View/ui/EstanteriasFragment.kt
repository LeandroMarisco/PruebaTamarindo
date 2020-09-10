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

class EstanteriasFragment : Fragment(), RecyclerAdapterList.OnClickListener {


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

    private fun setupRecyclerView() {
        Listrecycler_fragment.adapter = RecyclerAdapterList(requireContext(), addEstanterias(), this)
        Listrecycler_fragment.layoutManager = LinearLayoutManager(requireContext())
        Listrecycler_fragment.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
    }

    override fun onImageClick(foto: Int) {
        val bundle = Bundle()
        bundle.putInt("foto", foto)
        findNavController().navigate(R.id.action_estanteriasFragment_to_imageDetail, bundle)    }

    override fun onItemClik(name: String, foto: Int, cod: String) {
        val bundle = Bundle()
        bundle.putInt("foto", foto)
        bundle.putString("nombre", name)
        bundle.putString("cod", cod)
        findNavController().navigate(R.id.action_estanteriasFragment_to_secondView, bundle)
    }

    private fun addEstanterias(): ArrayList<TipoDeMueble> {
        return object : ArrayList<TipoDeMueble>() {
            init {
                add(TipoDeMueble("Bachiller", "576231", R.drawable.estanteria1))
                add(TipoDeMueble("Lienzo", "797331", R.drawable.estanteria2))
                add(TipoDeMueble("Stanly", "573521", R.drawable.estanteria4))
                add(TipoDeMueble("Paraiso", "123568", R.drawable.estanteria3))
                add(TipoDeMueble("Bari", "18754", R.drawable.mesa7))
                add(TipoDeMueble("forlan", "4657445", R.drawable.estanterias))
            }
        }
    }
}