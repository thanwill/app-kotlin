package tech.tancy.tancy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import tech.tancy.tancy.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater) // infla o layout da activity_cadastro
        var view = binding.root // acessa tudo que está dentro do binding (activity_cadastro)

        setContentView(view) // seta o conteúdo da tela com o binding
        
        // cria as variaveis para acessar os elementos da tela
        
        val personName = binding.editTextPersonName
        val personMail = binding.editTextTextEmailAddress
        val personPhone = binding.editTextPhone
        val checkWhats = binding.checkBox
        val btn = binding.buttonSign
        val btnBack = binding.button2

        // para cada numero digitaado no campo personPhone, o campo é formatado com o padrão (##) #####-####
        //personPhone.addTextChangedListener(MaskEditUtil.mask(personPhone, MaskEditUtil.FORMAT_FONE))

        // cria a ação do botão
        btn.setOnClickListener(){
            // cria as variaveis para armazenar os valores dos elementos da tela
            val name = personName.text.toString()
            val mail = personMail.text.toString()
            val phone = personPhone.text.toString()

            val whats : String

            if (checkWhats.isChecked){
                whats = "Sim"
            } else {
                whats = "Não"
            }

            // cria a variavel para armazenar o texto que será exibido
            var text = "Nome: $name\nE-mail: $mail\nTelefone: $phone\nWhatsapp: $whats"

            // exibe o texto na tela
            binding.textView2.text = text
        }

        // cria a ação do botão de voltar para a activity MainAcitivity
        btnBack.setOnClickListener(){
            // cria uma intent para acessar a MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // inicia a intent
            startActivity(intent)

        }
        
        

        /*val personName = findViewById<EditText>(R.id.editTextPersonName)
        val personMail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val personPhone = findViewById<EditText>(R.id.editTextPhone)
        val checkWhats = findViewById<CheckBox>(R.id.checkBox)
        val btn = findViewById<Button>(R.id.buttonSign)*/

        //btn.setOnClickListener(){ }

    }
}