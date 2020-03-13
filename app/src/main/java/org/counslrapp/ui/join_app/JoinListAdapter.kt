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
    private lateinit var  listener: ChooseSchoolListener


    companion object {
        private var rowIndex: Int = -1
    }

    interface ChooseSchoolListener {
        fun onSchoolClicked(viewModel: JoinViewModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: AdapterJoinBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.adapter_join, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postList[position],listener)
    }

    override fun getItemCount(): Int {
        return if(::postList.isInitialized) postList.size else 0
    }

    fun updatePostList(listener: ChooseSchoolListener,postList:List<SchoolModel>){
        this.postList = postList
        this.listener = listener
        notifyDataSetChanged()
    }

    fun refreshUI() {
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: AdapterJoinBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener{
        private val viewModel = JoinViewModel()
        private lateinit var  listener: ChooseSchoolListener

        //private var position: Int = 0

        fun bind(post: SchoolModel, listener: ChooseSchoolListener){
            viewModel.bind(post)
            this.listener = listener
            binding.viewModel = viewModel
            setClickListener(post)
            println("value of position on refresh "+ rowIndex)

            if(rowIndex == position){
                viewModel.setPosition()
            }else{
                viewModel.setBackground()
            }
        }

        private fun setClickListener(postList: SchoolModel) {
            itemView.tag = postList
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            // viewModel.setPosition()
            listener.onSchoolClicked(viewModel)
            rowIndex = position
            println("value of position "+rowIndex)
        }
    }
}