package org.counslrapp.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.TintableImageSourceView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import org.counslrapp.R
import org.counslrapp.utils.extension.getParentActivity
/**
 * Created by Erald Haka.
 */
@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View,  visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer {
                value -> view.visibility = value ?: View.VISIBLE
        })
    }
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView,  text: MutableLiveData<String>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value ?: "" })
    }
}

@BindingAdapter("mutableText")
fun setMutableImage(view: ImageView,  imageSourceView: MutableLiveData<Int>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && imageSourceView != null) {
        imageSourceView.observe(parentActivity, Observer {
                //value -> view.setImageResource(R.drawable.profile_school)})
                value ->  if (value != null) view.setImageResource(value) else view.setImageResource(R.drawable.back_arrow)
        })
    }
}

@BindingAdapter("mutableText:color")
fun setMutableFont(view: ConstraintLayout, backgroundResource: MutableLiveData<Int>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && backgroundResource != null) {
        backgroundResource.observe(parentActivity, Observer {
            //value -> view.setImageResource(R.drawable.profile_school)})
                value ->  if (value != null) view.setBackgroundResource(value) else view.setBackgroundResource(R.drawable.custom_border)
        })
    }
}