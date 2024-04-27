package com.example.week.Days.Monday

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Contacts.Data
import android.view.View
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week.Main.MainActivity
import com.example.week.R
import com.example.week.Timetable.Monday.DatalisMondayTimetable
import com.example.week.Timetable.Monday.MyAdapterMondaytimetable

class Monday : AppCompatActivity() {

    private lateinit var recyclerBlockMonday: RecyclerView
    private lateinit var adapterMon: AdapterMon
    private lateinit var datalist: ArrayList<DatalistMon>
    private lateinit var dbHelper: DBHelperMon
    private lateinit var btnRed: ConstraintLayout
    private lateinit var btnGreen: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monday)

        dbHelper = DBHelperMon(this)

        recyclerBlockMonday = findViewById(R.id.recyclerBlockMonday)
        recyclerBlockMonday.layoutManager = LinearLayoutManager(this)
        recyclerBlockMonday.setHasFixedSize(true)
        dispayuser()

    }

    private fun dispayuser() {
        val newcursor: Cursor? = dbHelper.gettext()
        datalist = ArrayList<DatalistMon>()
        while (newcursor!!.moveToNext()){
            val uname = newcursor.getString(0)
            datalist.add(DatalistMon(uname))
        }
        adapterMon = AdapterMon(datalist)
        recyclerBlockMonday.adapter = adapterMon
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    @SuppressLint("ResourceAsColor")
    fun MethodCheckGreen(view: View){
        btnGreen = findViewById(R.id.btnCheckGreen)
        btnGreen.setBackgroundColor(R.color.green)
    }

    @SuppressLint("ResourceAsColor")
    fun MethodCheckRed(view: View){
        btnRed = findViewById(R.id.btnCheckRed)
        btnRed.setBackgroundColor(R.color.red)
    }

}