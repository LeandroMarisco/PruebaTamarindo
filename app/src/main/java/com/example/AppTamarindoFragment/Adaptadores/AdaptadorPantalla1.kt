package com.example.AppTamarindoFragment.Adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.AppTamarindoFragment.Clases.Muebles
import com.example.AppTamarindoFragment.R
import kotlinx.android.synthetic.main.template_pantalla1.view.*

class AdaptadorPantalla1 (var  items: ArrayList<Muebles>, var clickListner: OnMuebleItemClickListner) : RecyclerView.Adapter<AdaptadorPantalla1.MueblesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): MueblesViewHolder {
        lateinit var MueblesViewHolder : MueblesViewHolder
        MueblesViewHolder =MueblesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.template_pantalla1,parent,false))
        return MueblesViewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MueblesViewHolder, position: Int) {
        holder.initialize(items.get(position),clickListner)

    }

    class MueblesViewHolder(ver: View) : RecyclerView.ViewHolder(ver){
        var muebleName = ver.tv_pantalla1
        var muebleFoto = ver.fotopantall1

        fun initialize(item: Muebles, action: OnMuebleItemClickListner){
            muebleName.text = item.name
            muebleFoto.setImageResource(item.logo)

            itemView.setOnClickListener{
                action.onItemClick(item,adapterPosition)
            }
        }
    }
}

interface OnMuebleItemClickListner{
    fun onItemClick(item: Muebles, position: Int)
}