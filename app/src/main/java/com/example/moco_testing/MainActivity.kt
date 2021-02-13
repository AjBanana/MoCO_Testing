package com.example.moco_testing

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.moco_testing.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    //Globale variablen
    companion object{var liste = mutableListOf<PKW>(
           // PKW("Auto",12f,"BMW",100),
           // PKW("Auti",12f,"BMW",100)
    )
        var BenzinPreis: Double = 1.0
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)


    }
    fun NeuPreis(NeuPreis : Double){
        BenzinPreis = NeuPreis
    }

    fun getBenzinPreis(): Double{
        return BenzinPreis
    }

     //Fügt ein PKW in liste aus PKWS hinzu
     fun addPKW(pkw: PKW) {
         liste.add(pkw)
     }

    // getfunction um im fragment drauf zuzugreifen
    fun getliste():List<PKW>{
        return liste
    }



}