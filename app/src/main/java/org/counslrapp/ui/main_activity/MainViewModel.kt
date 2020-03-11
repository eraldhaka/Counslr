package org.counslrapp.ui.main_activity

import org.counslrapp.R
import org.counslrapp.base.BaseViewModel
import org.counslrapp.model.SliderItems
import java.util.ArrayList

/**
 * Created by Erald Haka.
 */
class MainViewModel: BaseViewModel(){
    private val adapter: MainAdapter = MainAdapter()

    init{
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

       // adapter.renewItems(sliderItemList)
    }
}