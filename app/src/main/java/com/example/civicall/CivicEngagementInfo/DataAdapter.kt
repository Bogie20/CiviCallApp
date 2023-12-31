package com.example.civicall.CivicEngagementInfo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ScaleGestureDetector
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import com.squareup.picasso.Picasso

class DataAdapter(private val dataList: List<DataItem>) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    interface OnItemClickListener {
        fun onReferenceClick(position: Int)
        fun onImageClick(position: Int)
    }

    private var itemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    @SuppressLint("ClickableViewAccessibility")
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val paragraphTextView: TextView = itemView.findViewById(R.id.paragraphTextView)
        val imageView: ImageView = itemView.findViewById(R.id.feed_post_image)
        val linearBtn: LinearLayout = itemView.findViewById(R.id.linearBtn)

        var currentItem: DataItem? = null
        private var scaleFactor = 1.0f

        init {
            linearBtn.setOnClickListener {
                itemClickListener?.onReferenceClick(bindingAdapterPosition)
            }

            imageView.setOnClickListener {
                itemClickListener?.onImageClick(bindingAdapterPosition)
            }

            val scaleGestureDetector = ScaleGestureDetector(itemView.context, object :
                ScaleGestureDetector.OnScaleGestureListener {
                override fun onScale(detector: ScaleGestureDetector): Boolean {
                    scaleFactor *= detector.scaleFactor
                    scaleFactor = scaleFactor.coerceIn(0.5f, 3.0f)

                    titleTextView.textSize = 16 * scaleFactor
                    paragraphTextView.textSize = 13 * scaleFactor

                    return true
                }

                override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
                    return true
                }

                override fun onScaleEnd(detector: ScaleGestureDetector) {
                    // You can perform any necessary actions here when scaling ends
                }
            })

            titleTextView.setOnTouchListener { _, event ->
                scaleGestureDetector.onTouchEvent(event)
                true
            }

            paragraphTextView.setOnTouchListener { _, event ->
                scaleGestureDetector.onTouchEvent(event)
                true
            }

            titleTextView.setOnClickListener {
                it.performClick()
            }

            paragraphTextView.setOnClickListener {
                it.performClick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_educ_resource, parent, false)
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.currentItem = currentItem
        holder.titleTextView.text = currentItem.title
        holder.paragraphTextView.text = currentItem.paragraph

        // Use Picasso to load the image from the imageLink
        Picasso.get()
            .load(currentItem.imageLink)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}