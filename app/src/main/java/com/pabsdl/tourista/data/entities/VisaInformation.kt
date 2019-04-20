package com.pabsdl.tourista.data.entities

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = "visa_information",
    indices = [Index(name = "src_country_id"),
        Index(name = "dest_country_id")],
    foreignKeys = [
        ForeignKey(
            entity = VisaCountry::class,
            parentColumns = ["id"],
            childColumns = ["src_country_id"],
            onDelete = CASCADE),
        ForeignKey(
            entity = VisaCountry::class,
            parentColumns = ["id"],
            childColumns = ["dest_country_id"],
            onDelete = CASCADE)
    ])
data class VisaInformation(@PrimaryKey(autoGenerate = true)
                           @ColumnInfo(name = "id")
                           val id: Int,

                           @ColumnInfo(name = "info")
                           val info: Int,

                           @ColumnInfo(name = "src_country_id")
                           val srcCountryId: Int,

                           @ColumnInfo(name = "dest_country_id")
                           val destCountryId: Int)