package com.example.yemekuygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class YemekTarifiActivity : AppCompatActivity() {
    lateinit var mealImage: ImageView
    lateinit var mealName: TextView
    lateinit var mealDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yemek_tarifi)

        mealImage = findViewById(R.id.mealImage)
        mealName = findViewById(R.id.mealName)
        mealDescription = findViewById(R.id.mealDescription)

        val name = intent.getStringExtra("mealName")
        val description = intent.getStringExtra("mealDescription")
        val imageResId = intent.getIntExtra("mealImageResId", 0)

        mealImage.setImageResource(imageResId)
        mealName.text = name
        mealDescription.text = description

    }
}