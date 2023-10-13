package tech.tancy.tancy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import tech.tancy.tancy.R
import tech.tancy.tancy.data.AppDatabase
import tech.tancy.tancy.data.Convidado
import tech.tancy.tancy.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private var dao = AppDatabase.getInstance(this).convidadoDao()
    private var id = 0;
    private lateinit var convidado: Convidado
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        id = intent.getIntExtra("id", 0);

        // se o valor de id for maior do que zero, significa que recebemos
        // com sucesso o id de um jogo vindo de outra activity
        if (id > 0) {
            binding.textViewTitleActivity.text = "Editar Convidado"

            // neste caso, buscamos os dados desse jogo em específico

            convidado = dao.selecionarConvidadoPorId(id)

            binding.editTextText.setText(convidado.nome)
            binding.editTextTextEmailAddress.setText(convidado.email)
            binding.editTextPhone.setText(convidado.telefone)
        }

        binding.buttonCadastrar.setOnClickListener {
            validarDados()
        }
    }

    fun validarDados(){

        if (binding.editTextText.text.isEmpty() ||
            binding.editTextTextEmailAddress.text.isEmpty() ||
            binding.editTextPhone.text.isEmpty()) {

            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT)
                .show()
            return

        } else {

            convidado = Convidado(
                id,
                binding.editTextText.text.toString(),
                binding.editTextTextEmailAddress.text.toString(),
                binding.editTextPhone.text.toString()
            )

            // se o id for maior que zero, vamos editar um jogo existente
            if (id > 0) {
                dao.atualizarConvidado(convidado)
                Toast.makeText(this, "Convidado atualizado com sucesso", Toast.LENGTH_SHORT)
                    .show()
                finish()
                return
            }

            dao.inserirConvidado(convidado)
            Toast.makeText(this, "Convidado cadastrado com sucesso", Toast.LENGTH_SHORT)
                .show()

            finish()



        }

    }
}