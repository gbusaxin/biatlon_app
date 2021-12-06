package com.example.trainingsystem.data.database.room_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.trainingsystem.data.database.model.CandidatInfoDbModel
import com.example.trainingsystem.data.database.model.NewsInfoDbModel
import com.example.trainingsystem.data.database.model.TeamsResultInfoDbModel
import com.example.trainingsystem.data.database.model.WorldCupInfoDbModel

@Database(
    entities = [NewsInfoDbModel::class,
        WorldCupInfoDbModel::class,
        CandidatInfoDbModel::class,
        TeamsResultInfoDbModel::class],
    version = 4,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private var db: AppDatabase? = null
        private const val DATABASE_NAME = "database.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).fallbackToDestructiveMigration()
                    .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun getDao(): DaoDb

}