package com.example.AppTamarindoFragment.View.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.AppTamarindoFragment.R
import kotlinx.android.synthetic.main.fragment_second_view.*


class SecondView : Fragment() {
    private var fotoF: Int? = null
    private var nombreF: String? = null
    private var cod: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            fotoF = it.getInt("foto")
            nombreF = it.getString("nombre")
            cod = it.getString("cod")
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nombreMuebleFra.text = nombreF
        codigoMuebleFra.text = cod
        Glide.with(requireContext()).load(fotoF).into(fotoDetalleFra)
    }
}