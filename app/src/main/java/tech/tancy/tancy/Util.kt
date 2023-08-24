package tech.tancy.tancy

import android.content.Context
import android.graphics.Color
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class Util {

    // Cria um companion object para que os métodos possam ser acessados sem a necessidade de instanciar a classe
    companion object{

        fun exibirToast(context: Context, mensagem: String) {
            Toast.makeText(context, mensagem, Toast.LENGTH_LONG).show()
        }

        fun exibirSnackbar( view: android.view.View, messageError: String) {

            val snackbar = Snackbar.make(view, "$messageError", Snackbar.LENGTH_LONG)
            snackbar.setBackgroundTint(Color.RED)
            snackbar.show()

        }
    }
}