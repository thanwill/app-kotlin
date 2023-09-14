package tech.tancy.tancy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tech.tancy.tancy.databinding.ActivityDetalhesBinding

class DetalhesActivity : AppCompatActivity(){

    private lateinit var binding: ActivityDetalhesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetalhesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val index = intent.getIntExtra("index", -1)
        val carro = ListaCarros.getCarro(index)

        if (index == -1){
            finish()
        }else{
            binding.textViewDetalhesMarca.text = carro.marca
            binding.textViewDetalhesModelo.text = carro.modelo
            binding.textViewDetalhesAno.text = carro.ano.toString()
            binding.textViewDetalhesCor.text = carro.cor
            binding.textViewDetalhesPreco.text = carro.preco.toString()
        }

        binding.buttonDetalhesExcluir.setOnClickListener(){
            ListaCarros.removerCarro(index)
            finish()
        }
    }
}