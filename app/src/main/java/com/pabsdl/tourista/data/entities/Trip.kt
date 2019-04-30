package com.pabsdl.tourista.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "trip")
data class Trip(@PrimaryKey(autoGenerate = false)
                var id: String = UUID.randomUUID().toString(),

                var name: String,

                @ColumnInfo(name = "start_date")
                var startDate: Long,

                @ColumnInfo(name = "end_date")
                var endDate: Long) {

    @Ignore
    private var mDestinations: List<Destination>? = null

    @Ignore
    private var mBaseDestination: Destination? = null

    var destination: List<Destination>?
        get() = mDestinations
        set(value) {
            mDestinations = value
        }
    
    var baseDestination: Destination?
        get() = mBaseDestination
        set(value) {
            mBaseDestination = value
        }
}