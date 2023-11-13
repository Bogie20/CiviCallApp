package com.example.civicall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.GoogleApiClient
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.api.client.http.HttpTransport
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.calendar.CalendarScopes
import com.google.api.services.calendar.model.CalendarList

class GoogleCalerndar : AppCompatActivity() {

    private lateinit var mGoogleApiClient: GoogleApiClient
    private lateinit var mCredential: GoogleAccountCredential
    private val SCOPES = listOf(CalendarScopes.CALENDAR_READONLY)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_calerndar)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        mGoogleApiClient = GoogleApiClient.Builder(this)
            .enableAutoManage(this) { connectionResult ->
                Log.d("GoogleApiClient", "onConnectionFailed: $connectionResult")
            }
            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
            .build()

        mCredential = GoogleAccountCredential.usingOAuth2(
            applicationContext, SCOPES
        )

        val account = GoogleSignIn.getLastSignedInAccount(this)
        if (account != null) {
            mCredential.selectedAccount = account.account
            // Now you can use mCredential to access the user's Google Calendar
            getCalendarList()
        } else {
            // Handle the case where the user is not signed in
        }
    }

    private fun getCalendarList() {
        // Perform API request to get the user's calendars
        val transport: HttpTransport = NetHttpTransport()
        val jsonFactory: JsonFactory = JacksonFactory.getDefaultInstance()
        val service = com.google.api.services.calendar.Calendar.Builder(
            transport, jsonFactory, mCredential
        )
            .setApplicationName("CIVICALL APP")
            .build()

        val calendarList: CalendarList = service.calendarList().list().execute()
        // Now you can access the user's calendars in `calendarList`
        // Handle the calendar data as needed
    }
}
