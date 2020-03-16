package org.counslrapp.ui.session_messages

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.WindowManager
import android.widget.ScrollView
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

        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.WHITE

        scrollView.fullScroll(ScrollView.FOCUS_UP)

        recyclerView = findViewById(R.id.session_list)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = sessionMessagesAdapter
        addIncomeItems()

        send_message.setOnClickListener {
            if(editText_message.text.toString() != ""){
                sendItems(editText_message.text.toString())
                editText_message.setText("")
            }
        }

        imageViewBack.setOnClickListener { finish() }

        editText_message.setOnClickListener {
            val handler = Handler()

            val r = Runnable { scrollView.smoothScrollTo(0, 500) }
            handler.postDelayed(r, 200)
        }

        editText_message.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if(s.toString().length == 1){
                    send_message.alpha =1F
                }

                if(s.toString().isEmpty()){
                    send_message.alpha =0.1F
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {

            }
        })
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
        //recyclerView!!.scrollToPosition(messagesModels.size - 1)
        scrollView.fullScroll(ScrollView.FOCUS_DOWN)
    }
}
