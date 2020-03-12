package org.counslrapp.ui.main_activity

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.smarteist.autoimageslider.SliderViewAdapter
import org.counslrapp.R
import org.counslrapp.model.SliderItems

/**
 * Created by Erald Haka.
 */

class MainAdapter : SliderViewAdapter<MainAdapter.SliderAdapterVH>() {
    private var mSliderItems: List<SliderItems> = ArrayList()

    fun renewItems(sliderItems: List<SliderItems>) {
        this.mSliderItems = sliderItems
        notifyDataSetChanged()
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.image_slider_layout_item, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {

        val sliderItem = mSliderItems[position]

        viewHolder.textViewDescription.text = sliderItem.description
        viewHolder.imageViewBackground.setImageResource(R.drawable.slider_image)

    }

    override fun getCount(): Int {
        return mSliderItems.size
    }

    inner class SliderAdapterVH(itemView: View) : SliderViewAdapter.ViewHolder(itemView) {
        var imageViewBackground: ImageView = itemView.findViewById(R.id.imageView)
        var textViewDescription: TextView = itemView.findViewById(R.id.textView)

    }

}