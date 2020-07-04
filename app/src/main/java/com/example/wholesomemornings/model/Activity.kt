package com.example.wholesomemornings.model

abstract class Activity(val type: String, val duration: Int, val name: String) {

    fun getActivityName(): String = this.name

}