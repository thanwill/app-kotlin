package tech.tancy.tancy.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tech.tancy.tancy.model.Convidado

@Database(entities = [Convidado::class], version = 1)
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