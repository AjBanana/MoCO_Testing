package com.example.moco_testing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlin.math.round
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.car_row_view.view.*
import kotlinx.android.synthetic.main.fragment_setting.view.*

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
        row_ps.text= "PS: ${liste[position].ps}"
        row_verbrauch.text= "Verbrauch: ${liste[position].verbrauch} Liter"
        row_image.setImageResource(R.drawable.vwgolf2)

        val bpreis = MainActivity.BenzinPreis
        val verbrauch : Double = liste[position].verbrauch.toDouble()
        VerbrauchKosten.text="Kosten auf 100Km ${(bpreis * verbrauch)}€"
    }
    }

    override fun getItemCount() = liste.size


}