package org.counslrapp.ui.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import org.counslrapp.R
import org.counslrapp.base.ViewModelFactory
import org.counslrapp.databinding.ActivityMainBinding
import org.counslrapp.model.SliderItems
/**
 * Created by Erald Haka.
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var sliderView: SliderView
    private lateinit var adapter: MainAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sliderView = findViewById(R.id.imageSlider)
        adapter = MainAdapter()
        sliderView.setSliderAdapter(adapter)
        sliderView.setIndicatorAnimation(IndicatorAnimations.THIN_WORM)
        //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        sliderView.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
        sliderView.scrollTimeInSec = 3
        sliderView.isAutoCycle = false

        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(MainViewModel::class.java)
        renewItems()
    }

    fun renewItems() {
        val sliderItemList = ArrayList<SliderItems>()
        val sliderItem = SliderItems()
        sliderItem.description = "Someone to talk to, any time"
        sliderItem.imageUrl = R.drawable.slider_image
        sliderItemList.add(sliderItem)
        val sliderItem1 = SliderItems()
        sliderItem1.description = "Flexible session times"
        sliderItem1.imageUrl = R.drawable.slider_image
        sliderItemList.add(sliderItem1)
        val sliderItem2 = SliderItems()
        sliderItem2.description = "Private & secure"
        sliderItem2.imageUrl = R.drawable.slider_image
        sliderItemList.add(sliderItem2)
        adapter.renewItems(sliderItemList)
    }
}
