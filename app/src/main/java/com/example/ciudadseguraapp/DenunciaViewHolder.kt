package com.example.ciudadseguraapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class DenunciaViewHolder (inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_denuncias, parent, false)) {

    private var textTitulo: TextView? = null
    private var textFecha: TextView? = null
    private var textDescripcion: TextView? = null

    init {
        textTitulo = itemView.findViewById(R.id.textTitulo)
        textFecha = itemView.findViewById(R.id.textFecha)
        textDescripcion = itemView.findViewById(R.id.textDescripcion)
    }

    fun bind(plato: Denuncia) {
        textTitulo?.text = plato.titulo
        textFecha?.text =  plato.lugar + " " + plato.fecha
        textDescripcion?.text = plato.descripcion
    }

}