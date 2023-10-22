package tech.tancy.tancy.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import tech.tancy.tancy.model.Convidado

@Dao
interface ConvidadoDao {

    @Insert
    fun salvarConvidado(convidado: Convidado) : Long

    @Update
    fun atualizarConvidado(convidado: Convidado) : Int

    @Delete
    fun deletarConvidado(convidado: Convidado) : Int


    @Query("SELECT * FROM convidados")
    fun selecionarTodosConvidados(): List<Convidado>

}