package com.example.wholesomemornings.utils

import android.content.Context
import android.widget.Toast

class Toaster {
    companion object {
        fun shortToast(context: Context, msg: String) {
            val toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}