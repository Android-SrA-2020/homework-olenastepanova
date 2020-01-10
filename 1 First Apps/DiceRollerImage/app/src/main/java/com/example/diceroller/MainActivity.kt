package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var diceImage: ImageView
    private lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)

        val rollButton: Button = findViewById(R.id.roll_button)
        val clearButton: Button = findViewById(R.id.clear_button)

        rollButton.setOnClickListener { rollDice() }
        clearButton.setOnClickListener { clear() }

    }

    private fun rollDice() {

        diceImage.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
    }

    private fun clear() {
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
    }

    private fun getRandomDiceImage(): Int {

        val random = Random.nextInt(6) + 1

        return when (random) {
            1 -> R.drawable.dice_1;
            2 -> R.drawable.dice_2;
            3 -> R.drawable.dice_3;
            4 -> R.drawable.dice_4;
            5 -> R.drawable.dice_5;
            else -> R.drawable.dice_6
        }
    }


    /*
    Questions
    Which method changes the image resource for an ImageView in Kotlin code? xmx
	* setImageResource()

    Which <ImageView> attribute indicates a source image that should be used only in Android Studio?
	* tools:src

    What does the lateinit keyword in a variable declaration indicate in Kotlin code?
	*  The variable will be initialized later. I promise!


    Which Gradle configuration indicates the most recent API level your app has been tested with?
	* compileSdkVersion

    You see an import line in your code that starts with androidx. What does this mean?
	* The class is part of the Android Jetpack libraries.


     */

}
