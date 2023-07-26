package com.example.anew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.example.anew.databinding.ActivityRegisterBinding
import android.util.Log
import android.view.Menu
import android.widget.ImageView
import androidx.annotation.NonNull
import com.example.anew.databinding.ActivityDashboardBinding

class Register : AppCompatActivity() {
    private lateinit var BackClick: ImageView
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private var emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        BackClick = findViewById(R.id.back)

        BackClick.setOnClickListener {
            // Open the "Menu" activity/form
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }


        firebaseAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()


        val fname1: EditText = findViewById(R.id.fname)
        val Lname2: EditText = findViewById(R.id.Lname)
        val Email2: EditText = findViewById(R.id.Emailline)
        val Contact2: EditText = findViewById(R.id.Contactline)

        val cpass1: EditText = findViewById(R.id.cpass)
        val repass1n: EditText = findViewById(R.id.repass)
        val Reg: Button = findViewById(R.id.Reg)
        val registerprogbar1: ProgressBar = findViewById(R.id.Registerprogbar)
        val checkedTextView: CheckBox = findViewById(R.id.checkedTextView)

        Reg.setOnClickListener {
            val fname10 = fname1.text.toString()
            val lname20 = Lname2.text.toString()
            val email10 = Email2.text.toString()
            val contact = Contact2.text.toString()
            val cpass2 = cpass1.text.toString()
            val repass1 = repass1n.text.toString()

            registerprogbar1.visibility = View.VISIBLE


            if (fname10.isEmpty() || lname20.isEmpty() || email10.isEmpty() || cpass2.isEmpty() || repass1.isEmpty() || contact.isEmpty()) {
                if (fname10.isEmpty()) {
                    fname1.error = "Enter Your Firstname"
                }
                if (lname20.isEmpty()) {
                    Lname2.error = "Enter your Lastname"
                }
                if (email10.isEmpty()) {
                    Email2.error = "Enter Your Email"
                }
                if (contact.isEmpty()) {
                    Contact2.error = "Enter your Contact Number"
                }
                if (cpass2.isEmpty()) {
                    cpass1.error = "Enter your Password"
                }
                if (repass1.isEmpty()) {
                    repass1n.error = "Re-type Your Password"
                }
                Toast.makeText(this, "Enter your Valid Details", Toast.LENGTH_SHORT).show()
                registerprogbar1.visibility = View.GONE
            } else if (!email10.matches(emailpattern.toRegex())) {
                registerprogbar1.visibility = View.GONE
                Email2.error = "Enter valid Email Address"
                Toast.makeText(this, "Enter Valid Email Address", Toast.LENGTH_SHORT).show()
            } else if (contact.length != 10) {
                registerprogbar1.visibility = View.GONE
                Contact2.error = "Enter a valid phone number"
                Toast.makeText(this, "Enter valid phone number", Toast.LENGTH_SHORT).show()
            } else if (cpass2.length <= 8) {
                registerprogbar1.visibility = View.GONE
                cpass1.error = "Enter a password more than 8"
                Toast.makeText(this, "Enter a Password at least 8 characters", Toast.LENGTH_SHORT)
                    .show()
            } else if (!checkedTextView.isChecked) {
                registerprogbar1.visibility = View.GONE
                Toast.makeText(this, "Please agree to the terms and conditions", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Log.d("Register", "Creating user with email and password")
                // Proceed with user registration
                firebaseAuth.createUserWithEmailAndPassword(email10, cpass2)
                    .addOnCompleteListener { task ->

                        if (task.isSuccessful) {
                            val databaseReference = database.reference.child("User")
                                .child(firebaseAuth.currentUser!!.uid)
                            val user = Users(
                                firstname = fname10,
                                lastname = lname20,
                                emailadd = email10,
                                contact = contact,
                                password = cpass2,
                                repassword = repass1,
                                Uid = firebaseAuth.currentUser!!.uid
                            )
                            databaseReference.setValue(user).addOnCompleteListener { dbtask ->
                                if(dbtask.isSuccessful){
                                    val intent = Intent(this,Login :: class.java)
                                    startActivity(intent)
                                }else{
                                    Toast.makeText(this,"Something went Wrong Try again", Toast.LENGTH_SHORT).show()
                                }

                            }

                        }else{
                            Toast.makeText(this,"Something Went wrong try again", Toast.LENGTH_SHORT).show()
                        }


                    }



            }






        }
    }

}
