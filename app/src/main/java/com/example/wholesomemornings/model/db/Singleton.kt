package com.example.wholesomemornings.model.db

import android.content.Context
import androidx.room.Room

class Singleton {
    companion object {

        private var APPDATABASE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (APPDATABASE == null) {
                synchronized(AppDatabase::class) {
                    APPDATABASE = Room.databaseBuilder(context,
                        AppDatabase::class.java, "wholesome.db").allowMainThreadQueries()
                        .build()
                }
            }
            return APPDATABASE
        }
    }
}