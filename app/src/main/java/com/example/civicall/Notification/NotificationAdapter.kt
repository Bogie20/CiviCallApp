import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.Notification.NotificationModel
import com.example.civicall.R
class NotificationAdapter(private val notificationList: List<NotificationModel>) :

    RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {
    class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.recImage)
        val uidTextView: TextView = itemView.findViewById(R.id.dateandTime)
        val emailTextView: TextView = itemView.findViewById(R.id.recTitle)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.notification_recycler_item, parent, false)
        return NotificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val currentItem = notificationList[position]

        // Load profile image using Glide
        // Load profile image using Glide
        Glide.with(holder.profileImage.context)


            .load(currentItem.profileImageUrl)
            .into(holder.profileImage)

        holder.uidTextView.text = currentItem.uid
        holder.emailTextView.text = currentItem.email

    }

    override fun getItemCount() = notificationList.size
}