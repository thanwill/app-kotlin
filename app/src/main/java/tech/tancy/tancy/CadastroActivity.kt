package tech.tancy.tancy

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import tech.tancy.tancy.databinding.ActivityCadastroBinding


class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater) // infla o layout da activity_cadastro
        var view = binding.root // acessa tudo que está dentro do binding (activity_cadastro)
        setContentView(view) // seta o conteúdo da tela com o binding

        val buttonRegister = binding.buttonSign
        val nome = binding.editTextFuncionarioNome.text
        val horas_tabalhadas = binding.editTextFuncionarioHoras.text
        val valor_hora = binding.editTextFuncionarioValor.text

        // converte o valor da hora para double


        buttonRegister.setOnClickListener(){
            if(nome.isEmpty() || horas_tabalhadas.isEmpty() || valor_hora.isEmpty()){
                Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_LONG).show()
            }else{
                val funcionario = Funcionario(nome.toString(), "Desenvolvedor", horas_tabalhadas.toString().toDouble(), valor_hora.toString().toDouble())
                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("funcionario", funcionario.toString())
                startActivity(intent)
            }
        }

    }

}
