package org.counslrapp.ui.session_messages

import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.counslrapp.R
import org.counslrapp.model.MessagesModel
import org.counslrapp.model.SessionModel
import org.counslrapp.model.SliderItems

/**
 * Created by Erald Haka.
 */

class SessionMessagesAdapter: RecyclerView.Adapter<SessionMessagesAdapter.ViewHolder>() {
    private var feedItemList: List<MessagesModel> = ArrayList()

    fun addMessage(messagesModels: ArrayList<MessagesModel>) {
        feedItemList = messagesModels
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.adapter_session_messages, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(@NonNull holder: ViewHolder, position: Int) {
        val feedItem = feedItemList[position]

        holder.txtMsg!!.text = feedItem.messages
        holder.imgProfile!!.setImageResource(feedItem.imageUrl)
        if(feedItem.showPhoto == true){
            holder.imgProfile!!.visibility = View.VISIBLE
        }else{
            holder.imgProfile!!.visibility = View.INVISIBLE
        }

        if (feedItem.isSender == true) {
            holder.parent!!.setPadding(100, 0, 15, 0)
            holder.parent!!.gravity = Gravity.RIGHT
            holder.thread!!.setCardBackgroundColor(Color.parseColor("#F2E9DA"))
        } else {
            holder.parent!!.setPadding(15, 0, 50, 0)
            holder.parent!!.gravity = Gravity.LEFT
            holder.thread!!.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
        }
    }

    override fun getItemCount(): Int {
        return feedItemList.size
    }

    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){

        var imgProfile: ImageView? = null
        var txtMsg: TextView? = null
        var thread: CardView? = null
        var parent: LinearLayout? = null

        init {
            imgProfile = itemView.findViewById(R.id.imageView_profile)
            txtMsg = itemView.findViewById(R.id.textView_messages)
            thread = itemView.findViewById(R.id.lyt_thread)
            parent = itemView.findViewById(R.id.lyt_parent)
            itemView.tag = itemView
        }
    }
}