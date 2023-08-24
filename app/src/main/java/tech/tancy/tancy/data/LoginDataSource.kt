package tech.tancy.tancy.data

import android.content.Context
import android.content.SharedPreferences
import tech.tancy.tancy.data.model.LoggedInUser
import java.io.IOException


/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    var sharedPreferences: SharedPreferences =
        getSharedPreferences("nome_do_arquivo", Context.MODE_PRIVATE)

    fun saveData(chave: String, valor: String) {
        val editor = sharedPreferences.edit()
        editor.putString(chave, valor)
        editor.apply()
    }

    fun getData(chave: String): String? {
        return sharedPreferences.getString(chave, "")
    }

    fun removeData(chave: String) {
        val editor = sharedPreferences.edit()
        editor.remove(chave)
        editor.apply()
    }

    fun getSharedPreferences(nomeDoArquivo: String, modoDeAcesso: Int): SharedPreferences {
        return getSharedPreferences(nomeDoArquivo, modoDeAcesso)
    }


    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    private  fun validarCampos(username: String, password: String): Boolean {
        return camposEmBranco(username, password)
    }

    // Salva username e passwoed no shared preferences
    private fun salvarDados(username: String, password: String) {



    }

    // Verifica se os campos estão em branco
    private fun camposEmBranco(username: String, password: String): Boolean {
        return username.isEmpty() || password.isEmpty()
    }

    private fun valoresDiferentes(username: String, password: String): Boolean {
        return username != password
    }

}