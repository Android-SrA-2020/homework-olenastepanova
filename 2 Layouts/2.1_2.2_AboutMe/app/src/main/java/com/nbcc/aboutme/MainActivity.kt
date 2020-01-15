package com.nbcc.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.done).setOnClickListener{
            //it refers to button
            addNickname(it)
        }

        // click listener hides the nickname text view, shows the edit text,
        // and shows the DONE button.
        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)
        }
    }


    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit);
        val nicknametextView = findViewById<TextView>(R.id.nickname_text);

        nicknametextView.text = editText.text;

        //hide edit field
        editText.visibility = View.GONE;

        //hide done button
        view.visibility = View.GONE;
        //set nickname textView visible
        nicknametextView.visibility = View.VISIBLE;

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE)
                as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname (view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done)

        //show the edit text, show the DONE button, and hide the text view.
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        // Set the focus to the edit text.
        editText.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)

    }
    /*
    Question 1
Which of the following is a view group?

▢ LinearLayout

Question 2
Which of the following listed view hierarchies is not valid?

▢ TextView > TextView, ImageView, ScrollView

Question 3
Styles are resources defined in styles.xml. Using styles,
you can define colors, fonts, text size, and many other
characteristics of a view. True or false?

▢ True

Question 4
A ScrollView is a view group that can contain any number
of views or view groups as its children. True or false?

▢ False

Question 5
Which UI element can be used to display images in your app?

▢ ImageView

     */


    /*
    Question 1
What is EditText a subclass of?

TextView


Question 2
Which of the following visibility attribute values, if set on a view,
makes it so the view is hidden and does not take up any space in the layout?

gone

Question 3
For EditText views, it's not a good practice to provide hints,
 because hints clutter the input field. True or false?

False

Question 4
Which one of the following statements is true about Button views?

Button views are clickable, and on click, the attached click listener performs an action.

     */
}
