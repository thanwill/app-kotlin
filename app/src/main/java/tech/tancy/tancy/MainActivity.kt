package tech.tancy.tancy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import tech.tancy.tancy.databinding.ActivityCadastroBinding
import tech.tancy.tancy.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // infla o layout da activity_cadastro
        var view = binding.root // acessa tudo que está dentro do binding (activity_cadastro)
        setContentView(view) // seta o conteúdo da tela com o binding

        var btnLogin = binding.buttonLogin

        btnLogin.setOnClickListener {
            // cria uma intent para acessar a CadastroActivity
            val intent = android.content.Intent(this, CadastroActivity::class.java)
            startActivity(intent) // inicia a intent
        }

    }


}