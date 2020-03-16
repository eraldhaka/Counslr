package org.counslrapp.ui.session_messages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_session_messages.*
import org.counslrapp.R
import org.counslrapp.model.MessagesModel

class SessionMessagesActivity : AppCompatActivity() {

    private var sessionMessagesAdapter: SessionMessagesAdapter = SessionMessagesAdapter()
    private var recyclerView: RecyclerView? = null
    private val messagesModels = ArrayList<MessagesModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session_messages)

        recyclerView = findViewById(R.id.session_list)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = sessionMessagesAdapter
        addIncomeItems()

        send_message.setOnClickListener {
            sendItems(editText_message.text.toString())
            editText_message.setText("")
        }

    }

    private fun addIncomeItems() {

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


        sessionMessagesAdapter.addMessage(messagesModels)


    }

    private fun sendItems(msg: String) {
        val messagesModel = MessagesModel()

        messagesModel.messages = msg
        messagesModel.isSender = true
        messagesModel.showPhoto = false
        messagesModel.imageUrl = R.drawable.profile_doctor
        messagesModels.add(messagesModel)

        sessionMessagesAdapter!!.addMessage(messagesModels)
        recyclerView!!.scrollToPosition(messagesModels.size - 1)
    }
}
