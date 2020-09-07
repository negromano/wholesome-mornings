package com.example.wholesomemornings.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "listed_activity")
@Parcelize
data class ListedActivity(
    @ColumnInfo(name = "additional_data") var additionalData: String = ""
) : Activity() {
    constructor(name: String, type: String, additionalData: String) : this() {
        this.name = name
        this.type = type
        this.additionalData = additionalData
    }
}