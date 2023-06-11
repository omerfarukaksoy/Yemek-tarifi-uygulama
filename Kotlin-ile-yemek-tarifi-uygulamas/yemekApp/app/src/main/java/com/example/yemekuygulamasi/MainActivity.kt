package com.example.yemekuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainImage: ImageView = findViewById(R.id.imageView)
        mainImage.setImageResource(R.drawable.kahve_logo)

        progressBar = findViewById(R.id.progressBar)

        val totalSteps = 10

        var completedSteps = 0

        val stepDuration = 300L

        val handler = Handler(Looper.getMainLooper())

        handler.postDelayed(object : Runnable {
            override fun run() {
                completedSteps++

                val progress =
                    (completedSteps.toFloat() / totalSteps.toFloat()) * 100

                progressBar.progress = progress.toInt()

                if (completedSteps < totalSteps) {
                    handler.postDelayed(this, stepDuration)
                } else {
                    val intent = Intent(
                        this@MainActivity,
                        YemekListesiActivity::class.java
                    )
                    startActivity(intent)
                    finish()
                }
            }
        }, stepDuration)

    }
}