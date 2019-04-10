package com.pabsdl.tourista.feature.currencyconverter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pabsdl.tourista.network.CurrencyRetrofitFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CurrencyConverterViewModelImpl(application: Application):
    AndroidViewModel(application), CurrencyConverterViewModel {

    private val mBaseAmount: MutableLiveData<Float> = MutableLiveData()
    private val mTargetAmount: MutableLiveData<Float> = MutableLiveData()

    init {
        mBaseAmount.value = 0f
        mTargetAmount.value = 0f
    }

    override fun getBaseAmount() : MutableLiveData<Float> = mBaseAmount

    override fun getTargetAmount() : LiveData<Float> = mTargetAmount

    override fun getConversionRate() {
        val service = CurrencyRetrofitFactory.getService()
        CoroutineScope(Dispatchers.IO).launch {
            val request = service.getConversionRate()
            withContext(Dispatchers.Main) {
                try {
                    val response = request.await()
                    val rate = response.body()?.get("rates")?.asJsonObject?.get("USDPHP")?.asJsonObject?.get("rate")?.asFloat!!
                    mTargetAmount.postValue(mBaseAmount.value!! * rate)
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
        }
    }
}