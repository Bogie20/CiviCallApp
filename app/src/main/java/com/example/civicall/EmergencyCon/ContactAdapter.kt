package com.example.civicall.EmergencyCon

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import android.Manifest
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.civicall.R

class ContactAdapter(
    private var mList: List<ContactData>,
    private val phoneOptions: Map<Int, Array<String>>
) : RecyclerView.Adapter<ContactAdapter.LanguageViewHolder>() {

    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logo: ImageView = itemView.findViewById(R.id.logoIv)
        val titleTv: TextView = itemView.findViewById(R.id.titleTv)
        val callButton: ImageButton = itemView.findViewById(R.id.callButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_contact, parent, false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.logo.setImageResource(mList[position].logo)
        holder.titleTv.text = mList[position].title

        holder.callButton.setOnClickListener {
            showPhoneOptionsDialog(holder.itemView.context, position)
        }
    }

    private fun showPhoneOptionsDialog(context: Context, position: Int) {
        val optionsArray = phoneOptions[position] ?: arrayOf("Default Number 1", "Default Number 2")

        val dialogView = LayoutInflater.from(context).inflate(R.layout.custom_phone_options_dialog, null)
        val titleTextView = dialogView.findViewById<TextView>(R.id.dialog_title)
        val optionListView = dialogView.findViewById<ListView>(R.id.option_list)

        titleTextView.text = "Call ${mList[position].title}"

        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, optionsArray)
        optionListView.adapter = adapter

        val builder = AlertDialog.Builder(context)
        builder.setView(dialogView)

        val alertDialog = builder.create()

        // Set window animations
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

        // Set the background to be transparent
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        optionListView.setOnItemClickListener { _, _, which, _ ->
            val selectedPhoneNumber = optionsArray[which]
            makePhoneCall(context, selectedPhoneNumber)
            alertDialog.dismiss()
        }

        alertDialog.show()
    }



    override fun getItemCount(): Int {
        return mList.size
    }

    private fun makePhoneCall(context: Context, phoneNumber: String) {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CALL_PHONE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            context.startActivity(intent)
        } else {
            ActivityCompat.requestPermissions(
                context as AppCompatActivity,
                arrayOf(Manifest.permission.CALL_PHONE), REQUEST_CALL_PERMISSION
            )
        }
    }

    fun setFilteredList(filteredData: List<ContactData>) {
        mList = filteredData
        notifyDataSetChanged()
    }

    companion object {
        private const val REQUEST_CALL_PERMISSION = 1
    }
}
