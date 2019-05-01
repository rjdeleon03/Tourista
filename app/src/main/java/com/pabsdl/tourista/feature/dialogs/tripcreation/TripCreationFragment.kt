package com.pabsdl.tourista.feature.dialogs.tripcreation

import android.app.DatePickerDialog
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.pabsdl.tourista.common.base.BaseMvcDialogFragment
import com.pabsdl.tourista.utils.UIUtils
import kotlinx.android.synthetic.main.fragment_trip_creation.*
import org.joda.time.LocalDate

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.getTrip().observe(viewLifecycleOwner, Observer {
            val startDate = LocalDate(it.bindableStartDate)
            tripCreationStartDateText.text = "${startDate.year}/${startDate.monthOfYear}/${startDate.dayOfMonth}"

            val endDate = LocalDate(it.bindableEndDate)
            tripCreationEndDateText.text = "${endDate.year}/${endDate.monthOfYear}/${endDate.dayOfMonth}"
        })
    }

    // region BaseMvcDialogFragment

    override fun initializeMvc(inflater: LayoutInflater, container: ViewGroup?) {
        mViewMvc = TripCreationMvcImpl(inflater, container)
    }

    // endregion

    // region TripCreationMvc.Listener

    override fun onOkButtonClicked() {
        dismiss()
    }

    override fun onCancelButtonClicked() {
        dismiss()
    }

    override fun onStartDateClicked() {
        val date = LocalDate()
        val dateDialog = DatePickerDialog(context!!,
            DatePickerDialog.OnDateSetListener {_, y, m, d ->
                mViewModel.setStartDate(y, m + 1, d)
            },
            date.year,
            date.monthOfYear - 1,
            date.dayOfMonth)
        dateDialog.show()
    }

    override fun onEndDateClicked() {
        val date = LocalDate()
        val dateDialog = DatePickerDialog(context!!,
            DatePickerDialog.OnDateSetListener {_, y, m, d ->
                mViewModel.setEndDate(y, m + 1, d)
            },
            date.year,
            date.monthOfYear - 1,
            date.dayOfMonth + 1)
        dateDialog.show()
    }

    // endregion
}
