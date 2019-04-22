package com.pabsdl.tourista.feature.visainformation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.pabsdl.tourista.Constants
import com.pabsdl.tourista.common.base.BaseObservableViewMvc
import com.pabsdl.tourista.data.entities.VisaBookmark
import com.pabsdl.tourista.databinding.FragmentVisaInformationBinding
import com.pabsdl.tourista.utils.clickWithGuard
import java.lang.ref.WeakReference

class VisaInformationMvcImpl(inflater: LayoutInflater, parent: ViewGroup?,
                             viewModel: VisaInformationViewModel, lifecycleOwner: LifecycleOwner) :
    BaseObservableViewMvc<VisaInformationMvc.Listener>(), VisaInformationMvc {

    private val mLifecycleOwner = WeakReference<LifecycleOwner>(lifecycleOwner)
    private val mViewModel = viewModel
    private val mDataBinding = FragmentVisaInformationBinding.inflate(inflater, parent, false)
    private val mAdapter = VisaInformationBookmarksAdapter(inflater)
    override val mRootView = mDataBinding.root

    override val rootView: View
        get() { return mRootView }

    init {
        mDataBinding.viewModel = mViewModel
        mDataBinding.lifecycleOwner = mLifecycleOwner.get()
        mDataBinding.visaBookmarksRecyclerView.adapter = mAdapter

        mDataBinding.visaReqsSearchButton.clickWithGuard {
            for (listener in mListeners) {
                listener.onSearchDetailsClicked()
            }
        }
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

}