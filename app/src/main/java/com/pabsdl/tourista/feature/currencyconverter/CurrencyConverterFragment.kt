package com.pabsdl.tourista.feature.currencyconverter


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 * Use the [CurrencyConverterFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CurrencyConverterFragment : Fragment(), CurrencyConverterMvc.Listener {

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

    private lateinit var mViewMvc: CurrencyConverterMvcImpl

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mViewMvc = CurrencyConverterMvcImpl(inflater, container)
        mViewMvc.registerListener(this)
        return mViewMvc.rootView
    }

    override fun onDestroyView() {
        mViewMvc.unregisterListener(this)
        super.onDestroyView()
    }

    override fun onConvertClicked() {
        // TODO: Handle convert button click
    }

    override fun onSwapCurrencyClicked() {
        // TODO: Handle swap currency button click
    }
}
