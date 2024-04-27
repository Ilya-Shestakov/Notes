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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week.Days.Monday.DBHelperMon
import com.example.week.Timetable.Sunday.DBHelperSundayTimetable
import com.example.week.Timetable.Sunday.DatalistSundayTimetable
import com.example.week.Timetable.Saturday.DBHelperSaturdayTimetable
import com.example.week.Timetable.Saturday.DatalistSaturdayTimetable
import com.example.week.Timetable.Friday.DBHelperFridayTimetable
import com.example.week.Timetable.Friday.DatalistFridayTimetable
import com.example.week.Main.MainActivity
import com.example.week.Timetable.Sunday.MyAdapterSundayTimetable
import com.example.week.Timetable.Saturday.MyAdapterSaturdayTimetable
import com.example.week.Timetable.Friday.MyAdapterFridayTimetable
import com.example.week.Timetable.Monday.DBHelperMondayTimeTable
import com.example.week.Timetable.Monday.DatalisMondayTimetable
import com.example.week.Timetable.Monday.MyAdapterMondaytimetable
import com.example.week.R
import com.example.week.Timetable.Thursday.DBHelperThursdayTimetable
import com.example.week.Timetable.Thursday.DatalistThursdayTimetable
import com.example.week.Timetable.Thursday.MyAdapterThursdayTimetable
import com.example.week.Timetable.Tuesday.DBHelperTuesdayTimetable
import com.example.week.Timetable.Tuesday.DatalistTuesdayTimetable
import com.example.week.Timetable.Tuesday.MyAdapterTuesdayTimetable
import com.example.week.Timetable.Wednesday.DBHelperWednesdayTimetable
import com.example.week.Timetable.Wednesday.DatalistWednesdayTimetable
import com.example.week.Timetable.Wednesday.MyAdapterWednesdayTimetable

class TimeTable : AppCompatActivity() {

    lateinit var dialog: Dialog


    lateinit var editTextInDialogNewWorkMonday: EditText
    lateinit var DBHelperMondayTimeTable: DBHelperMondayTimeTable
    lateinit var recyclerViewTimeTableMonday: RecyclerView
    private lateinit var newArrTrainings: ArrayList<DatalisMondayTimetable>
    private lateinit var adapter: MyAdapterMondaytimetable

    lateinit var DBHelperMonday: DBHelperMon

    lateinit var editTextInDialogNewWorkTuesday: EditText
    lateinit var DBHelperTuesdayTimeTable: DBHelperTuesdayTimetable
    lateinit var recyclerViewTimeTableTuesday: RecyclerView
    private lateinit var newArrTrainingsTue: ArrayList<DatalistTuesdayTimetable>
    private lateinit var adapterTue: MyAdapterTuesdayTimetable

    lateinit var editTextInDialogNewWorkWednesday: EditText
    lateinit var DBHelperWednesdayTimeTable: DBHelperWednesdayTimetable
    lateinit var recyclerViewTimeTableWednesday: RecyclerView
    private lateinit var newArrTrainingsWednesday: ArrayList<DatalistWednesdayTimetable>
    private lateinit var adapterWednesday: MyAdapterWednesdayTimetable

    lateinit var editTextInDialogNewWorkThursday: EditText
    lateinit var DBHelperThursdayTimeTable: DBHelperThursdayTimetable
    lateinit var recyclerViewTimeTableThursday: RecyclerView
    private lateinit var newArrTrainingsThursday: ArrayList<DatalistThursdayTimetable>
    private lateinit var adapterThursday: MyAdapterThursdayTimetable

    lateinit var editTextInDialogNewWorkFriday: EditText
    lateinit var DBHelperFridayTimeTable: DBHelperFridayTimetable
    lateinit var recyclerViewTimeTableFriday: RecyclerView
    private lateinit var newArrTrainingsFriday: ArrayList<DatalistFridayTimetable>
    private lateinit var adapterFriday: MyAdapterFridayTimetable

    lateinit var editTextInDialogNewWorkSaturday: EditText
    lateinit var DBHelperSaturdayTimeTable: DBHelperSaturdayTimetable
    lateinit var recyclerViewTimeTableSaturday: RecyclerView
    private lateinit var newArrTrainingsSaturday: ArrayList<DatalistSaturdayTimetable>
    private lateinit var adapterSaturday: MyAdapterSaturdayTimetable

    lateinit var editTextInDialogNewWorkSunday: EditText
    lateinit var DBHelperSundayTimeTable: DBHelperSundayTimetable
    lateinit var recyclerViewTimeTableSunday: RecyclerView
    private lateinit var newArrTrainingsSunday: ArrayList<DatalistSundayTimetable>
    private lateinit var adapterSunday: MyAdapterSundayTimetable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_table)

        dialog = Dialog(this)

        DBHelperMondayTimeTable = DBHelperMondayTimeTable(this)
        DBHelperTuesdayTimeTable = DBHelperTuesdayTimetable(this)
        DBHelperWednesdayTimeTable = DBHelperWednesdayTimetable(this)
        DBHelperThursdayTimeTable = DBHelperThursdayTimetable(this)
        DBHelperFridayTimeTable = DBHelperFridayTimetable(this)
        DBHelperSaturdayTimeTable = DBHelperSaturdayTimetable(this)
        DBHelperSundayTimeTable = DBHelperSundayTimetable(this)
        DBHelperMonday = DBHelperMon(this)

        recyclerViewTimeTableMonday = findViewById(R.id.RecyclerMondayTimeTable)
        recyclerViewTimeTableMonday.layoutManager = LinearLayoutManager(this)
        recyclerViewTimeTableMonday.setHasFixedSize(true)
        dispayuser()

        recyclerViewTimeTableTuesday = findViewById(R.id.RecyclerTuesdayTimeTable)
        recyclerViewTimeTableTuesday.layoutManager = LinearLayoutManager(this)
        recyclerViewTimeTableTuesday.setHasFixedSize(true)
        dispayuserTue()

        recyclerViewTimeTableWednesday = findViewById(R.id.RecyclerWednesdayTimeTable)
        recyclerViewTimeTableWednesday.layoutManager = LinearLayoutManager(this)
        recyclerViewTimeTableWednesday.setHasFixedSize(true)
        dispayuserWednesday()

        recyclerViewTimeTableThursday = findViewById(R.id.RecyclerThursdayTimeTable)
        recyclerViewTimeTableThursday.layoutManager = LinearLayoutManager(this)
        recyclerViewTimeTableThursday.setHasFixedSize(true)
        dispayuserThursday()

        recyclerViewTimeTableFriday = findViewById(R.id.RecyclerFridayTimeTable)
        recyclerViewTimeTableFriday.layoutManager = LinearLayoutManager(this)
        recyclerViewTimeTableFriday.setHasFixedSize(true)
        dispayuserFriday()

        recyclerViewTimeTableSaturday = findViewById(R.id.RecyclerSaturdayTimeTable)
        recyclerViewTimeTableSaturday.layoutManager = LinearLayoutManager(this)
        recyclerViewTimeTableSaturday.setHasFixedSize(true)
        dispayuserSaturday()

        recyclerViewTimeTableSunday = findViewById(R.id.RecyclerSundayTimeTable)
        recyclerViewTimeTableSunday.layoutManager = LinearLayoutManager(this)
        recyclerViewTimeTableSunday.setHasFixedSize(true)
        dispayuserSunday()

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

    fun dispayuserTue() {
        val newcursor: Cursor? = DBHelperTuesdayTimeTable.gettext()
        newArrTrainingsTue = ArrayList<DatalistTuesdayTimetable>()
        while (newcursor!!.moveToNext()){
            val uname = newcursor.getString(0)
            newArrTrainingsTue.add(DatalistTuesdayTimetable(uname))
        }
        adapterTue = MyAdapterTuesdayTimetable(newArrTrainingsTue)
        recyclerViewTimeTableTuesday.adapter = adapterTue
        adapterTue.OnItemClickListener(object: MyAdapterTuesdayTimetable.onItemClickListener {
            override fun onItemClick(position: Int) {
                DBHelperTuesdayTimeTable.deleteuserdata(newArrTrainingsTue[position].name)
                dispayuserTue()
            }
        })
    }

    fun dispayuserWednesday() {
        val newcursor: Cursor? = DBHelperWednesdayTimeTable.gettext()
        newArrTrainingsWednesday = ArrayList<DatalistWednesdayTimetable>()
        while (newcursor!!.moveToNext()){
            val uname = newcursor.getString(0)
            newArrTrainingsWednesday.add(DatalistWednesdayTimetable(uname))
        }
        adapterWednesday = MyAdapterWednesdayTimetable(newArrTrainingsWednesday)
        recyclerViewTimeTableWednesday.adapter = adapterWednesday
        adapterWednesday.OnItemClickListener(object: MyAdapterWednesdayTimetable.onItemClickListener {
            override fun onItemClick(position: Int) {
                DBHelperWednesdayTimeTable.deleteuserdata(newArrTrainingsWednesday[position].name)
                dispayuserWednesday()
            }
        })
    }

    fun dispayuserThursday() {
        val newcursor: Cursor? = DBHelperThursdayTimeTable.gettext()
        newArrTrainingsThursday = ArrayList<DatalistThursdayTimetable>()
        while (newcursor!!.moveToNext()){
            val uname = newcursor.getString(0)
            newArrTrainingsThursday.add(DatalistThursdayTimetable(uname))
        }
        adapterThursday = MyAdapterThursdayTimetable(newArrTrainingsThursday)
        recyclerViewTimeTableThursday.adapter = adapterThursday
        adapterThursday.OnItemClickListener(object: MyAdapterThursdayTimetable.onItemClickListener {
            override fun onItemClick(position: Int) {
                DBHelperThursdayTimeTable.deleteuserdata(newArrTrainingsThursday[position].name)
                dispayuserThursday()
            }
        })
    }

    fun dispayuserFriday() {
        val newcursor: Cursor? = DBHelperFridayTimeTable.gettext()
        newArrTrainingsFriday = ArrayList<DatalistFridayTimetable>()
        while (newcursor!!.moveToNext()){
            val uname = newcursor.getString(0)
            newArrTrainingsFriday.add(DatalistFridayTimetable(uname))
        }
        adapterFriday = MyAdapterFridayTimetable(newArrTrainingsFriday)
        recyclerViewTimeTableFriday.adapter = adapterFriday
        adapterFriday.OnItemClickListener(object: MyAdapterFridayTimetable.onItemClickListener {
            override fun onItemClick(position: Int) {
                DBHelperFridayTimeTable.deleteuserdata(newArrTrainingsFriday[position].name)
                dispayuserFriday()
            }
        })
    }

    fun dispayuserSaturday() {
        val newcursor: Cursor? = DBHelperSaturdayTimeTable.gettext()
        newArrTrainingsSaturday = ArrayList<DatalistSaturdayTimetable>()
        while (newcursor!!.moveToNext()){
            val uname = newcursor.getString(0)
            newArrTrainingsSaturday.add(DatalistSaturdayTimetable(uname))
        }
        adapterSaturday = MyAdapterSaturdayTimetable(newArrTrainingsSaturday)
        recyclerViewTimeTableSaturday.adapter = adapterSaturday
        adapterSaturday.OnItemClickListener(object: MyAdapterSaturdayTimetable.onItemClickListener {
            override fun onItemClick(position: Int) {
                DBHelperSaturdayTimeTable.deleteuserdata(newArrTrainingsSaturday[position].name)
                dispayuserSaturday()
            }
        })
    }

    fun dispayuserSunday() {
        val newcursor: Cursor? = DBHelperSundayTimeTable.gettext()
        newArrTrainingsSunday = ArrayList<DatalistSundayTimetable>()
        while (newcursor!!.moveToNext()){
            val uname = newcursor.getString(0)
            newArrTrainingsSunday.add(DatalistSundayTimetable(uname))
        }
        adapterSunday = MyAdapterSundayTimetable(newArrTrainingsSunday)
        recyclerViewTimeTableSunday.adapter = adapterSunday
        adapterSunday.OnItemClickListener(object: MyAdapterSundayTimetable.onItemClickListener {
            override fun onItemClick(position: Int) {
                DBHelperSundayTimeTable.deleteuserdata(newArrTrainingsSunday[position].name)
                dispayuserSunday()
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

    fun methodOpenDialogTuesday(view: View){
        dialog = Dialog(this@TimeTable)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_new_work_tue)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    fun methodOpenDialogWednesday(view: View){
        dialog = Dialog(this@TimeTable)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_new_work_wed)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    fun methodOpenDialogThursday(view: View){
        dialog = Dialog(this@TimeTable)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_new_work_thursday)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    fun methodOpenDialogFriday(view: View){
        dialog = Dialog(this@TimeTable)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_new_work_friday)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    fun methodOpenDialogSaturday(view: View){
        dialog = Dialog(this@TimeTable)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_new_work_saturday)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    fun methodOpenDialogSunday(view: View){
        dialog = Dialog(this@TimeTable)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_new_work_sunday)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }



    fun methodSaveWorkMonday(view: View){
        editTextInDialogNewWorkMonday = dialog.findViewById(R.id.editTextInDialogNewWorkMonday)
        DBHelperMondayTimeTable.saveuserdata(editTextInDialogNewWorkMonday.text.toString())
        DBHelperMonday.saveuserdata(editTextInDialogNewWorkMonday.text.toString())
        dialog.cancel()
        dispayuser()
    }

    fun methodSaveWorkTuesday(view: View){
        editTextInDialogNewWorkTuesday = dialog.findViewById(R.id.editTextInDialogNewWorkTuesday)
        DBHelperTuesdayTimeTable.saveuserdata(editTextInDialogNewWorkTuesday.text.toString())
        dialog.cancel()
        dispayuserTue()
    }

    fun methodSaveWorkWednesday(view: View){
        editTextInDialogNewWorkWednesday = dialog.findViewById(R.id.editTextInDialogNewWorkWednesday)
        DBHelperWednesdayTimeTable.saveuserdata(editTextInDialogNewWorkWednesday.text.toString())
        dialog.cancel()
        dispayuserWednesday()
    }

    fun methodSaveWorkThursday(view: View){
        editTextInDialogNewWorkThursday = dialog.findViewById(R.id.editTextInDialogNewWorkThusday)
        DBHelperThursdayTimeTable.saveuserdata(editTextInDialogNewWorkThursday.text.toString())
        dialog.cancel()
        dispayuserThursday()
    }

    fun methodSaveWorkFriday(view: View){
        editTextInDialogNewWorkFriday = dialog.findViewById(R.id.editTextInDialogNewWorkFriday)
        DBHelperFridayTimeTable.saveuserdata(editTextInDialogNewWorkFriday.text.toString())
        dialog.cancel()
        dispayuserFriday()
    }

    fun methodSaveWorkSaturday(view: View){
        editTextInDialogNewWorkSaturday = dialog.findViewById(R.id.editTextInDialogNewWorkSaturday)
        DBHelperSaturdayTimeTable.saveuserdata(editTextInDialogNewWorkSaturday.text.toString())
        dialog.cancel()
        dispayuserSaturday()
    }

    fun methodSaveWorkSunday(view: View){
        editTextInDialogNewWorkSunday = dialog.findViewById(R.id.editTextInDialogNewWorkSunday)
        DBHelperSundayTimeTable.saveuserdata(editTextInDialogNewWorkSunday.text.toString())
        dialog.cancel()
        dispayuserSunday()
    }



    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}