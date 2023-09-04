package com.example.anew

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso
import org.checkerframework.checker.nullness.qual.NonNull

class SearchFragment : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()

        checkUser()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null) {
            startActivity(Intent(requireContext(), Login::class.java))
            requireActivity().finish()
        } else {
            val uid = firebaseUser.uid
            readData(uid)
        }
    }

    private fun readData(uid: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uid).get().addOnSuccessListener { snapshot ->
            if (snapshot.exists()) {
                val title = snapshot.child("Title").value // Corrected reference to "snapshot"
                val location = snapshot.child("location").value // Corrected reference to "snapshot"
                val posterUrl = snapshot.child("Poster").value // Corrected reference to "snapshot"

                val binding = requireView()
                binding.findViewById<TextView>(R.id.textView2).text = title.toString()
                binding.findViewById<TextView>(R.id.textView3).text = location.toString()

                val imageView = binding.findViewById<ImageView>(R.id.textView1)
                if (posterUrl != null && posterUrl.toString().isNotEmpty()) {
                    Picasso.get().load(posterUrl.toString()).into(imageView)
                }
            } else {
                Toast.makeText(requireContext(), "User Not existed", Toast.LENGTH_LONG).show()
            }

        }.addOnFailureListener {
            Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        // You can add static methods or constants here if needed
    }
}
