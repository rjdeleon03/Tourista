package com.pabsdl.tourista.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pabsdl.tourista.data.entities.Trip

@Dao
interface TripDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(trip: Trip)

    @Update
    fun update(trip: Trip)

    @Delete
    fun delete(trip: Trip)

    @Query("SELECT * FROM trip WHERE id = :id")
    fun getById(id: String): LiveData<Trip>

    @Query("SELECT * FROM trip")
    fun getAll(): LiveData<List<Trip>>

}