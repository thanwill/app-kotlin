package tech.tancy.tancy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import tech.tancy.tancy.databinding.ActivityDetalhesBinding
import tech.tancy.tancy.databinding.ActivityEditarBinding

class DetalhesActivity : AppCompatActivity(){

    private lateinit var binding: ActivityDetalhesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetalhesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val index = intent.getIntExtra("index", -1) // -1 é o valor padrão caso não seja passado nenhum index
        val compromisso = ListaCompromissos.getCompromisso(index)

        if (index == -1){
            finish()
        }else{
            binding.textViewTitulo.text = compromisso.titulo
            binding.textViewDescricao.text = compromisso.descricao
            binding.textViewData.text = compromisso.data
            binding.textViewHoraInicio.text = compromisso.horaInicio
            binding.textViewHoraFim.text = compromisso.horaFim
        }

        binding.buttonDetalhesExcluir.setOnClickListener(){
            //ListaCarros.removerCarro(index)
            ListaCompromissos.removerCompromisso(index)
            finish()
        }
    }
}

