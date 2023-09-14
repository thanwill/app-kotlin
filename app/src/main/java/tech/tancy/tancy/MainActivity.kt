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
    private lateinit var compromissoAdapter: CompromissoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        compromissoAdapter = CompromissoAdapter(context = this)

        binding.recyclerCompromissos.layoutManager = LinearLayoutManager(this)
        binding.recyclerCompromissos.adapter = compromissoAdapter

        binding.buttonAddCompromisso.setOnClickListener(){
            // iniciar a CadastroActivity
            startActivity(Intent(this, CadastroActivity::class.java ))

        }


    }

    override fun onStart() {
        super.onStart()
        // atualizar itens da recycler view
        compromissoAdapter.notifyDataSetChanged()
    }
}

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCadastrar.setOnClickListener(){


            val compromisso = Compromissos(
                binding.editTextTitulo.text.toString(),
                binding.editTextDescricao.text.toString(),
                binding.editTextData.text.toString(),
                binding.editTextInicio.text.toString(),
                binding.editTextFim.text.toString()
            )

            ListaCompromissos.adicionarCompromisso(compromisso)

            finish()
        }
    }
}




