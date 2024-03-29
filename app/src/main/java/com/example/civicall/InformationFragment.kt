package com.example.civicall

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.cardview.widget.CardView
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import com.example.civicall.CampusGovernanceInfo.CampusGovernanceMenu
import com.example.civicall.CivicEngagementInfo.CivicMenu
import com.example.civicall.CivicRightsAndResponsibility.CivicRightsAndResponsibilityMenu
import com.example.civicall.DisasterResponseInfo.DisasterResponseMenu
import com.example.civicall.EmergencyCon.MainEmergencyContact
import com.google.android.material.floatingactionbutton.FloatingActionButton
import nl.joery.animatedbottombar.AnimatedBottomBar
import com.example.civicall.EnvironmentalandSocialIssueInfo.EnvironmentalAndSocialIssuesMenu
import com.example.civicall.PublicHealtAwarenessInfo.HealthAwarenessMenu
import com.example.civicall.SurvivalTipsInfo.SurvivalMenu

class InformationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_information, container, false)

        val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.animate_fade_enter)
        view.startAnimation(anim)
        val cardview1 = view.findViewById<CardView>(R.id.cardview1)
        val cardview2 = view.findViewById<CardView>(R.id.cardview2)
        val cardview3 = view.findViewById<CardView>(R.id.cardview3)
        val cardview4 = view.findViewById<CardView>(R.id.cardview4)
        val cardview5 = view.findViewById<CardView>(R.id.cardview5)
        val cardview6 = view.findViewById<CardView>(R.id.cardview6)
        val cardview7 = view.findViewById<CardView>(R.id.cardview7)
        val cardview8 = view.findViewById<CardView>(R.id.cardview8)

        cardview1.setOnClickListener {
            val intent = Intent(requireContext(), CivicMenu::class.java)
            startActivity(intent)
        }
        cardview2.setOnClickListener {
            val intent = Intent(requireContext(), DisasterResponseMenu::class.java)
            startActivity(intent)
        }

        cardview3.setOnClickListener {
            val intent = Intent(requireContext(), SurvivalMenu::class.java)
            startActivity(intent)
        }
        cardview4.setOnClickListener {
            val intent = Intent(requireContext(), CivicRightsAndResponsibilityMenu::class.java)
            startActivity(intent)
        }
        cardview5.setOnClickListener {
            val intent = Intent(requireContext(), EnvironmentalAndSocialIssuesMenu::class.java)
            startActivity(intent)
        }
        cardview6.setOnClickListener {
            val intent = Intent(requireContext(), CampusGovernanceMenu::class.java)
            startActivity(intent)
        }
        cardview7.setOnClickListener {
            val intent = Intent(requireContext(), HealthAwarenessMenu::class.java)
            startActivity(intent)
        }
        cardview8.setOnClickListener {
            val intent = Intent(requireContext(), MainEmergencyContact::class.java)
            startActivity(intent)
        }

        val nestedScrollView = view.findViewById<NestedScrollView>(R.id.nested) // Replace with your NestedScrollView ID
        val animatedBottomBar = requireActivity().findViewById<AnimatedBottomBar>(R.id.bottom_bar)
        val fab = requireActivity().findViewById<FloatingActionButton>(R.id.fab)
        val faback = requireActivity().findViewById<FloatingActionButton>(R.id.faback)

        nestedScrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY > oldScrollY) {
                if (animatedBottomBar.isShown) {
                    animatedBottomBar.visibility = View.GONE
                }
                if (fab.isShown) {
                    fab.hide()
                }
                if (faback.isShown) {
                    faback.hide()
                }
            } else if (scrollY < oldScrollY) {
                // Scroll up
                if (!animatedBottomBar.isShown) {
                    animatedBottomBar.visibility = View.VISIBLE
                }
                if (!fab.isShown) {
                    fab.show()
                }
                if (!faback.isShown) {
                    faback.show()
                }
            }
        }

        return view
    }
}


