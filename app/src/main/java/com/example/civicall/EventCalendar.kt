import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.EngagementCalendarClass
import com.example.civicall.databinding.ActivityEventcalendarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class EventCalendar : AppCompatActivity() {
    private lateinit var binding: ActivityEventcalendarBinding
    private val database = FirebaseDatabase.getInstance()
    private val calendarReference = database.getReference("Upload Engagement")
    private val auth = FirebaseAuth.getInstance()
    private val currentUserID = auth.currentUser?.uid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventcalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Reference to the TextViews with IDs dateandtime and title

        // Add a ValueEventListener to fetch data from Firebase
        calendarReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // Reset the TextViews content

                // Check if there is data available
                if (snapshot.exists()) {
                    val engagementList = mutableListOf<EngagementCalendarClass>()

                    for (engagementDataSnapshot in snapshot.children) {
                        // Assuming your dateandTime and title are stored as Strings
                        val dateAndTime = engagementDataSnapshot.child("dateandTime").getValue(String::class.java)
                        val title = engagementDataSnapshot.child("title").getValue(String::class.java)

                        val dateTimeArray = dateAndTime?.split(",") ?: emptyList()
                        if (dateTimeArray.size == 3) {
                            val date = dateTimeArray[0].trim()
                            val time = dateTimeArray[1].trim()

                        }
                    }

                    // Update the RecyclerView with the engagementList

                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle errors if any
                // Display a Toast to indicate unsuccessful connection (error occurred)
                val toastMessage = "Error retrieving data from Firebase: ${error.message}"
                Toast.makeText(applicationContext, toastMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
