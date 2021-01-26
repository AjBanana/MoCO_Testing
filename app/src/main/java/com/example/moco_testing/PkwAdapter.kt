package com.example.moco_testing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.car_row_view.view.*

class PkwAdapter : RecyclerView.Adapter<PkwAdapter.ViewHolder>() {
    var liste = MainActivity().getliste()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_row_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.itemView.apply {
        row_hersteller.text ="Hersteller: ${liste[position].hersteller}"
        row_name.text= "Name: ${liste[position].name}"
        row_ps.text= "PS: ${liste[position].ps.toString()}"
        row_verbrauch.text= "Verbrauch: ${liste[position].verbrauch.toString()} Liter"
        row_image.setImageResource(R.drawable.vwgolf2)
        var kosten = liste[position].verbrauch
        kosten = (kosten * MainActivity().getBenzinPreis()).toFloat()
        VerbrauchKosten.text="Kosten auf 100Km ${kosten.toString()}€"
    }
    }

    override fun getItemCount() = liste.size

}