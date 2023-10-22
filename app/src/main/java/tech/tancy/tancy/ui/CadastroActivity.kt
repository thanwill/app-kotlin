package tech.tancy.tancy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import tech.tancy.tancy.databinding.ActivityCadastroBinding
import tech.tancy.tancy.viewmodel.CadastroViewModel

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private lateinit var cadastro : CadastroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // inicializar o cadastroViewModel
        cadastro = ViewModelProvider(this)[CadastroViewModel::class.java]

        setObservers()

        binding.buttonCadastrar.setOnClickListener {
            val nome = binding.editTextText.text.toString()
            val email = binding.editTextTextEmailAddress.text.toString()
            val telefone = binding.editTextPhone.text.toString()

            if (cadastro.salvarConvidado(nome, email, telefone)) {
                finish()
            }

        }

    }

    fun setObservers() {
        cadastro.getMessage().observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

}