package com.example.wholesomemornings.model.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
open class Activity(
    @PrimaryKey(autoGenerate = true) var uid: Int = 0,
    @ColumnInfo(name = "name") var name: String = "ACTIVIDAD POR DEFECTO",
    @ColumnInfo(name = "type") var type: String = "TIPO POR DEFECTO"
) : Parcelable {

    fun getActivityName(): String = this.name

    fun getActivityType(): String = this.type

}