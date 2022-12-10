package br.edu.infnet.gratiapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.gratiapp.R
import br.edu.infnet.gratiapp.models.FrasesModel

class Recyclerfraseadapter(var listafrases: MutableList<FrasesModel>) :
    RecyclerView.Adapter<Recyclerfraseadapter.viewHolder>() {
    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.recyclerlayout, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = listafrases.size
}