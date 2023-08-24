package tech.tancy.tancy

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.annotation.ColorInt
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthEmailException
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import tech.tancy.tancy.databinding.ActivityCadastroBinding


class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater) // infla o layout da activity_cadastro
        var view = binding.root // acessa tudo que está dentro do binding (activity_cadastro)
        setContentView(view) // seta o conteúdo da tela com o binding

        // cria as variaveis para acessar os elementos da tela

        val btnBack = binding.buttonBack
        val btnSign = binding.buttonSign


        // cria a ação do botão
        btnBack.setOnClickListener(){ view ->

            // cria as variaveis para armazenar os valores dos elementos da tela
            val name = binding.editTextPersonName
            val mail = binding.editTextTextEmailAddress
            val phone = binding.editTextPhone
            val password = binding.editTextPassword

            if(mail.text.toString().isEmpty() || name.text.toString().isEmpty() || phone.text.toString().isEmpty() ){
                val snackbar = Snackbar.make( view, "Preencha todos os campos!", Snackbar.LENGTH_LONG )
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }else{

                auth.createUserWithEmailAndPassword("${mail.text}", "${password.text}").addOnCompleteListener{ cadastro ->
                    if ( cadastro.isSuccessful ){
                        val snackbar = Snackbar.make(view, "Cadastro realizado com sucesso", Snackbar.LENGTH_SHORT )
                        snackbar.setBackgroundTint(Color.BLUE)
                        name.setText("")
                        mail.setText("")
                        phone.setText("")
                        password.setText("")
                        snackbar.show()
                    }
                }
                    .addOnFailureListener { e ->

                        val messageError = when(e){
                            // senha com menos de 6 caracteres
                            is FirebaseAuthWeakPasswordException -> "Digite uma senha com no mínimo 6 dígitos."
                            is FirebaseAuthInvalidCredentialsException -> "Digite um e-mail válido."
                            is FirebaseAuthUserCollisionException -> "Este e-mail já está cadastrado."
                            is FirebaseAuthEmailException -> "Houve um erro com o e-mail fornecido."
                            is FirebaseAuthInvalidUserException -> "Esta conta já foi excluída."
                            is FirebaseNetworkException -> "Sem conexão com a internet."
                            is FirebaseAuthException -> "Não foi possível concluir o cadastro."
                            else -> "Erro ao cadastrar o usuário."
                        }

                        Util.exibirToast(this, messageError)

                    }

            }


        }

        // cria a ação do botão de voltar para a activity MainAcitivity
        btnBack.setOnClickListener(){
            // cria uma intent para acessar a MainActivity
            val intent = Intent(this, LoginActivity::class.java)
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

class ActivityCadastroBinding {

}
