package com.example.sleepr

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

import java.util.Date

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"
var TIME_START = ""
var TIME_END = ""


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /** Called when the user taps the Send button */
    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply{
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun showGraph(view: View) {
        val intent = Intent(this, GraphActivity::class.java).apply{
        }
        startActivity(intent)
    }

    fun displayDate(view: View){
        val toggle = findViewById<Button>(R.id.button2)
        val textView = findViewById<TextView>(R.id.textView2)

        val path = this.getFilesDir()
        val LogDir = File(path, "Logs")
        LogDir.mkdirs()
        val file = File(LogDir, "Log.txt")

        if(TIME_START == ""){
            TIME_START = Date().toString()
            textView.text = TIME_START
            toggle.text = "End date"
        }else if(TIME_END == ""){
            TIME_END = Date().toString()
            file.appendText("(${TIME_START}) (${TIME_END})\n")
            textView.text = TIME_START + "\n" + TIME_END
            toggle.text = "Clear date"
        }else{
            TIME_START = ""
            TIME_END = ""
            textView.text = ""
            toggle.text = "Start date"
        }
    }
}
