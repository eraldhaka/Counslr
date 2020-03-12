package org.counslrapp.ui.join_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.counslrapp.R
import org.counslrapp.databinding.AdapterJoinBinding
import org.counslrapp.model.SchoolModel

/**
 * Created by Erald Haka.
 */

class JoinListAdapter: RecyclerView.Adapter<JoinListAdapter.ViewHolder>() {
    private lateinit var postList:List<SchoolModel>

    interface ChooseSchoolListener {
        fun onSchoolClicked(postList: SchoolModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: AdapterJoinBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.adapter_join, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int {
        return if(::postList.isInitialized) postList.size else 0
    }

    fun updatePostList(postList:List<SchoolModel>){
        this.postList = postList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: AdapterJoinBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener{
        private val viewModel = JoinViewModel()
        private lateinit var  listener: ChooseSchoolListener

        fun bind(post:SchoolModel){
            viewModel.bind(post)
            binding.viewModel = viewModel
        }

        private fun setClickListener(postList: SchoolModel) {
            itemView.tag = postList
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            listener.onSchoolClicked(view.tag as SchoolModel)
        }

    }
}