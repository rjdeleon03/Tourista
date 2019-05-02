package com.pabsdl.tourista.feature.finder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pabsdl.tourista.R
import com.pabsdl.tourista.common.base.BaseListener
import com.pabsdl.tourista.common.base.BaseObservableViewMvc
import com.pabsdl.tourista.common.base.ObservableViewMvc

interface FinderViewMvc : ObservableViewMvc<FinderViewMvc.Listener> {

    interface Listener : BaseListener {

    }
}

class FinderViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<FinderViewMvc.Listener>(), FinderViewMvc {

    override val mRootView = inflater.inflate(R.layout.fragment_finder, parent, false)
    override val rootView: View
        get() = mRootView

}