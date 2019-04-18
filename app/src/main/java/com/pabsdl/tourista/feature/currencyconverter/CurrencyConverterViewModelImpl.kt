package com.pabsdl.tourista.feature.currencyconverter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pabsdl.tourista.common.CustomMutableLiveData
import com.pabsdl.tourista.model.CurrencyConversionData
import com.pabsdl.tourista.network.CurrencyRetrofitFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CurrencyConverterViewModelImpl(application: Application):
    AndroidViewModel(application), CurrencyConverterViewModel {

    private val mConversionData: CustomMutableLiveData<CurrencyConversionData> = CustomMutableLiveData()

    init {
        mConversionData.setValue(CurrencyConversionData())
    }

    override fun getConversionData() = mConversionData

    override fun getConversionRate() {
        val service = CurrencyRetrofitFactory.getService()
        CoroutineScope(Dispatchers.IO).launch {
            val request = service.getConversionRate()
            withContext(Dispatchers.Main) {
                try {
                    val response = request.await()
                    val rate = response.body()!!.asFloat
                    mConversionData.value?.setRateAndUpdateTargetAmount(rate)
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
        }
    }
}