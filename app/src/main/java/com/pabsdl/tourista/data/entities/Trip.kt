package com.pabsdl.tourista.data.entities

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.pabsdl.tourista.BR
import java.util.*

@Entity(tableName = "trip")
data class Trip(@PrimaryKey(autoGenerate = false)
                var id: String = UUID.randomUUID().toString(),

                var name: String,

                @ColumnInfo(name = "start_date")
                var startDate: Long,

                @ColumnInfo(name = "end_date")
                var endDate: Long) : BaseObservable() {

    var bindableName: String
        @Bindable get() = name
        set(value) {
            name = value
            notifyPropertyChanged(BR.bindableName)
        }

    var bindableStartDate: Long
        @Bindable get() = startDate
        set(value) {
            startDate = value
            notifyPropertyChanged(BR.bindableStartDate)
        }

    var bindableEndDate: Long
        @Bindable get() = endDate
        set(value) {
            endDate = value
            notifyPropertyChanged(BR.bindableEndDate)
        }

    // region Room ignorables

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

    // endregion
}