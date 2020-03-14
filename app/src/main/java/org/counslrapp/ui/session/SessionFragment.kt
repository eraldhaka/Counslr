package org.counslrapp.ui.session

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.counslrapp.R
import org.counslrapp.model.SessionModel
import org.counslrapp.model.SliderItems
import org.counslrapp.ui.main_activity.MainAdapter

/**
 * Created by Erald Haka.
 */
class SessionFragment : Fragment() {
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_session, null)
        recyclerView = view.findViewById(R.id.session_list)
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        recyclerView!!.addItemDecoration(DividerItemDecoration(recyclerView!!.context, DividerItemDecoration.VERTICAL))

        renewItems()

        return view
    }



    private fun renewItems() {
        val sessionModels = ArrayList<SessionModel>()
        val sessionModel = SessionModel()
        sessionModel.description = "Someone to talk to, any time"
        sessionModels.add(sessionModel)
        val sessionModel1 = SessionModel()
        sessionModel1.description = "Someone to talk to, any time"
        sessionModels.add(sessionModel1)

        val sessionAdapter = SessionAdapter(sessionModels)
        recyclerView!!.adapter = sessionAdapter
        sessionAdapter.notifyDataSetChanged()
    }
}