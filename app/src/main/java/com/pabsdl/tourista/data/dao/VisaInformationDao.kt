package com.pabsdl.tourista.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pabsdl.tourista.data.entities.VisaCountry
import com.pabsdl.tourista.data.entities.VisaInformation

@Dao
interface VisaInformationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(visaInformation: VisaInformation)

    @Query("SELECT * FROM visa_country WHERE country LIKE :country")
    fun get(country: String) : LiveData<VisaCountry>
}