package com.example.marvelopenapp.utils

import java.util.*

class DateUtils {

    companion object{
        fun getTimeMillisNow(): String {
            return (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
        }
    }
}