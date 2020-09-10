package com.example.AppTamarindoFragment.View.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.AppTamarindoFragment.R
import com.example.AppTamarindoFragment.View.MainViewModel
import com.example.AppTamarindoFragment.View.VMFactory
import com.example.AppTamarindoFragment.base.RepoImp
import com.example.AppTamarindoFragment.model.DataSource
import com.example.AppTamarindoFragment.model.RecyclerAdapterList
import com.example.varios.Clases.TipoDeMueble
import kotlinx.android.synthetic.main.recycler_list_detalle_fragmens.*


class OtrosFragmens : Fragment(), RecyclerAdapterList.OnClickListener {

    var nombreF: String? = ""

    //Dentro de los {} me pide un factory que va a hacer
    private val viewModel by viewModels<MainViewModel> { VMFactory(RepoImp(DataSource())) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            nombreF = it.getString("nombre")
        }
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
        //setupObservers()
    }

    /* private fun setupObservers(){
         viewModel.fetchMuebleList.observe(viewLifecycleOwner, Observer { result ->
             when (result) {
                 is Resource.Loading -> {
                     Toast.makeText(context, "Se esta cargando la lista", Toast.LENGTH_SHORT).show()
                 }
                 is Resource.Success -> {
                     Listrecycler_fragment.adapter = RecyclerAdapterList(
                         requireContext(),
                         result.data,
                         this
                     )
                 }
                 is Resource.Failure -> {
                     Toast.makeText(
                         requireContext(), "Ocurrio un error al traer los datos ${result.exception}",
                         Toast.LENGTH_SHORT
                     ).show()
                 }
             }
         })
     }*/

    override fun onImageClick(foto: Int) {
        val bundle = Bundle()
        bundle.putInt("foto", foto)
        findNavController().navigate(R.id.action_listDetalleFragmens_to_imageDetail, bundle)
    }

    override fun onItemClik(name: String, foto: Int, cod: String) {
        val bundle = Bundle()
        bundle.putInt("foto", foto)
        bundle.putString("nombre", name)
        bundle.putString("cod", cod)
        findNavController().navigate(R.id.action_listDetalleFragmens_to_secondView, bundle)

    }

    private fun setupRecyclerView() {
        Listrecycler_fragment.layoutManager = LinearLayoutManager(requireContext())
        Listrecycler_fragment.adapter = RecyclerAdapterList(requireContext(), addOtros(), this)

        Listrecycler_fragment.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun addOtros(): ArrayList<TipoDeMueble> {
        return object : ArrayList<TipoDeMueble>() {
            init {
                add(TipoDeMueble("Boedo", "95111", R.drawable.otros1))
                add(TipoDeMueble("Praga", "32145", R.drawable.otros2))
                add(TipoDeMueble("Oslo", "459143", R.drawable.otros3))
                add(TipoDeMueble("Cali", "122544", R.drawable.otros4))
                add(TipoDeMueble("Lima", "128544", R.drawable.otros5))
                add(TipoDeMueble("Lyon", "125544", R.drawable.otros6))
                add(TipoDeMueble("Lyon", "13544", R.drawable.otros6))
            }
        }
    }
}