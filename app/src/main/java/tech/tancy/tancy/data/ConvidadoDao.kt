package tech.tancy.tancy.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ConvidadoDao {

    @Insert
    fun inserirConvidado(convidado: Convidado)

    @Update
    fun atualizarConvidado(convidado: Convidado)

    @Delete
    fun deletarConvidado(convidado: Convidado)

    @Query("SELECT * FROM convidados WHERE id = :id")
    fun selecionarConvidadoPorId(id: Int): Convidado

    @Query("SELECT * FROM convidados")
    fun selecionarTodosConvidados(): List<Convidado>

}