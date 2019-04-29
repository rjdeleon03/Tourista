package com.pabsdl.tourista.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pabsdl.tourista.data.entities.VisaInformation

@Dao
interface VisaInformationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(visaInformation: List<VisaInformation>)

    @Query("SELECT COUNT(*) FROM visa_information")
    fun count(): Int

    @Query("SELECT * FROM visa_information WHERE " +
            "src_country LIKE :srcCountry AND dest_country LIKE :destCountry")
    fun get(srcCountry: String, destCountry: String): LiveData<VisaInformation>

    @Query("SELECT DISTINCT src_country FROM visa_information " +
            "WHERE src_country LIKE :srcCountry")
    fun getCountries(srcCountry: String): LiveData<List<String>>

    @Query("DELETE FROM visa_information")
    fun clear()
}