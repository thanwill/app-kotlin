package tech.tancy.tancy.data

import com.google.firebase.auth.FirebaseAuth

class Login {

    val auth = FirebaseAuth.getInstance() // instancia o firebase
    var email: String? = null
    var senha: String? = null

    // usa a autenticacao do firebase para verificar se o usuário existe
    fun autenticar(): Boolean {
        auth.signInWithEmailAndPassword(email!!, senha!!).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                return@addOnCompleteListener
            }
        }
        return false
    }

    // verifica se o usuário está logado
    fun logado(): Boolean {
        if (auth.currentUser != null) {
            return true
        }
        return false
    }

    // desloga o usuário
    fun deslogar() {
        auth.signOut()
    }

    // cria um usuário no firebase
    fun criarUsuario(): Boolean {
        auth.createUserWithEmailAndPassword(email!!, senha!!).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                return@addOnCompleteListener
            }
        }
        return false
    }

    // envia um email de verificacao para o usuário
    fun enviarEmailVerificacao() {
        auth.currentUser?.sendEmailVerification()
    }

    // verifica se o email do usuário foi verificado
    fun emailVerificado(): Boolean {
        if (auth.currentUser!!.isEmailVerified) {
            return true
        }
        return false
    }

    // envia um email para o usuário recuperar a senha
    fun enviarEmailRecuperacao() {
        auth.sendPasswordResetEmail(email!!)
    }

    // deleta o usuário do firebase
    fun deletarUsuario() {
        auth.currentUser?.delete()
    }

    // atualiza a senha do usuário
    fun atualizarSenha() {
        auth.currentUser?.updatePassword(senha!!)
    }

    // atualiza o email do usuário
    fun atualizarEmail() {
        auth.currentUser?.updateEmail(email!!)
    }

    // atualiza o email do usuário e envia um email de verificacao
    fun atualizarEmailVerificacao() {
        auth.currentUser?.updateEmail(email!!)?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                auth.currentUser?.sendEmailVerification()
            }
        }
    }


}