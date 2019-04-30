package com.pabsdl.tourista.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pabsdl.tourista.data.dao.DestinationDao
import com.pabsdl.tourista.data.dao.TripDao
import com.pabsdl.tourista.data.dao.VisaInformationDao
import com.pabsdl.tourista.data.entities.Destination
import com.pabsdl.tourista.data.entities.Trip
import com.pabsdl.tourista.data.entities.VisaInformation

@Database(
    entities = [
        VisaInformation::class,
        Trip::class,
        Destination::class],
    version = 1,
    exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun visaInformationDao(): VisaInformationDao

    abstract fun tripDao(): TripDao

    abstract fun destinationDao(): DestinationDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        private const val DATABASE_NAME = "app_database"

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance

            synchronized(this) {

                /* Create database */
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}