package tech.tancy.tancy

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import tech.tancy.tancy.data.LoginDataSource

class Util {

    // Cria um companion object para que os métodos possam ser acessados sem a necessidade de instanciar a classe
    companion object{

        // Cria um método para exibir um toast

        fun exibirSnackbar(view: View, messageError: String, type: Int = 0) {

            val snackbar = Snackbar.make(view, messageError, Snackbar.LENGTH_SHORT )

            // Cria um switcase para definir a cor

            when(type){
                0 -> snackbar.setBackgroundTint(Color.RED)
                1 -> snackbar.setBackgroundTint(Color.GREEN)
                2 -> snackbar.setBackgroundTint(Color.BLUE)
                3 -> snackbar.setBackgroundTint(Color.YELLOW)
                4 -> snackbar.setBackgroundTint(Color.MAGENTA)
                5 -> snackbar.setBackgroundTint(Color.CYAN)
                6 -> snackbar.setBackgroundTint(Color.GRAY)
                7 -> snackbar.setBackgroundTint(Color.BLACK)
                8 -> snackbar.setBackgroundTint(Color.WHITE)
                else -> snackbar.setBackgroundTint(Color.RED)
            }
            snackbar.show()

        }
    }
}