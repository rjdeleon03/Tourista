package com.pabsdl.tourista.model

import com.google.gson.annotations.SerializedName

class VisaInformationData(@SerializedName("Passport")
                          val srcCountry: String,

                          @SerializedName("Destination")
                          val destCountry: String,

                          @SerializedName("Value")
                          val info: Int)