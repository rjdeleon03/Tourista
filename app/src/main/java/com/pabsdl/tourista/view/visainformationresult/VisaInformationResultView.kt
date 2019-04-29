package com.pabsdl.tourista.view.visainformationresult

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.pabsdl.tourista.R
import com.pabsdl.tourista.common.adapters.setVisaInfoToButton
import com.pabsdl.tourista.model.VisaInfoData
import com.pabsdl.tourista.utils.clickWithGuard
import kotlinx.android.synthetic.main.view_visa_information_result.view.*

class VisaInformationResultView(context: Context, attrs: AttributeSet) :
    LinearLayout(context, attrs) {

    private var mInfoData: VisaInfoData? = null
    private var mReqsSearchClickAction: (() -> Unit)? = null

    init {
        View.inflate(context, R.layout.view_visa_information_result, this)
        visaInfoReqsSearchButton.clickWithGuard {
            mReqsSearchClickAction?.invoke()
        }
    }

    var infoData: VisaInfoData?
        get() = mInfoData
        set(value) {
            mInfoData = value
            visaInfoDataText.text =
                    resources.getString(when (mInfoData) {
                        VisaInfoData.SAME_COUNTRY -> R.string.visa_info_same_country
                        VisaInfoData.ETA -> R.string.visa_info_eta
                        VisaInfoData.VISA_FREE -> R.string.visa_info_free
                        VisaInfoData.VISA_ON_ARRIVAL -> R.string.visa_info_arrival
                        VisaInfoData.VISA_REQUIRED -> R.string.visa_info_required
                        else ->  R.string.visa_info_no_input
                    })
            setVisaInfoToButton(visaInfoReqsSearchButton, mInfoData)
        }

    var reqsSearchClickAction: (() -> Unit)?
        get() = mReqsSearchClickAction
        set(value) {
            mReqsSearchClickAction = value
        }
}