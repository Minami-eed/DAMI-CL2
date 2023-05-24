package com.example.ciudadseguraapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DenunciaAdapter() : RecyclerView.Adapter<DenunciaViewHolder>(){
    private var denunciaList = emptyList<Denuncia>()

    fun setDenuncias(denuncias: List<Denuncia>) {
        this.denunciaList = denuncias
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int = denunciaList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DenunciaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DenunciaViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: DenunciaViewHolder, position: Int) {
        val book: Denuncia = denunciaList[position]
        holder.bind(book)
    }
}