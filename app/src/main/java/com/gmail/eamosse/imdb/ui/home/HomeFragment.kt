package com.gmail.eamosse.imdb.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.gmail.eamosse.imdb.NavigationListener
import com.gmail.eamosse.imdb.R
import com.gmail.eamosse.imdb.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.category_list_item.*
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.fragment_movies.movies_list
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(), View.OnClickListener {
    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var binding: FragmentHomeBinding
    // private lateinit var button: AppCompatImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
//        val view = inflater.inflate(R.layout.category_list_item, container, false)
//        button = view.findViewById(R.id.category_list.adapter)
//        button.setOnClickListener {
//            (activity as? NavigationListener)?.showFragment(HomeSecondFragment())
//        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(homeViewModel) {
            token.observe(
                viewLifecycleOwner,
                Observer {
                    // récupérer les catégories
                    getCategories()
                }
            )

            categories.observe(
                viewLifecycleOwner,
                Observer {
                    binding.categoryList.adapter = CategoryAdapter(it)
                }
            )

            error.observe(
                viewLifecycleOwner,
                Observer {
                    // afficher l'erreur
                }
            )
        }
    }
    override fun onClick(v: View?) {}
}
