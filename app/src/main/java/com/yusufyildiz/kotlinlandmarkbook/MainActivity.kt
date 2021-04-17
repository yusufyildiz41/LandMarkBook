package com.yusufyildiz.kotlinlandmarkbook

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.my_list_row.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Data
        var landmarkNames = ArrayList<String>()
        landmarkNames.add("Pisa")
        landmarkNames.add("Colloseum")
        landmarkNames.add("Eiffel")
        landmarkNames.add("London Bridge")


        //Image
        val pisa = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.pisa)
        val colosseum = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.colosseum)
        val eiffel = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.eiffel)
        val londonBridge = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.london)

        var landmarkImages = ArrayList<Bitmap>()
        landmarkImages.add(pisa)
        landmarkImages.add(colosseum)
        landmarkImages.add(eiffel)
        landmarkImages.add(londonBridge)

        /*
        //Image - Efficient
        val pisaId = R.drawable.pisa
        val colosseumId = R.drawable.colosseum
        val eiffelId = R.drawable.eiffel
        val londonId = R.drawable.london

        var landmarkImagesId = ArrayList<Int>()
        landmarkImagesId.add(pisaId)
        landmarkImagesId.add(colosseumId)
        landmarkImagesId.add(eiffelId)
        landmarkImagesId.add(londonId)
        */

        //Adapter : Layout & Data

        // İf we custom the adapter :   val adapter = ArrayAdapter(this,R.layout.my_list_row,R.id.textView2,landmarkNames)
        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkNames)
        listView.adapter = adapter

        //Click

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(applicationContext,DetailsActivity::class.java)

            intent.putExtra("name",landmarkNames[position]) //position = index

            //intent.putExtra("image",landmarkImagesId[position])

            val singleton = Singleton.Selected
            singleton.selectedImage = landmarkImages[position]

            startActivity(intent)

        }

    }
}