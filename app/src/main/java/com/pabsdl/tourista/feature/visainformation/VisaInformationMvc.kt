package com.pabsdl.tourista.feature.visainformation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.pabsdl.tourista.Constants
import com.pabsdl.tourista.common.base.BaseListener
import com.pabsdl.tourista.common.base.BaseObservableViewMvc
import com.pabsdl.tourista.common.base.ObservableViewMvc
import com.pabsdl.tourista.databinding.FragmentVisaInformationBinding
import java.lang.ref.WeakReference

interface VisaInformationMvc : ObservableViewMvc<VisaInformationMvc.Listener>{

    interface Listener: BaseListener {

        fun onCountryFieldClicked(text: String, reqCode: Int)

        fun onSearchDetailsClicked()
    }
}

class VisaInformationMvcImpl(inflater: LayoutInflater, parent: ViewGroup?,
                             viewModel: VisaInformationViewModel, lifecycleOwner: LifecycleOwner
) :
    BaseObservableViewMvc<VisaInformationMvc.Listener>(), VisaInformationMvc {

    private val mLifecycleOwner = WeakReference<LifecycleOwner>(lifecycleOwner)
    private val mViewModel = viewModel
    private val mDataBinding = FragmentVisaInformationBinding.inflate(inflater, parent, false)
    override val mRootView = mDataBinding.root

    override val rootView: View
        get() { return mRootView }

    init {
        mDataBinding.viewModel = mViewModel
        mDataBinding.lifecycleOwner = mLifecycleOwner.get()
        mDataBinding.visaPassportText.keyListener = null
        mDataBinding.visaDestinationText.keyListener = null
        mDataBinding.visaInfoResultView.reqsSearchClickAction = ::createReqsSearchClickAction
        mDataBinding.visaPassportText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus)
                for (listener in mListeners) {
                    listener.onCountryFieldClicked(mDataBinding.visaPassportText.text.toString(),
                        Constants.VISA_COUNTRY_REQ_PASSPORT_CODE)
                }
        }
        mDataBinding.visaDestinationText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus)
                for (listener in mListeners) {
                    listener.onCountryFieldClicked(mDataBinding.visaDestinationText.text.toString(),
                        Constants.VISA_COUNTRY_REQ_DESTINATION_CODE)
                }
        }
    }

    private fun createReqsSearchClickAction() {
        for (listener in mListeners) {
            listener.onSearchDetailsClicked()
        }
    }
}