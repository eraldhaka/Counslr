package org.counslrapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_home.*
import org.counslrapp.R
import org.counslrapp.ui.profile.ProfleFragment
import org.counslrapp.ui.session.SessionFragment

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

        linearLayoutHome.setOnClickListener {replaceWithHomeView()}
        linearLayoutSessions.setOnClickListener {replaceWithSessionView()}
        linearLayoutProfile.setOnClickListener {replaceWithProfileView()}
    }

    private fun initFirstView() {
        fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager!!.beginTransaction()
        val homeActivity = HomeFragment()
        fragmentTransaction!!.add(R.id.fragment_container, homeActivity, "homeActivity")
        fragmentTransaction!!.commit()

        imgViewHome.setImageResource(R.drawable.toolbar_home)
        imgViewSession.setImageResource(R.drawable.toolbar_messages_inactive)
        imgViewProfile.setImageResource(R.drawable.toolbar_profile)
        txtHome.setTextColor(ContextCompat.getColor(this, R.color.colorPurple))
        txtSession.setTextColor(ContextCompat.getColor(this, R.color.colorGray))
        txtProfile.setTextColor(ContextCompat.getColor(this, R.color.colorGray))

    }

    private fun replaceWithHomeView() {
        fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager!!.beginTransaction()
        val homeActivity = HomeFragment()
        fragmentTransaction!!.replace(R.id.fragment_container, homeActivity, "homeActivity")
        fragmentTransaction!!.commit()

        imgViewHome.setImageResource(R.drawable.toolbar_home)
        imgViewSession.setImageResource(R.drawable.toolbar_messages_inactive)
        imgViewProfile.setImageResource(R.drawable.toolbar_profile)
        txtHome.setTextColor(ContextCompat.getColor(this, R.color.colorPurple))
        txtSession.setTextColor(ContextCompat.getColor(this, R.color.colorGray))
        txtProfile.setTextColor(ContextCompat.getColor(this, R.color.colorGray))

    }

    private fun replaceWithSessionView() {
        fragmentTransaction = fragmentManager!!.beginTransaction()
        val sessionFragment = SessionFragment()
        fragmentTransaction!!.replace(R.id.fragment_container, sessionFragment, "sessionFragment")
        fragmentTransaction!!.commit()

        imgViewHome.setImageResource(R.drawable.toolbar_home_inactive)
        imgViewSession.setImageResource(R.drawable.toolbar_message)
        imgViewProfile.setImageResource(R.drawable.toolbar_profile)
        txtHome.setTextColor(ContextCompat.getColor(this, R.color.colorGray))
        txtSession.setTextColor(ContextCompat.getColor(this, R.color.colorPurple))
        txtProfile.setTextColor(ContextCompat.getColor(this, R.color.colorGray))
    }

    private fun replaceWithProfileView() {
        fragmentTransaction = fragmentManager!!.beginTransaction()
        val profleFragment = ProfleFragment()
        fragmentTransaction!!.replace(R.id.fragment_container, profleFragment, "profleFragment")
        fragmentTransaction!!.commit()

        imgViewHome.setImageResource(R.drawable.toolbar_home_inactive)
        imgViewSession.setImageResource(R.drawable.toolbar_messages_inactive)
        imgViewProfile.setImageResource(R.drawable.toolbar_profile_active)
        txtHome.setTextColor(ContextCompat.getColor(this, R.color.colorGray))
        txtSession.setTextColor(ContextCompat.getColor(this, R.color.colorGray))
        txtProfile.setTextColor(ContextCompat.getColor(this, R.color.colorPurple))
    }
}
