package com.pabsdl.tourista.common.base

import androidx.lifecycle.LifecycleOwner

interface ObservableDataBindingViewMvc<BL : BaseListener, VM> :
    ObservableViewMvc<BL> {

    fun setupViewModel(viewModel: VM, lifecycleOwner: LifecycleOwner)

}