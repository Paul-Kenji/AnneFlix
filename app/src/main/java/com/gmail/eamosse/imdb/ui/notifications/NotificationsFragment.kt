package com.gmail.eamosse.imdb.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.gmail.eamosse.imdb.R
import kotlinx.android.synthetic.main.fragment_axel.*

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
        val imageViewA: ImageView = root.findViewById(R.id.imageViewA)
        notificationsViewModel.text.observe(
            viewLifecycleOwner,
            {
                textView.text = it
            }
        )
        imageView.setOnClickListener(this)
        imageViewA.setOnClickListener(this)
        return root
    }

    override fun onClick(v: View?) {
        // Toast.makeText(getActivity(), "Text!", Toast.LENGTH_SHORT).show()
        if (v != null) {
            when (v.getId()) {
                R.id.imageViewP -> {
                    requireActivity()
                        .supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, PkFragment())
                        .commitNow()
                }
                R.id.imageViewA -> {
                    requireActivity()
                        .supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, AxelFragment())
                        .commitNow()
                }
                else -> {}
            }
        }
    }
}
