package tech.tancy.tancy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nome: String // Declare a variável nome
        var input = findViewById<EditText>(R.id.editTextTextPersonName)
        var textView = findViewById<TextView>(R.id.textViewName)
        val button = findViewById<Button>(R.id.button)

        fun isNotNumber(input: String): Boolean {
            return try {
                input.toDouble() // Tenta converter a string em um número
                false // Retorna falso se a conversão for bem-sucedida
            } catch (e: NumberFormatException) {
                true // Retorna verdadeiro se a conversão falhar, ou seja, não é um número
            }
        }

        // verifica se o usuário deu enter no input
        input.setOnEditorActionListener { _, _, _ ->
            nome = input.text.toString()

            if (nome.isEmpty() && isNotNumber(nome)) {
                Toast.makeText(this, "Insira algo para começar!", Toast.LENGTH_LONG).show()
            } else {
                textView.text = "Seja bem-vindo, $nome!"
                input.visibility = EditText.INVISIBLE
                button.visibility = Button.VISIBLE
            }

            true
        }


        button.setOnClickListener {
            // cria uma intent para acessar a CadastroActivity
            val intent = android.content.Intent(this, CadastroActivity::class.java)

            startActivity(intent) // inicia a intent
        }

    }


}