package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)


        val countButton: Button = findViewById(R.id.count_button)
        val resetButton: Button = findViewById(R.id.reset_button)

        rollButton.setOnClickListener{rollDice()}
        countButton.setOnClickListener{countUp()}
        resetButton.setOnClickListener{reset()}
    }

    private fun rollDice(){
        //Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show();
        //generates random number
        val random = Random.nextInt(6) + 1
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = random.toString()

    }

    private fun countUp(){
        val resultText: TextView = findViewById(R.id.result_text)
        var text = resultText.text.toString()

        if(text == "Hello World!"){
            resultText.text = "1"
        }
        else if(text != "6"){
            resultText.text = (text.toInt() + 1).toString()
        }
    }

    private fun reset(){
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "0"
    }

    //Questions
    /*
    Q1 - setContentView()
    Q2 - android:layout_width="wrap_content"
     */
}
