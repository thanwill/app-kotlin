package tech.tancy.tancy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tech.tancy.tancy.model.Convidado
import tech.tancy.tancy.model.ValidarConvidado
import tech.tancy.tancy.repository.ConvidadoRepository

class CadastroViewModel(application: Application) : AndroidViewModel(application) {

    private val message = MutableLiveData<String>()
    private val validacao = ValidarConvidado()
    private val repository = ConvidadoRepository( application.applicationContext)


    fun getMessage() : LiveData<String> {
        return message
    }

    fun salvarConvidado(nome: String, email: String, telefone: String) : Boolean {
        if (!validacao.verificaTamanho(nome, 3, 50)) {
            message.value = "Nome deve ter entre 3 e 50 caracteres!"
            return false
        }

        if (!validacao.verificaTamanho(email, 12, 30)) {
            message.value = "Email deve ter entre 12 e 30 caracteres!"
            return false
        }

        if (!validacao.verificaTamanho(telefone, 8, 15)) {
            message.value = "Telefone deve ter entre 8 e 15 caracteres!"
            return false
        }

        // Passo 3: tentar salvar no banco de dados este objeto tarefa
        if (repository.salvarConvidado(Convidado(0, nome, email, telefone))) {
            message.value = "Convidado salvo com sucesso!"
            return true
        } else {
            message.value = "Erro ao salvar convidado!"
            return false
        }
    }



}
