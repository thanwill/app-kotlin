package tech.tancy.tancy.repository

import android.content.Context
import tech.tancy.tancy.model.Convidado

class ConvidadoRepository( context: Context) {

    private val db = AppDatabase.getInstance(context)
    private val convidadoDao = db.convidadoDao()

    fun salvarConvidado(convidado: Convidado): Boolean {
        return convidadoDao.salvarConvidado(convidado) > 0
    }

    fun getConvidados(): List<Convidado> {
        return convidadoDao.selecionarTodosConvidados()
    }
}