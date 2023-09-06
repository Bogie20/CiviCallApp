
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.civicall.Dashboard
import com.example.civicall.R

class PopupFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.popup_layout)
        // Optional: Set dialog properties if needed
        // dialog.setTitle("Your Title");
        // dialog.setCancelable(false); // Set to true if you want to allow cancel by tapping outside the popup

        // Handle the button click inside the popup
        val redirectButton = dialog.findViewById<Button>(R.id.redirectButton)
        redirectButton.setOnClickListener { // Redirect to the homepage here
            // Replace "YourHomePageActivity" with the actual name of your homepage activity
            val intent = Intent(requireContext(), Dashboard::class.java)
            startActivity(intent)

            // Close the popup after redirecting
            dismiss()
        }
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}