package tech.tancy.tancy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "convidados")
class Convidado (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        val id: Int = 0,
        @ColumnInfo(name = "nome")
        val nome: String,
        @ColumnInfo(name = "email")
        val email: String,
        @ColumnInfo(name = "telefone")
        val telefone: String,
)