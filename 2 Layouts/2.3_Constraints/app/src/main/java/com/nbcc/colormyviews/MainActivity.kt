package com.nbcc.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun makeColored(view: View) {

        when(view.id){
            //change color
            //R.id.box_two_text -> view.setBackgroundResource(R.drawable.image_two)
            R.id.box_one_text -> view.setBackgroundColor(Color.CYAN)
            R.id.box_two_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_three_text -> view.setBackgroundColor(Color.GREEN)
            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.RED)

            // Boxes using custom colors for background
            R.id.red_button -> box_three_text.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> box_four_text.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> box_five_text.setBackgroundResource(R.color.my_green)



            //IF user tapped on screen not on a textView
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    //set event listeners
    private fun setListeners() {

        //references to textViews
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        //buttons references
        val redButton = findViewById<Button>(R.id.red_button)
        val greenButton = findViewById<Button>(R.id.green_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)


        //list of all 5 textViews and constraint layout screen
        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, rootConstraintLayout,
                redButton, greenButton, yellowButton)

        //attach listener
        for(item in clickableViews){
            item.setOnClickListener{ makeColored(it)}
        }
    }
}

/*
* Question 1
In a constraint layout, which of the following choices describes the
* constraints needed to keep a view in place during runtime?

At least one horizontal and one vertical constraint.

Question 2
Which of the following constraint types expands a view only as much as
* needed to fit its contents?

Match constraint

*
Question 3
The baseline constraint aligns the text baseline of a view to the text
* baseline of another view. True or false?

True

Question 4
The view inspector is available only for views in _______ .

A ConstraintLayout

Question 5
A chain is a group of views that are linked to each other with ________ .

Bidirectional constraints

*
* */
