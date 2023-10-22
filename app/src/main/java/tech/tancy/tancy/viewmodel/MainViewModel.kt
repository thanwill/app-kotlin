package tech.tancy.tancy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tech.tancy.tancy.model.Convidado
import tech.tancy.tancy.repository.ConvidadoRepository

class MainViewModel (application: Application): AndroidViewModel(application) {

    private var listaconvidados = MutableLiveData<List<Convidado>>()
    private var repository = ConvidadoRepository(application)

    fun getConvidados() : LiveData<List<Convidado>>{
        return listaconvidados
    }

    fun getConvidadosAll(){
        listaconvidados.value = repository.getConvidados()
    }


}