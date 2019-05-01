package com.pabsdl.tourista.common

import androidx.databinding.BaseObservable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData

class CustomMutableLiveData<BO : BaseObservable> : MutableLiveData<BO>() {

    override fun setValue(value: BO) {
        super.setValue(value)
        value.addOnPropertyChangedCallback(object: Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                setValue(value)
            }
        })
    }
}