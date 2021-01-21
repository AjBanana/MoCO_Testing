package com.example.moco_testing

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moco_testing.ui.main.PkwAdapter
import kotlinx.android.synthetic.main.fragment_add__car_fragment.*
import kotlinx.android.synthetic.main.fragment_list_fragment.*
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [List_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class List_fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // insertList()

        uebergabe()

        ButtonRe.setOnClickListener {
            uebergabe()
        }
    }




    fun uebergabe(){
        PKWrecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = PkwAdapter()
        }
    }
    override fun onResume() {
        super.onResume()
        PKWrecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = PkwAdapter()
        }
    }








   // Wir übergeben uns die liste aus Main mit der getFuntion
   //     var liste = MainActivity.liste

   //     liste.forEach{
   //         var textview = TextView(this.context)
   //         textview.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
   //         textview.text = "Name: ${it.name}   PS: ${it.ps}   Hersteller: ${it.hersteller}   Verbrauch: ${it.verbrauch} "
   //         Liste_linearLayout.addView(textview)
   //     }
   // }

    //muss man nicht beachten
    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment List_fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            List_fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}