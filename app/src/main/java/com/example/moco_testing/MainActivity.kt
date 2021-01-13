package com.example.moco_testing

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.moco_testing.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    //Globale variablen
    companion object{var liste = mutableListOf<PKW>(
        PKW("Auto",12f,"BMW",100)
    )
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
     //Fügt ein PKW in liste aus PKWS hinzu
     fun addPKW(pkw: PKW) {
       // test  d("arne", "${liste.size}-1")
         liste.add(pkw)
       //test  d("arne","${liste.size}-2")
     }

    // getfunction um im fragment drauf zuzugreifen
    fun getliste():List<PKW>{
     //test   d("arne","${liste.size}-3")
        return liste
    }



}