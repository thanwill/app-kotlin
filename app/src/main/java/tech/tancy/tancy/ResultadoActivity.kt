package tech.tancy.tancy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import tech.tancy.tancy.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultadoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val nome = intent.getStringExtra("nome").toString()
        val cargo = intent.getStringExtra("cargo").toString()
        val valor_hora = intent.getStringExtra("valor_hora").toString().toDouble()
        val horas_trabalhadas = intent.getStringExtra("horas_trabalhadas").toString().toDouble()

        val funcionario = Funcionario(nome, cargo, horas_trabalhadas, valor_hora)
12
        val textViewNome = binding.textViewNome
        val textViewCargo = binding.textViewCargo
        val textViewSalario = binding.textViewSalario
        val textViewAbono = binding.textViewAbono

        textViewNome.text = funcionario.nome
        textViewCargo.text = funcionario.cargo
        textViewSalario.text = funcionario.salario_liquido.toString()
        textViewAbono.text = funcionario.abono.toString()



    }
}