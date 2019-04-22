package com.pabsdl.tourista.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "visa_bookmark")
data class VisaBookmark(@PrimaryKey(autoGenerate = true)
                        val id: Long = 0,
                        val title: String,
                        val url: String)