package com.example.civicall.NotificationsToken
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging

class TokenRegistration {

    fun registerToken() {
        val auth = FirebaseAuth.getInstance()
        val userId = auth.currentUser?.uid

        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val token = task.result
                    userId?.let {
                        saveTokenToFirestore(it, token)
                    }
                } else {
                    Log.w("TokenRegistration", "getToken failed", task.exception)
                }
            }
    }

    private fun saveTokenToFirestore(userId: String, token: String?) {
        val db = FirebaseFirestore.getInstance()
        val userRef = db.collection("users").document(userId)

        token?.let {
            userRef.update("fcmToken", it)
                .addOnSuccessListener {
                    Log.d("TokenRegistration", "Token registered successfully")
                }
                .addOnFailureListener { e ->
                    Log.w("TokenRegistration", "Error registering token", e)
                }
        }
    }
}
