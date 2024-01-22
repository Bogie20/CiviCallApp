package com.example.civicall

import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Handler
import android.os.Looper
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ImageSpan
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

class NetworkUtils(private val context: Context) {
    var isOnline = true
    private var connectivityCallback: ConnectivityManager.NetworkCallback? = null
    private val uiHandler = Handler(Looper.getMainLooper())
    private var isStableOnline = false
    private val stableOnlineThreshold = 5000
    private var lastLostTime: Long = 0

    fun initialize() {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkRequest = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()

        val callback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                if (!isOnline) {
                    isOnline = true
                    if (!isStableOnline) {
                        if (isNetworkStable()) {
                            showMessage("Internet Restored", R.drawable.internet_restore)
                            isStableOnline = true
                        }
                    }
                }
            }
            override fun onLost(network: Network) {
                super.onLost(network)
                if (isOnline) {
                    isOnline = false
                    isStableOnline = false
                    lastLostTime = System.currentTimeMillis() // Update lastLostTime
                    showMessage("No Internet Connection", R.drawable.nointernet_connection)
                }
            }

            private fun isNetworkStable(): Boolean {
                val currentTime = System.currentTimeMillis()
                val timeSinceLastLost = currentTime - lastLostTime
                return timeSinceLastLost > stableOnlineThreshold
            }
        }

        // Check the initial network state
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected) {
            isOnline = false
            showMessage("No Internet Connection", R.drawable.nointernet_connection)
        }

        connectivityManager.registerNetworkCallback(networkRequest, callback)
        connectivityCallback = callback
    }

    private fun showMessage(message: String, iconResId: Int) {
        uiHandler.post {
            val rootView = (context as Activity).findViewById<View>(android.R.id.content)
            val snackbar = Snackbar.make(rootView, "", Snackbar.LENGTH_LONG)
            val snackbarView = snackbar.view

            val spannableMessage = SpannableString("      $message")
            val icon: Drawable = ContextCompat.getDrawable(context, iconResId)!!
            icon.setBounds(0, 0, icon.intrinsicWidth, icon.intrinsicHeight)

            // Create a CenteredImageSpan for both the icon and text
            val centeredImageSpan = CenteredImageSpan(icon)
            spannableMessage.setSpan(centeredImageSpan, 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

            val textView: TextView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text)
            textView.text = spannableMessage

            snackbar.show()
        }
    }

    fun cleanup() {
        connectivityCallback?.let { callback ->
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            connectivityManager.unregisterNetworkCallback(callback)
        }
    }
}

class CenteredImageSpan(drawable: Drawable) : ImageSpan(drawable, ImageSpan.ALIGN_CENTER) {
    override fun getSize(
        paint: Paint,
        text: CharSequence?,
        start: Int,
        end: Int,
        fm: Paint.FontMetricsInt?
    ): Int {
        val rect = drawable.bounds
        if (fm != null) {
            val fontMetrics = paint.fontMetricsInt
            val lineHeight = fontMetrics.descent - fontMetrics.ascent
            val drHeight = rect.bottom - rect.top
            val centerY = fontMetrics.ascent + (lineHeight - drHeight) / 2
            fm.ascent = centerY
            fm.descent = centerY + drHeight
            fm.top = fm.ascent
            fm.bottom = fm.descent
        }
        return rect.right
    }
}
