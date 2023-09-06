package com.example.civicall

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.os.Build
import android.provider.Settings
import android.widget.Toast
import java.util.*

class Rewardforms : AppCompatActivity() {

    lateinit var btnrwrd: Button
    lateinit var timepref: SharedPreferences
    var todaystring: String = ""
    var year: Int = 0
    var month: Int = 0
    var day: Int = 0
    var points: Int = 0
    var daily: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rewardforms)
        btnrwrd = findViewById(R.id.add) // Replace with your button ID
        timepref = getSharedPreferences("REWARD", 0)

        val calendar: Calendar = Calendar.getInstance()
        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        day = calendar.get(Calendar.DAY_OF_MONTH)

        todaystring = "$year$month$day"

        val currentday = timepref.getBoolean(todaystring, false)

        // Initialize points and daily from SharedPreferences
        val sharedPreferences = getSharedPreferences("SAVING", Context.MODE_PRIVATE)
        points = sharedPreferences.getInt("mypoints", 0)
        daily = sharedPreferences.getInt("daily", 0)

        // Daily reward
        if (!currentday && isZoneAutomatic(this) && isTimeAutomatic(this)) {
            btnrwrd.isEnabled = true
            btnrwrd.text = "Collect your daily reward!"
            btnrwrd.setOnClickListener {
                Toast.makeText(this, "Daily reward granted!", Toast.LENGTH_SHORT).show()
                // Do your stuff here
                val edt = sharedPreferences.edit()
                edt.putInt("mypoints", points + daily) // Adding the daily reward to points
                edt.apply()
                daily = daily + 1 // Incrementing daily reward counter
                Toast.makeText(this, daily.toString(), Toast.LENGTH_SHORT).show()
                val timedaily = timepref.edit()
                timedaily.putBoolean(todaystring, true)
                timedaily.apply()
                btnrwrd.text = "Wait for 24 hrs"
                btnrwrd.isEnabled = false
            }
        } else {
            Toast.makeText(this, "Your daily reward is over!", Toast.LENGTH_SHORT).show()
        }
    }

    fun isTimeAutomatic(c: Context): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Settings.Global.getInt(c.contentResolver, Settings.Global.AUTO_TIME, 0) == 1
        } else {
            android.provider.Settings.System.getInt(c.contentResolver, android.provider.Settings.System.AUTO_TIME, 0) == 1
        }
    }

    fun isZoneAutomatic(c: Context): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Settings.Global.getInt(c.contentResolver, Settings.Global.AUTO_TIME_ZONE, 0) == 1
        } else {
            android.provider.Settings.System.getInt(c.contentResolver, android.provider.Settings.System.AUTO_TIME, 0) == 1
        }
    }
}
