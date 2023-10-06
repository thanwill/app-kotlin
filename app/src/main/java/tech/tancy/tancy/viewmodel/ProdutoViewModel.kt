package tech.tancy.tancy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tech.tancy.tancy.data.model.ProdutoModel

class ProdutoViewModel : ViewModel(){

    // cria atributo para conversar com a interface.
    // O valor será exibido dentro de um Toast na activity ProdutoActivity
    private var txtTost = MutableLiveData<String>()
    private var produtoModel = ProdutoModel()

    // cria método para conversar com a interface.
    fun getMessageTost(): LiveData<String> {
        return txtTost
    }

    // ação que tentaremos executar ao clicar no botão de cadastrar
    fun cadastrarProduto(produto: String, descricao: String, preco: String, quantidade: String){

        // chama o método validarProduto da model
        val mensagem = produtoModel.validarProduto(produto, descricao, preco, quantidade)

        // altera o valor do objeto que pode ser observado
        txtTost.value = mensagem
    }

}