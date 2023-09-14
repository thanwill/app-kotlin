package tech.tancy.tancy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import tech.tancy.tancy.databinding.ActivityCadastroBinding
import tech.tancy.tancy.databinding.ActivityDetalhesBinding
import tech.tancy.tancy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var carroAdapter: CarroAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        carroAdapter = CarroAdapter(context = this)
        // informar o contexto em que a recycler view será inicializada

        binding.recyclerCarros.layoutManager = LinearLayoutManager(this)
        binding.recyclerCarros.adapter = carroAdapter

        binding.buttonAddCarro.setOnClickListener(){
            // iniciar a CadastroActivity
            startActivity(Intent(this, CadastroActivity::class.java ))
        }
    }

    override fun onStart() {
        super.onStart()
        // atualizar itens da recycler view
        carroAdapter.notifyDataSetChanged()
    }
}

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCadastrar.setOnClickListener(){
            val marca = binding.editTextMarca.text.toString()
            val modelo = binding.editTextModelo.text.toString()
            val ano = binding.editTextAno.text.toString().toInt()
            val cor = binding.editTextCor.text.toString()
            val preco = binding.editTextPreco.text.toString().toDouble()

            val carro = Carro(marca, modelo, ano, cor, preco)
            ListaCarros.adicionarCarro(carro)

            finish()
        }
    }
}




