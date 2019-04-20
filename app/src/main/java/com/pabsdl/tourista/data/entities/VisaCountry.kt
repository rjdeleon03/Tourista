package com.pabsdl.tourista.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "visa_country")
data class VisaCountry(@PrimaryKey
                       @ColumnInfo(name = "id")
                       val id: Int,

                       @ColumnInfo(name = "country")
                       val country: String)