package com.example.anew.EmergencyCon

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.Manifest
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
import com.example.anew.R

class ContactAdapter(var mList: List<ContactData>) :
    RecyclerView.Adapter<ContactAdapter.LanguageViewHolder>() {

    companion object {
        private const val REQUEST_PHONE_PERMISSION = 1
    }

    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logo : ImageView = itemView.findViewById(R.id.logoIv)
        val titleTv : TextView = itemView.findViewById(R.id.titleTv)
        val callButton: ImageButton = itemView.findViewById(R.id.callButton)
    }

    fun setFilteredList(mList: List<ContactData>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_contact , parent , false)
        return LanguageViewHolder(view)

    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.logo.setImageResource(mList[position].logo)
        holder.titleTv.text = mList[position].title

        holder.callButton.setOnClickListener {
            showPhoneOptionsDialog(holder.itemView.context, mList[position].title)
        }
    }

    private fun showPhoneOptionsDialog(context: Context, title: String) {
        val phoneOptions: Array<String> = when (title) {
            "\nNATIONAL EMERGENCY\n"+"HOTLINE" -> arrayOf("911")
            "\nBATANGAS PDRRMO" -> arrayOf("111111111", "222222222")
            // Add similar cases for other titles
            else -> arrayOf("Default Number 1", "Default Number 2")
        }

        val builder = AlertDialog.Builder(context)
        builder.setTitle("Call $title\n")
            .setItems(phoneOptions) { _, which ->
                val selectedPhoneNumber = phoneOptions[which]
                if (context is AppCompatActivity) {
                    if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        makePhoneCall(context, selectedPhoneNumber)
                    } else {
                        ActivityCompat.requestPermissions(context, arrayOf(Manifest.permission.CALL_PHONE), REQUEST_PHONE_PERMISSION)
                    }
                }
            }
        val dialog = builder.create()
        dialog.show()
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    private fun makePhoneCall(context: Context, phoneNumber: String) {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
        context.startActivity(intent)

    }
}