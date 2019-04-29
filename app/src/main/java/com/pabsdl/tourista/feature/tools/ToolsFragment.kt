package com.pabsdl.tourista.feature.tools

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pabsdl.tourista.R

class ToolsFragment : Fragment(), ToolsMvc.Listener {

    companion object {
        fun newInstance() = ToolsFragment()
    }

    private lateinit var mViewModel: ToolsViewModel
    private lateinit var mViewMvc: ToolsMvc

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(ToolsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewMvc = ToolsMvcImpl(inflater, container)
        mViewMvc.registerListener(this)
        return mViewMvc.rootView
    }

    override fun onDestroyView() {
        mViewMvc.unregisterListener(this)
        super.onDestroyView()
    }

    // region ToolsMvc.Listener

    override fun onCurrencyConversionButtonClicked() {
    }

    override fun onVisaInformationButtonClicked() {
    }

    // endregion
}
