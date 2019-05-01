package com.pabsdl.tourista.feature.currencyconverter


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.pabsdl.tourista.common.base.BaseMvcFragment
import com.pabsdl.tourista.network.CurrencyRetrofitFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass.
 * Use the [CurrencyConverterFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CurrencyConverterFragment :
    BaseMvcFragment<CurrencyConverterMvc, CurrencyConverterMvc.Listener>(), CurrencyConverterMvc.Listener {

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment CurrencyConverterFragment.
         */
        @JvmStatic
        fun newInstance() =
            CurrencyConverterFragment()
    }

    override fun initializeMvc(inflater: LayoutInflater, container: ViewGroup?) {
        mViewMvc = CurrencyConverterMvcImpl(inflater, container)
    }

    private lateinit var mViewModel: CurrencyConverterViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(CurrencyConverterViewModelImpl::class.java)
        mViewMvc.setupViewModel(mViewModel, viewLifecycleOwner)
    }

    override fun onConvertClicked() {
        mViewModel.getConversionRate()
    }

    override fun onSwapCurrencyClicked() {
        // TODO: Handle swap currency button click
    }
}
