package com.pabsdl.tourista.data.entities

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = "destination",
    indices = [Index("trip_id")],
    foreignKeys = [ForeignKey(entity = Trip::class,
        parentColumns = ["id"],
        childColumns = ["trip_id"],
        onDelete = CASCADE)])
data class Destination(@PrimaryKey(autoGenerate = false)
                       val id: String = "",
                       val name: String,
                       val lat: Double,
                       val lng: Double,

                       @ColumnInfo(name = "trip_id")
                       val tripId: String)