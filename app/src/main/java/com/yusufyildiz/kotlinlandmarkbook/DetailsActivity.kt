package com.yusufyildiz.kotlinlandmarkbook

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val intent = intent //get intent
        val landmarkName = intent.getStringExtra("name")
        textView.text = landmarkName
        /*
        val landMarkImageId = intent.getIntExtra("image",0)
        val selectedBitMap = BitmapFactory.decodeResource(applicationContext.resources,landMarkImageId)
        imageView.setImageBitmap(selectedBitMap)
        */

        val singleton = Singleton.Selected
        val selectedImage = singleton.selectedImage
        imageView.setImageBitmap(selectedImage)


    }
}