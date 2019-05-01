package com.pabsdl.tourista.feature.finder

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pabsdl.tourista.R

class FinderFragment : Fragment() {

    companion object {
        fun newInstance() = FinderFragment()
    }

    private lateinit var viewModel: FinderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.finder_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FinderViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
