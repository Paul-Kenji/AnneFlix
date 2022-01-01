package com.gmail.eamosse.imdb.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gmail.eamosse.imdb.databinding.FragmentAxelBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AxelFragment : Fragment() {
    private val NotificationsViewModel: NotificationsViewModel by viewModel()
    private lateinit var binding: FragmentAxelBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAxelBinding.inflate(inflater, container, false)
        return binding.root
    }
}
