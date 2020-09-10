package com.example.AppTamarindoFragment.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.AppTamarindoFragment.Clases.Muebles
import com.example.AppTamarindoFragment.R
import com.example.AppTamarindoFragment.base.BaseViewHolder
import kotlinx.android.synthetic.main.template_fragments_view.view.*
import java.lang.IllegalArgumentException

class RecyclerAdapterMueble(
    private val context: Context,
    private val mueblList: List<Muebles>,
    private val itemClickListener: OnClickListener ):
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MueblesViewHolder(LayoutInflater.from(context).inflate(R.layout.template_fragments_view,parent,false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is MueblesViewHolder -> holder.bind(mueblList[position],position)
            else -> throw IllegalArgumentException("Se olvido de pasar el viewHolder en el bind")
        }
    }

    override fun getItemCount(): Int {
        return mueblList.size
    }

    inner class MueblesViewHolder(itemView: View): BaseViewHolder<Muebles>(itemView){
        override fun bind(item: Muebles, position: Int) {
            itemView.setOnClickListener {itemClickListener.onItemClik(item.name,item.foto )}
            itemView.img_fra.setOnClickListener {itemClickListener.onImageClick(item.foto)}
            itemView.txt_fra.text = item.name
            Glide.with(context).load(item.foto).centerInside().into(itemView.img_fra)
        }
    }
}