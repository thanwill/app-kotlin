package tech.tancy.tancy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tech.tancy.tancy.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater) // infla o layout da activity_cadastro
        var view = binding.root // acessa tudo que está dentro do binding (activity_cadastro)
        setContentView(view) // seta o conteúdo da tela com o binding


        val textViewRegister = binding.textViewRegister
        textViewRegister.setOnClickListener {
            // cria uma intent para acessar a CadastroActivity
            val intent = android.content.Intent(this, CadastroActivity::class.java)
            startActivity(intent) // inicia a intent
        }
    }
}