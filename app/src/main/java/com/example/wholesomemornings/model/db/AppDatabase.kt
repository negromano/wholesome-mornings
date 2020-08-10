package com.example.wholesomemornings.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wholesomemornings.model.entities.ListedActivity

@Database(entities = [ListedActivity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): ListedActivity
}