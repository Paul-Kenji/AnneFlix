package com.gmail.eamosse.imdb.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gmail.eamosse.imdb.R

class NotificationsFragment : Fragment(), View.OnClickListener {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        val imageView: ImageView = root.findViewById(R.id.imageViewP)
        notificationsViewModel.text.observe(
            viewLifecycleOwner,
            Observer {
                textView.text = it
            }
        )
        imageView.setOnClickListener(this)

        return root
    }

    override fun onClick(view: View?) {
        // Toast.makeText(getActivity(), "Text!", Toast.LENGTH_SHORT).show()
        activity!!
            .supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, PkFragment())
            .commitNow()
    }
}
