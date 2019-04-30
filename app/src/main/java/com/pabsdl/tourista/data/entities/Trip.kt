package com.pabsdl.tourista.data.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "trip")
data class Trip(@PrimaryKey(autoGenerate = false)
                val id: String,
                val name: String,
                val startDate: Long,
                val endDate: Long,

                @Ignore
                val destinations: List<Destination>)