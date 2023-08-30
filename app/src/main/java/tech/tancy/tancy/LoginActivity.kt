package tech.tancy.tancy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import tech.tancy.tancy.data.Carro
import tech.tancy.tancy.data.Heroi
import tech.tancy.tancy.data.Pessoa
import tech.tancy.tancy.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater) // infla o layout da activity_cadastro
        var view = binding.root // acessa tudo que está dentro do binding (activity_cadastro)

        var p1 = Pessoa("Tancy", 20)
        var c1 = Carro()
        var h1 = Heroi("Tancy", "Super Força", 20)

        Log.d("TESTE", p1.toString())
        Log.d("TESTE", c1.toString())
        Log.d("TESTE", h1.toString())

    }
}