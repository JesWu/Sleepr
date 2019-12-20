package com.example.sleepr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.io.File
import java.io.FileInputStream

class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }

        val textView3 = findViewById<TextView>(R.id.textView3).apply {
            var file = File("" + getFilesDir() + "/Logs/Log.txt")
            text = FileInputStream(file).bufferedReader().use { file.readText() }
        }
    }
}
