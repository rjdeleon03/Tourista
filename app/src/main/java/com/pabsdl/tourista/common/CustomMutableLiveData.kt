package com.pabsdl.tourista.common

import androidx.databinding.BaseObservable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData

class CustomMutableLiveData<BO : BaseObservable> : MutableLiveData<BO>() {

    val callback = object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            setValue(value!!)
        }
    }

    override fun setValue(value: BO) {
        super.setValue(value)
        value.addOnPropertyChangedCallback(callback)
    }
}