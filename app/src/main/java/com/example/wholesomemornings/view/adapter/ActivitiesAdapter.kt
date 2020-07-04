package com.example.wholesomemornings.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wholesomemornings.R
import com.example.wholesomemornings.model.Activity
import java.util.*

class ActivitiesAdapter(private val activityListener: ClickableActivityListener) : RecyclerView.Adapter<ActivitiesAdapter.ViewHolder>() {

    private var activities = ArrayList<Activity>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val activityName: TextView = itemView.findViewById(R.id.activityNameText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_listed_activity, parent, false
        )
    )

    override fun getItemCount(): Int = activities.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activity = activities[position]

        holder.activityName.text = activity.getActivityName()

        holder.itemView.setOnClickListener {
            activityListener.onActivityClicked(activity, position)
        }

    }

}