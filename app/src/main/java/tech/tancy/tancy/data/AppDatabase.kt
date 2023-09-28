package tech.tancy.tancy.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDAO(): UserDAO
    companion object {
        private lateinit var INSTANCE: AppDatabase
        fun getInstance(context: Context): AppDatabase {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "app_db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}