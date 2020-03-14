package org.counslrapp.ui.session_messages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.counslrapp.R
import org.counslrapp.model.MessagesModel
import org.counslrapp.model.SessionModel
import org.counslrapp.ui.session.SessionAdapter

class SessionMessagesActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session_messages)

        recyclerView = findViewById(R.id.session_list)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.addItemDecoration(DividerItemDecoration(recyclerView!!.context, DividerItemDecoration.VERTICAL))

        addItems()
    }

    private fun addItems() {
        val messagesModels = ArrayList<MessagesModel>()
        val messagesModel = MessagesModel()

        messagesModel.messages = "This is an example of a chat."
        messagesModel.isSender = false
        messagesModel.showPhoto = true
        messagesModel.imageUrl = R.drawable.profile_doctor
        messagesModels.add(messagesModel)

        val messagesModel1 = MessagesModel()
        messagesModel1.messages = "This is an example of a chat that \nhas gone to two lines"
        messagesModel1.isSender = false
        messagesModel1.showPhoto = false
        messagesModel1.imageUrl = R.drawable.profile_doctor
        messagesModels.add(messagesModel1)

        val sessionMessagesAdapter = SessionMessagesAdapter(messagesModels)
        recyclerView!!.adapter = sessionMessagesAdapter
        sessionMessagesAdapter.notifyDataSetChanged()
    }
}
