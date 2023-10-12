package com.example.civicall

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class NetworkUtils(private val context: Context) {
    private var alertDialog: AlertDialog? = null
    private var retryButton: Button? = null
    private var isNetworkAvailable = true // Add this variable

    init {
        isNetworkAvailable = isNetworkAvailable()
        if (!isNetworkAvailable) {
            showCustomPopupInternet()
        }
        registerNetworkCallback()
    }

    private fun registerNetworkCallback() {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val builder = NetworkRequest.Builder()

        connectivityManager.registerNetworkCallback(
            builder.build(),
            object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    if (!isNetworkAvailable) {
                        isNetworkAvailable = true
                        showInternetRestoredToast()
                        // Internet is restored, dismiss the popup
                        dismissCustomPopup()
                    }
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    isNetworkAvailable = false
                    showCustomPopupInternet()
                }
            }
        )
    }


    private fun showInternetRestoredToast() {
        Handler(Looper.getMainLooper()).post {
            showInternetRestoredCustomToast("Internet Restored")
        }
    }
    private fun showInternetRestoredCustomToast(message: String) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(R.layout.dialog_connectify_success, null)

        val text = layout.findViewById<TextView>(R.id.text_message_connectify_success)
        text.text = message

        val toast = Toast(context)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.setGravity(Gravity.TOP, 0, 0) // Set the gravity to TOP
        toast.show()
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return capabilities != null && (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
    }


    private fun showCustomPopupInternet() {
        if (alertDialog == null) {
            val dialogBuilder = AlertDialog.Builder(context)
            val inflater = LayoutInflater.from(context)
            val dialogView = inflater.inflate(R.layout.dialog_network, null)


            dialogBuilder.setView(dialogView)
            alertDialog = dialogBuilder.create()


            alertDialog?.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
            alertDialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)


            // Set the dialog to non-cancelable (back button and outside click won't close it)
            alertDialog?.setCancelable(false)


            retryButton = dialogView.findViewById(R.id.retrybtn)
            retryButton?.setOnClickListener {
                // Dismiss the dialog to simulate a reload
                dismissCustomPopup()
                Handler(Looper.getMainLooper()).postDelayed({
                    // Check the network status again
                    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                    val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)

                    if (capabilities != null && (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))) {
                        // Internet is restored, dismiss the popup
                        dismissCustomPopup()
                    } else {
                        // Internet is still not available, show the popup again
                        showCustomPopupInternet()
                    }
                }, 100) // Delay in milliseconds, change as needed
            }

            alertDialog?.setOnDismissListener {
                alertDialog = null
                retryButton = null
            }
        }


        alertDialog?.show()
    }




    private fun dismissCustomPopup() {
        // Dismiss the custom popup if it is showing
        alertDialog?.dismiss()
    }
}