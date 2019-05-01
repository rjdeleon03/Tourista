package com.pabsdl.tourista.feature.tools

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

import com.pabsdl.tourista.R
import com.pabsdl.tourista.common.base.BaseMvcFragment

class ToolsFragment :
    BaseMvcFragment<ToolsMvc, ToolsMvc.Listener>(), ToolsMvc.Listener {

    private lateinit var mViewModel: ToolsViewModel
    private lateinit var mNavController: NavController

    override fun initializeMvc(inflater: LayoutInflater, container: ViewGroup?) {
        mViewMvc = ToolsMvcImpl(inflater, container)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(ToolsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mNavController = findNavController()
    }

    // region ToolsMvc.Listener

    override fun onCurrencyConversionButtonClicked() {
        mNavController.navigate(R.id.action_toolsFragment_to_currencyConverterFragment)
    }

    override fun onVisaInformationButtonClicked() {
        mNavController.navigate(R.id.action_toolsFragment_to_visaInformationFragment)
    }

    // endregion
}
