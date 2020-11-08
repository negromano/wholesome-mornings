package com.example.wholesomemornings.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.wholesomemornings.model.entities.ListedActivity

@Dao
interface ActivityDao {
    @Query("SELECT * FROM listed_activity")
    fun getAll(): List<ListedActivity>

    @Insert
    fun insertAll(vararg activities: ListedActivity)

    @Delete
    fun delete(activity: ListedActivity)
}
