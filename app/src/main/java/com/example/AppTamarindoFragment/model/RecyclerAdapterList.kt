package com.example.AppTamarindoFragment.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.AppTamarindoFragment.R
import com.example.AppTamarindoFragment.base.BaseViewHolder
import com.example.varios.Clases.TipoDeMueble
import kotlinx.android.synthetic.main.template_pantalla_muebles.view.*
import java.lang.IllegalArgumentException

class RecyclerAdapterList(
    private val context: Context,
    private var list: List<TipoDeMueble>,
    private val itemClickListener: OnClickListener):
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnClickListener {
        fun onImageClick(foto: Int)
        fun onItemClik( name: String, foto: Int, cod: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return TipoMueblesViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.template_pantalla_muebles,parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is RecyclerAdapterList.TipoMueblesViewHolder -> holder.bind(list[position],position)
            else -> throw IllegalArgumentException("Se olvido de pasar el viewHolder en el bind")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    inner class TipoMueblesViewHolder(itemView: View): BaseViewHolder<TipoDeMueble>(itemView){
        override fun bind(item: TipoDeMueble, position: Int) {
            itemView.setOnClickListener {itemClickListener.onItemClik(item.nombreProduct,item.foto, item.articulo )}
            itemView.img_fra_mueble.setOnClickListener {itemClickListener.onImageClick(item.foto)}
            itemView.txt_fra_mueble.text = item.nombreProduct
            Glide.with(context).load(item.foto).centerInside().into(itemView.img_fra_mueble)
        }


    }


}






