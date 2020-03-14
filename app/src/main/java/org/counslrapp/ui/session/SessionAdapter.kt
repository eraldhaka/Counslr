package org.counslrapp.ui.session

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import org.counslrapp.R
import org.counslrapp.model.SessionModel

/**
 * Created by Erald Haka.
 */
class SessionAdapter(private val feedItemList: List<SessionModel>?) :
    RecyclerView.Adapter<SessionAdapter.ViewHolder>() {


    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.adapter_session, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(@NonNull holder: ViewHolder, position: Int) {
        val feedItem = feedItemList!![position]

        holder.txtTitle!!.text = feedItem.title
        holder.txtDescription!!.text = feedItem.description
        holder.txtDate!!.text = feedItem.date
        holder.imgProfile!!.setImageResource(feedItem.imageUrl)

    }

    override fun getItemCount(): Int {
        return feedItemList?.size ?: 0
    }

    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){

        var imgProfile: ImageView? = null
        var txtTitle: TextView? = null
        var txtDescription: TextView? = null
        var txtDate: TextView? = null

        init {
            imgProfile = itemView.findViewById(R.id.imageView_profile)
            txtTitle = itemView.findViewById(R.id.textView_title)
            txtDescription = itemView.findViewById(R.id.textView_description)
            txtDate = itemView.findViewById(R.id.textView_date)
            itemView.tag = itemView
        }
    }
}