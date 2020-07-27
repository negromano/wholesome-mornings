package com.example.wholesomemornings.model

abstract class Activity(val type: String, val name: String) {

    fun getActivityName(): String = this.name

    fun getActivityType(): String = this.type

}