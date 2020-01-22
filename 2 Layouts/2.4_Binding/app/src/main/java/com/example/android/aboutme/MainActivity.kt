/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.aboutme.databinding.ActivityMainBinding


/**
 * Main Activity of the AboutMe app.
 * This codelab demonstrates how to add:
 *     * Data binding between MainActivity and activity_main.xml. How to remove findViewById,
 *       and how to display data in views using the data binding object.
 * This is the starter app.
 */
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val myName: MyName = MyName("Olena Stepanova")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
        binding.myName = myName
    }

    /**
     * Click handler for the Done button.
     */
    private fun addNickname(view: View) {

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()

            //to refresh binging object
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    /**
     * Question 1
    Why do you want to minimize explicit and implicit calls to findViewById()?

    Every time findViewById() is called, it traverses the view hierarchy.

    Question 2
    How would you describe data binding?

    For example, here are some things you could say about data binding:

    The big idea about data binding is to create an object that connects/maps/binds
    two pieces of distant information together at compile time, so that
    you don't have to look for the data at runtime.


    Question 3
    Which of the following is NOT a benefit of data binding?

    Calling findViewById() generates a compiler error.


    Question 4
    What is the function of the <layout> tag?


    Bindings are created for all the views in a layout.

    Question 5
    Which is the correct way to reference bound data in the XML layout?

    android:text="@={myDataClass.property}"

     */
}
