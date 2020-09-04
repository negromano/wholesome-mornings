package com.example.wholesomemornings.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.wholesomemornings.model.dao.ActivityDao
import com.example.wholesomemornings.model.entities.ListedActivity

@Database(entities = [ListedActivity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private var APPDATABASE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (APPDATABASE == null) {
                APPDATABASE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, "database-name"
                ).allowMainThreadQueries().build()
            }
            return APPDATABASE
        }
    }


    abstract fun activityDao(): ActivityDao
}