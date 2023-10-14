package com.example.civicall

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Handler
import android.os.Looper
import android.view.View
import com.google.android.material.snackbar.Snackbar

class NetworkUtils(private val context: Context) {
    var isOnline = true
    private var connectivityCallback: ConnectivityManager.NetworkCallback? = null
    private val uiHandler = Handler(Looper.getMainLooper())
    private var isStableOnline = false
    private val stableOnlineThreshold = 5000
    private var lastLostTime: Long = 0 // Initialize lastLostTime

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
                            showMessage("Internet Restored")
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
                    showMessage("No Internet Connection")
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
            showMessage("No Internet Connection")
        }

        connectivityManager.registerNetworkCallback(networkRequest, callback)
        connectivityCallback = callback
    }

    private fun showMessage(message: String) {
        uiHandler.post {
            val rootView = (context as Activity).findViewById<View>(android.R.id.content)
            val snackbar = Snackbar.make(rootView, message, Snackbar.LENGTH_LONG)
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
