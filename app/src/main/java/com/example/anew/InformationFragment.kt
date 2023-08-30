package com.example.anew

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.anew.EmergencyCon.MainEmergencyContact

class InformationFragment : Fragment() {

    // ... (other code)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_information, container, false)

        val cardview1 = view.findViewById<CardView>(R.id.cardview1)
        val cardview2 = view.findViewById<CardView>(R.id.cardview2)
        val cardview3 = view.findViewById<CardView>(R.id.cardview3)
        val cardview4 = view.findViewById<CardView>(R.id.cardview4)
        val cardview5 = view.findViewById<CardView>(R.id.cardview5)
        val cardview6 = view.findViewById<CardView>(R.id.cardview6)
        val cardview7 = view.findViewById<CardView>(R.id.cardview7)
        val cardview8 = view.findViewById<CardView>(R.id.cardview8)

        cardview1.setOnClickListener {
            val intent = Intent(requireContext(), MainEmergencyContact::class.java)
            startActivity(intent)
        }

        cardview2.setOnClickListener {
            val intent = Intent(requireContext(), MainEmergencyContact::class.java)
            startActivity(intent)
        }


        cardview3.setOnClickListener {
            val intent = Intent(requireContext(), MainEmergencyContact::class.java)
            startActivity(intent)
        }
        cardview4.setOnClickListener {
            val intent = Intent(requireContext(), MainEmergencyContact::class.java)
            startActivity(intent)
        }
        cardview5.setOnClickListener {
            val intent = Intent(requireContext(), MainEmergencyContact::class.java)
            startActivity(intent)
        }
        cardview6.setOnClickListener {
            val intent = Intent(requireContext(), MainEmergencyContact::class.java)
            startActivity(intent)
        }
        cardview7.setOnClickListener {
            val intent = Intent(requireContext(), MainEmergencyContact::class.java)
            startActivity(intent)
        }
        cardview8.setOnClickListener {
            val intent = Intent(requireContext(), MainEmergencyContact::class.java)
            startActivity(intent)
        }

        return view
    }

}
