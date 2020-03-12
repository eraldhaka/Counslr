package org.counslrapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import org.counslrapp.R

class HomeActivity : AppCompatActivity() {

    private var fragmentManager: FragmentManager? = null
    private var fragmentTransaction: FragmentTransaction? = null

    private lateinit var imgViewHome:ImageView
    private lateinit var imgViewSession:ImageView
    private lateinit var imgViewProfile:ImageView
    private lateinit var txtHome:TextView
    private lateinit var txtSession:TextView
    private lateinit var txtProfile:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        imgViewHome = findViewById(R.id.imageView_home)
        imgViewSession = findViewById(R.id.imageView_sessions)
        imgViewProfile = findViewById(R.id.imageView_profile)
        txtHome = findViewById(R.id.text_view_home)
        txtSession = findViewById(R.id.text_view_sessions)
        txtProfile = findViewById(R.id.text_view_profile)

        initFirstView()
    }

    fun initFirstView() {
        fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager!!.beginTransaction()
        val reportsFragment = HomeFragment()
        fragmentTransaction!!.add(R.id.fragment_container, reportsFragment, "reportsFragment")
        fragmentTransaction!!.commit()

        imgViewHome.setImageResource(R.drawable.toolbar_home)
        imgViewSession.setImageResource(R.drawable.toolbar_messages)
        imgViewProfile.setImageResource(R.drawable.toolbar_profile)
        txtHome.setTextColor(ContextCompat.getColor(this, R.color.colorPurple))
        txtSession.setTextColor(ContextCompat.getColor(this, R.color.colorGray))
        txtProfile.setTextColor(ContextCompat.getColor(this, R.color.colorGray))

    }
}
