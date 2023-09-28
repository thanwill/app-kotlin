package tech.tancy.tancy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import tech.tancy.tancy.data.CompromissoAdapter
import tech.tancy.tancy.data.Compromissos
import tech.tancy.tancy.data.ListaCompromissos
import tech.tancy.tancy.databinding.ActivityAppBinding
import tech.tancy.tancy.databinding.ActivityCadastroBinding
import tech.tancy.tancy.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAppBinding

    private lateinit var buttonLista : Button
    private lateinit var buttonCadastro : Button
    private lateinit var buttonPerfil : Button
    private lateinit var buttonDetalhes : Button

    private lateinit var listaFragment: Fragment
    private lateinit var cadastroFragment: Fragment
    private lateinit var perfilFragment: Fragment
    private lateinit var detalhesFragment: Fragment
    private lateinit var loginFragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonLista = binding.buttonListaCompromissos
        buttonCadastro = binding.buttonAddCompromisso
        buttonPerfil = binding.buttonPerfil

        buttonLista.setOnClickListener(this)
        buttonPerfil.setOnClickListener(this)
        buttonCadastro.setOnClickListener(this)

        perfilFragment = PerfilFragment()
        cadastroFragment = CompromissoFragment()
        listaFragment = ListaFragment()
        loginFragment = LoginFragment()

        // oculta o linearLayoutBotoes'
        binding.linearLayoutBotoes.visibility = View.GONE

        // inicia o fragmento de login
        trocarFragmento(loginFragment)


    }

    //

    // método responsável por gerenciar a troca de fragmentos
    private fun trocarFragmento(fragmento: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayoutFragment, fragmento) // e substituir o fragmento atual pelo fragmento passado como parâmetro
            commit()// e por fim, confirmar a transação
        }
    }

    // método responsável por gerenciar os cliques nos botões, e chamar o método trocarFragmento
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.buttonListaCompromissos -> {
                trocarFragmento(listaFragment)
            }
            R.id.buttonAddCompromisso -> {
                trocarFragmento(cadastroFragment)
            }
            R.id.buttonPerfil -> {
                trocarFragmento(perfilFragment)
            }
        }
    }

}
class MainActivity2 : AppCompatActivity() {

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




