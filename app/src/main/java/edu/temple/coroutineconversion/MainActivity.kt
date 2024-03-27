package edu.temple.coroutineconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var cakeImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cakeImageView = findViewById(R.id.imageView)

        findViewById<Button>(R.id.revealButton).setOnClickListener {
            CoroutineScope(Job() + Dispatchers.Main).launch {
                animateCakeReveal()
            }
        }
    }

    suspend fun animateCakeReveal() {
        // Iterate from 0 to 100
        for (i in 0..100) {
            delay(40)
            cakeImageView.alpha = i / 100f
        }
    }
}