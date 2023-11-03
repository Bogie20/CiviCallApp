package com.example.civicall

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.civicall.databinding.FragmentForumsBinding

class ForumsFragment : Fragment() {
    lateinit var binding: FragmentForumsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForumsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.rbpast.setOnClickListener {
//            val i = Intent(requireContext(), pastappointments::class.java)
//            startActivity(i)
//        }

        binding.backButtonAppoint.setOnClickListener {
            val i = Intent(requireContext(), MainMenu::class.java)
            startActivity(i)
        }

//        binding.call1.setOnClickListener {
//            val intent = Intent(Intent.ACTION_CALL)
//            val number = "7608086659"
//            intent.data = Uri.parse("tel:$number")
//            startActivity(intent)
//        }
//
//        binding.call2.setOnClickListener {
//            val intent = Intent(Intent.ACTION_CALL)
//            val number = "9827117988"
//            intent.data = Uri.parse("tel:$number")
//            startActivity(intent)
//        }
    }
}
