package com.example.civicall.CivicEngagementInfo

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.StyleSpan
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class Strategies : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_strategies)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(DataItem("1.Communication skills:", "Communication is the foundation of community engagement. A community engagement leader needs to have strong verbal and written communication skills, as well as the ability to listen actively and empathetically. Communication skills also involve being able to adapt to different audiences, contexts, and formats, such as online platforms, public events, or media interviews. A community engagement leader should be able to convey clear and compelling messages, ask relevant and respectful questions, and provide constructive and timely feedback.\n\n"))
        dataList.add(DataItem("2.Cultural competence ", "the awareness and appreciation of the diverse cultures, values, beliefs, and perspectives that exist within and across communities. A community engagement leader needs to have cultural competence to understand and respect the differences and similarities among different groups of people, and to avoid stereotypes, biases, and assumptions. Cultural competence also involves being open to learning from others, acknowledging one's own limitations and blind spots, and seeking feedback and guidance from cultural experts or representatives.\n"))
        dataList.add(DataItem("3.Relationship-building skills: ", "are the ability to establish and maintain trust, rapport, and mutual respect with various stakeholders, such as community members, partners, funders, or policymakers. A community engagement leader needs to have relationship-building skills to create and sustain a network of allies and supporters who can collaborate and cooperate on common issues and goals. Relationship-building skills also involve being able to identify and leverage the strengths, resources, and opportunities of each stakeholder, and to address and resolve any conflicts or challenges that may arise.\n"))
        dataList.add(DataItem("4.Facilitation skills: ", " Are the ability to design and deliver engaging and effective processes and activities that enable participation, dialogue, learning, and action among different stakeholders. A community engagement leader needs to have facilitation skills to create a safe and inclusive space where everyone can share their ideas, opinions, and experiences, and where diverse perspectives can be heard and valued. Facilitation skills also involve being able to manage group dynamics, encourage creativity and innovation, and foster consensus and commitment.\n\n"))
        dataList.add(DataItem("5.Conflict Resolution Skills:", "\"A community engagement leader should possess strong conflict resolution skills to address disagreements and disputes that may arise within the community or among stakeholders. This involves the ability to remain calm, impartial, and objective while helping parties find common ground and work toward mutually beneficial solutions.\n\"\n"))

        dataList.add(DataItem("6. Data Analysis and Evaluation:   ", "\" Effective community engagement leaders understand the importance of collecting and analyzing data to assess the impact of their efforts. They should be able to evaluate the outcomes of community initiatives, identify areas for improvement, and use data-driven insights to inform decision-making and future strategies. Data analysis helps leaders demonstrate the value and effectiveness of their engagement efforts to stakeholders and funders.\n\"\n"))
        dataList.add(DataItem("7. Empathy and Active Listening:", "\"Empathy and active listening are essential qualities that enable a leader to genuinely understand the needs, concerns, and emotions of community members and stakeholders. By demonstrating empathy and active listening, a leader can build trust, foster stronger relationships, and make individuals feel heard and valued.\"    \n"))
        dataList.add(DataItem("8. Strategic Thinking:", "\"Successful community engagement leaders have the ability to think strategically. They can assess complex situations, set clear goals, develop effective plans, and adapt their strategies as needed to achieve long-term, sustainable outcomes for the community. Strategic thinking ensures that resources are used efficiently and that efforts are focused on the most impactful initiatives.\"\n"))
        dataList.add(DataItem("9. Adaptability and Flexibility: ", "\" Community dynamics, issues, and priorities can change over time. A community engagement leader should be adaptable and flexible, capable of adjusting their approach and strategies to respond to evolving circumstances while staying true to the core goals of engagement.\"\n"))
        dataList.add(DataItem("10. Conflict Resolution Skills:", "\"A community engagement leader should possess strong conflict resolution skills to address disagreements and disputes that may arise within the community or among stakeholders. This involves the ability to remain calm, impartial, and objective while helping parties find common ground and work toward mutually beneficial solutions.\"\n"))


        val adapter = DataAdapter(dataList)
        recyclerView.adapter = adapter

    }
}