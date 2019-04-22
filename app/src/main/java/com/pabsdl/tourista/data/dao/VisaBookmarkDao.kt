package com.pabsdl.tourista.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pabsdl.tourista.data.entities.VisaBookmark

@Dao
interface VisaBookmarkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bookmark: VisaBookmark)

    @Delete
    fun delete(bookmark: VisaBookmark)

    @Update
    fun update(bookmark: VisaBookmark)

    @Query("SELECT * FROM visa_bookmark")
    fun getAll(): LiveData<List<VisaBookmark>>
}