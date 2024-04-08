package com.example.week.Timetable

import android.app.Dialog
import android.content.Intent
import android.database.Cursor
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week.DBHelperMondayTimeTable
import com.example.week.DatalisMondayTimetable
import com.example.week.MyAdapterMondaytimetable
import com.example.week.R

class TimeTable : AppCompatActivity() {

    lateinit var dialog: Dialog
    lateinit var editTextInDialogNewWorkMonday: EditText
    lateinit var DBHelperMondayTimeTable: DBHelperMondayTimeTable
    lateinit var recyclerViewTimeTableMonday: RecyclerView
    private lateinit var newArrTrainings: ArrayList<DatalisMondayTimetable>
    private lateinit var adapter: MyAdapterMondaytimetable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_table)

        dialog = Dialog(this)
        DBHelperMondayTimeTable = DBHelperMondayTimeTable(this)

        recyclerViewTimeTableMonday = findViewById(R.id.RecyclerMondayTimeTable)

        recyclerViewTimeTableMonday.layoutManager = LinearLayoutManager(this)
        recyclerViewTimeTableMonday.setHasFixedSize(true)
        dispayuser()

    }

    fun dispayuser() {
        val newcursor: Cursor? = DBHelperMondayTimeTable.gettext()
        newArrTrainings = ArrayList<DatalisMondayTimetable>()
        while (newcursor!!.moveToNext()){
            val uname = newcursor.getString(0)
            newArrTrainings.add(DatalisMondayTimetable(uname))
        }
        adapter = MyAdapterMondaytimetable(newArrTrainings)
        recyclerViewTimeTableMonday.adapter = adapter
        adapter.OnItemClickListener(object: MyAdapterMondaytimetable.onItemClickListener {
            override fun onItemClick(position: Int) {
                DBHelperMondayTimeTable.deleteuserdata(newArrTrainings[position].name)
                dispayuser()
            }
        })
    }

    fun methodOpenDialogMonday(view: View){
        dialog = Dialog(this@TimeTable)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_new_work_monday)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    fun methodSaveWorkMonday(view: View){
        editTextInDialogNewWorkMonday = dialog.findViewById(R.id.editTextInDialogNewWorkMonday)
        DBHelperMondayTimeTable.saveuserdata(editTextInDialogNewWorkMonday.text.toString())
        dialog.cancel()
        dispayuser()
    }

}