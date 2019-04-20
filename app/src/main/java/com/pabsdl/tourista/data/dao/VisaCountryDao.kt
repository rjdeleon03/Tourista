package com.pabsdl.tourista.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pabsdl.tourista.data.entities.VisaInformation

@Dao
interface VisaCountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(visaCountryDao: VisaCountryDao)

    @Query("SELECT * FROM visa_country WHERE " +
            "src_country LIKE :srcCountry AND " +
            "dest_country LIKE :destCountry")
    fun get(srcCountry: String, destCountry: String) :
            LiveData<VisaInformation>
}