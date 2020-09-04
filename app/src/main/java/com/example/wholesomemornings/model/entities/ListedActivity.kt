package com.example.wholesomemornings.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "listed_activity")
@Parcelize
data class ListedActivity(
    @ColumnInfo(name = "additional_data") val additionalData: String = ""
) : Activity() {

}