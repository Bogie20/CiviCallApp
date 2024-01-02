package com.example.civicall
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.databinding.ActivitySettingsBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.example.civicall.NetworkUtils

class Settings : AppCompatActivity(), ValueEventListener {

    private lateinit var binding: ActivitySettingsBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding.backbtn.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        val changepass = binding.changepass
        changepass.setOnClickListener {
            val intent = Intent(this, ChangePassword::class.java)
            startActivity(intent)
        }
        val otherproblem = binding.otherproblem
        otherproblem.setOnClickListener {
            val intent = Intent(this, ReportProblem::class.java)
            startActivity(intent)
        }
        val termsandsupp = binding.termsandsupp
        termsandsupp.setOnClickListener {
            val intent = Intent(this, PrivacyAndPolicies::class.java)
            startActivity(intent)
        }
        val profilestt = binding.profilesett
        profilestt.setOnClickListener {
            val intent = Intent(this, TermsAndConditions::class.java)
            startActivity(intent)
        }

        val forumsett = binding.forumsett
        forumsett.setOnClickListener {
            val intent = Intent(this, AboutUs::class.java)
            startActivity(intent)
        }
    }
    override fun onDataChange(snapshot: DataSnapshot) {
    }

    override fun onCancelled(error: DatabaseError) {
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainMenu::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
    }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }

}
