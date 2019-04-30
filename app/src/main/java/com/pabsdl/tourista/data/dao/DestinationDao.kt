package com.pabsdl.tourista.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pabsdl.tourista.data.entities.Destination

@Dao
interface DestinationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(destination: Destination)

    @Update
    fun update(destination: Destination)

    @Delete
    fun delete(destination: Destination)

    @Query("SELECT * FROM destination WHERE id = :id")
    fun getById(id: String): LiveData<Destination>

    @Query("SELECT * FROM destination WHERE trip_id = :tripId")
    fun getByTripId(tripId: String): LiveData<List<Destination>>

}