package com.example.wholesomemornings.view.adapter

import com.example.wholesomemornings.model.entities.Activity

interface ClickableActivityListener {
    fun onActivityClicked(activity: Activity, position: Int)
}