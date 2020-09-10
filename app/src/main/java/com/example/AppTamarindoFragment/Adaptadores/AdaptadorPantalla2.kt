package com.example.AppTamarindoFragment.Adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.AppTamarindoFragment.R
import com.example.varios.Clases.TipoDeMueble

//import kotlinx.android.synthetic.main.template_tipo_muebles.view.*

class AdaptadorPantalla2
    (var  itemsTipo: ArrayList<TipoDeMueble>,
     var elClick: OnItemClickListner):
    RecyclerView.Adapter<AdaptadorPantalla2.MesasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): MesasViewHolder {
        lateinit var MesasViewHolder : MesasViewHolder
        MesasViewHolder =MesasViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.template_pantalla_muebles,parent,false))
        return MesasViewHolder
    }

    override fun getItemCount(): Int {
        return itemsTipo.size
    }

    override fun onBindViewHolder(holder: MesasViewHolder, position: Int) {
      /*  holder.initialize(itemsTipo.get(position),elClick)*/

    }

    class MesasViewHolder(ver: View) : RecyclerView.ViewHolder(ver), View.OnClickListener{
        var ver = ver
       /* var nombreTipo = ver.nombrePantalla2
        var articulo = ver.codigotw
        var muebleTipo = ver.fotoPantalla2*/
        lateinit var elClick : OnItemClickListner


    /*    fun initialize(item: TipoDeMueble, action: OnItemClickListner) {
            nombreTipo.text = item.nombreProducto
            articulo.text = item.articulo
            muebleTipo.setImageResource(item.foto)
            elClick = action
            ver.setOnClickListener(this)
        }*/
        override fun onClick(v: View?) {
                this.elClick?.onItemClick(v!!, adapterPosition)
        }
    }
}
interface OnItemClickListner{
    fun onItemClick(vista : View, position: Int)
}