package com.example.week.Main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.week.Days.Monday.Monday
import com.example.week.R
import com.example.week.Timetable.TimeTable


class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun LetsGoToMon(view: View){
        intent = Intent(this, Monday::class.java)
        startActivity(intent)
        finish()
    }

    fun MethodRefTimetable(view: View){
        intent = Intent(this, TimeTable::class.java)
        startActivity(intent)
        finish()
    }
}