package com.example.civicall.CivicEngagementInfo

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.style.StyleSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.R

class ParticipantTips : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_participant_tips)

        val textview = findViewById<TextView>(R.id.info)

        val textview3 = findViewById<TextView>(R.id.info3)

        val text = "1.Stay Informed: Keep up with current events and local issues to understand what's happening in your community."
        val text1 = "2.Join Clubs: Join or create clubs at school focused on civic engagement and community service."
        val text2 = "3.Volunteer: Get involved in volunteer opportunities that align with your interests and values."
        val ss = SpannableString(text)

        val ss3 = SpannableString(text2)


        val boldSpan = StyleSpan(Typeface.BOLD)

        ss.setSpan(boldSpan, 0, 18, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)

        ss3.setSpan(boldSpan, 0, 13, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)

        textview.text = ss

        textview3.text = ss3

    }
}
