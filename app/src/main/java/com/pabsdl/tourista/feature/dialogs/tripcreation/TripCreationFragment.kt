package com.pabsdl.tourista.feature.dialogs.tripcreation

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup

import com.pabsdl.tourista.common.base.BaseMvcDialogFragment

class TripCreationFragment :
    BaseMvcDialogFragment<TripCreationMvc, TripCreationMvc.Listener>(), TripCreationMvc.Listener {

    companion object {
        fun newInstance() = TripCreationFragment()
    }

    private lateinit var mViewModel: TripCreationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(TripCreationViewModel::class.java)
    }

    // region BaseMvcDialogFragment

    override fun initializeMvc(inflater: LayoutInflater, container: ViewGroup?) {
        mViewMvc = TripCreationMvcImpl(inflater, container)
    }

    // endregion

    // region TripCreationMvc.Listener

    override fun onAddButtonClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // endregion
}
