package com.example.AppTamarindoFragment.View.ui.fragments

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

class MesasFragment : Fragment(), RecyclerAdapterList.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recycler_list_detalle_fragmens, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        Listrecycler_fragment.adapter = RecyclerAdapterList(requireContext(), addMesas(), this)
        Listrecycler_fragment.layoutManager = LinearLayoutManager(requireContext())
        Listrecycler_fragment.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL)
        )
    }

    override fun onImageClick(foto: Int) {
        val bundle = Bundle()
        bundle.putInt("foto", foto)
        findNavController().navigate(R.id.action_mesasFragment_to_imageDetail, bundle)
    }


    override fun onItemClik(name: String, foto: Int, cod:Int) {
        val bundle = Bundle()
        bundle.putInt("foto", foto)
        bundle.putString("nombre", name)
        bundle.putInt("cod", cod)
        findNavController().navigate(R.id.action_mesasFragment_to_secondView, bundle)

    }

    private fun addMesas(): ArrayList<TipoDeMueble> {
        return object : ArrayList<TipoDeMueble>() {
            init {
                add(TipoDeMueble("Simon", 65440, R.drawable.mesa1))
                add(TipoDeMueble("Amelie", 58710, R.drawable.mesa2))
                add(TipoDeMueble("Malevo", 78678, R.drawable.mesa3))
                add(TipoDeMueble("Chari", 25710, R.drawable.mesa4))
                add(TipoDeMueble("Bari", 18754, R.drawable.mesa7))
                add(TipoDeMueble("Nieve", 34125, R.drawable.mesa8))
            }
        }

    }

}