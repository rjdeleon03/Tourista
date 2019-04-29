package com.pabsdl.tourista.data.entities

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "visa_information")
data class VisaInformation(@PrimaryKey(autoGenerate = true)
                           @ColumnInfo(name = "id")
                           val id: Int = 0,

                           @SerializedName("Value")
                           @ColumnInfo(name = "info")
                           val info: Int,

                           @SerializedName("Passport")
                           @ColumnInfo(name = "src_country")
                           val srcCountry: String,

                           @SerializedName("Destination")
                           @ColumnInfo(name = "dest_country")
                           val destCountry: String)