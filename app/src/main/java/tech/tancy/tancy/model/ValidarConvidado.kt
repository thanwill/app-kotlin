package tech.tancy.tancy.model

class ValidarConvidado {

    fun validarNome(nome: String): Boolean {
        return nome.length >= 3
    }

    fun validarEmail(email: String): Boolean {
        return email.contains("@")
    }

    fun validarTelefone(telefone: String): Boolean {
        return telefone.length >= 8
    }

    fun verificaTamanho( string: String, minimo : Int, maximo : Int): Boolean{
        return string.length in minimo..maximo
    }
}