package tech.tancy.tancy.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class AppDatabase: RoomDatabase() {

    abstract fun convidadoDao(): ConvidadoDao
    companion object{

        private lateinit var INSTANCE: AppDatabase

        fun getInstance(context: Context) : AppDatabase {

            // Se a INSTANCIA nao foi inicializada
            if (!::INSTANCE.isInitialized) {
                // inicializar a instancia:
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "convidados_db")
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE
        }

    }

}