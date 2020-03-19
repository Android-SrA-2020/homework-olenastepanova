package com.example.android.trackmysleepquality.sleeptracker

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.TextItemViewHolder
import com.example.android.trackmysleepquality.database.SleepNight


class SleepNightAdapter: RecyclerView.Adapter<TextItemViewHolder>(){
    //list of sleep night
    //when data is changed - adapter knows, but not RV -> need to pass it
    var data =  listOf<SleepNight>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }




    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        //set the text
        holder.textView.text = item.sleepQuality.toString()

        //change color if quality 1 or 0
        if (item.sleepQuality <= 1) {
            holder.textView.setTextColor(Color.RED) // red
        } else {
            // reset because RV will re-use the view holders
            holder.textView.setTextColor(Color.BLACK) // black
        }
    }

    // when RV needs a Viewholder to present an item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {

        //instance knows how to create View from xml layout
        val layoutInflater = LayoutInflater.from(parent.context)

        //create a view
        val view = layoutInflater
                .inflate(R.layout.text_item_view, parent, false) as TextView

        return TextItemViewHolder(view)
    }
}
