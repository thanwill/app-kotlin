package tech.tancy.tancy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import tech.tancy.tancy.data.CompromissoAdapter
import tech.tancy.tancy.data.Compromissos
import tech.tancy.tancy.data.ListaCompromissos
import tech.tancy.tancy.databinding.ActivityCadastroBinding
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

            // Realiza uma validaçao dos campos
            if(binding.editTextTitulo.text.toString().isEmpty()){
                binding.editTextTitulo.error = "Campo obrigatório"
                return@setOnClickListener
            }

            if(binding.editTextDescricao.text.toString().isEmpty()){
                binding.editTextDescricao.error = "Campo obrigatório"
                return@setOnClickListener
            }

            if(binding.editTextData.text.toString().isEmpty()){
                binding.editTextData.error = "Campo obrigatório"
                return@setOnClickListener
            }

            if(binding.editTextInicio.text.toString().isEmpty()){
                binding.editTextInicio.error = "Campo obrigatório"
                return@setOnClickListener
            }

            if(binding.editTextFim.text.toString().isEmpty()){
                binding.editTextFim.error = "Campo obrigatório"
                return@setOnClickListener
            }

            // cria um objeto do tipo Compromissos


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




