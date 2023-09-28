package tech.tancy.tancy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import com.google.android.material.snackbar.Snackbar
import tech.tancy.tancy.data.AppDatabase
import tech.tancy.tancy.data.Login
import tech.tancy.tancy.data.User
import tech.tancy.tancy.data.UserDAO
import tech.tancy.tancy.data.Util
import tech.tancy.tancy.databinding.ActivityCadastroPerfilBinding
import tech.tancy.tancy.databinding.ActivityLoginBinding
import tech.tancy.tancy.databinding.ActivityMessageBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = binding.editTextEmailAddress
        val senha = binding.editTextPassword
        val logado = binding.switchLogado


        // verifica se o botão de lembrar está marcado e salva no SharedPreferenc
        logado.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val sharedPreferences = getSharedPreferences("tancy", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("email", email.text.toString())
                editor.putString("senha", senha.text.toString())
                // adiciona um logado true para saber se o usuário está logado
                editor.putBoolean("logado", true)
                editor.apply()
            }
        }

        // verifica se o icone drawableEnd do EditText está sendo clicado e mostra a senha
        senha.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= (senha.right - senha.compoundDrawables[2].bounds.width())) {
                    if (senha.transformationMethod == PasswordTransformationMethod.getInstance()) {
                        senha.transformationMethod = HideReturnsTransformationMethod.getInstance()
                        senha.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility_off_fill, 0)
                    } else {
                        senha.transformationMethod = PasswordTransformationMethod.getInstance()
                        senha.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility_fill, 0)
                    }
                    return@setOnTouchListener true
                }
            }
            return@setOnTouchListener false
        }



        // botão de login
        binding.buttonLogin.setOnClickListener(){
            val login = Login()

            // valida se os dados foram preenchidos
            if (email.text.toString().isEmpty()) {
                email.error = "Preencha o email"
                email.requestFocus()
                return@setOnClickListener
            }

            // verifica se o email é válido
            if (!Util.validarEmail(email.text.toString())) {
                email.error = "Email inválido"
                email.requestFocus()
                return@setOnClickListener
            }

            // verifica se a senha tem mais de 6 caracteres numéricos
            if (!Util.validarSenha(senha.text.toString())) {
                senha.error = "A senha deve ter mais de 6 caracteres"
                senha.requestFocus()
                return@setOnClickListener
            }


            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }

        // botão para recuperar a senha
        binding.buttonForgotPassword.setOnClickListener(){
            val login = Login()

            // valida se os dados foram preenchidos
            if (email.text.toString().isEmpty()) {
                email.error = "Preencha o email"
                email.requestFocus()
                return@setOnClickListener
            }

            // verifica se o email é válido usando a classe Util
            if (!Util.validarEmail(email.text.toString())) {
                email.error = "Email inválido"
                email.requestFocus()
                return@setOnClickListener
            }

            // salva os dados no objeto login
            login.email = email.text.toString()

            login.enviarEmailRecuperacao()

            // DIRECIONA PARA A ACTIVITY DE RECUPERAR A SENHA
            startActivity(Intent(this, ForgotPasswordActivity::class.java).apply {
                putExtra("email", email.text.toString())
            })
        }

        // botão para criar um novo usuário
        binding.buttonCreateAccount.setOnClickListener(){
            startActivity(Intent(this, Cadastrar::class.java))
            finish()
        }
    }
}

// cria uma activity para mensagem de esqueceu a senha
class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMessageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // pega o email enviado pela intent
        val email = intent.getStringExtra("email")

        // mostra o email na tela

        binding.textViewMessage.text = "Um email foi enviado para $email"

        binding.buttonBack.setOnClickListener(){
            finish()
        }


    }
}

// activity para tela de cadastro de novos usuários activity_cadastro_perfil.xml

class Cadastrar : AppCompatActivity(){
    private lateinit var binding: ActivityCadastroPerfilBinding
    private lateinit var userDAO: UserDAO

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userDAO = AppDatabase.getInstance(this).userDAO()

        val nome = binding.editTextUserName.text
        val email = binding.editTextUserEmailAddress.text
        val senha = binding.editTextUserNumberPassword.text

        binding.buttonCreateAccount.setOnClickListener(){
            val usuario = User(0, nome.toString(), email.toString(), senha.toString())
            userDAO.insert(usuario)

            // exibe os dados do usuário cadastrado no textViewUsuario
            binding.textViewUsuario.text = usuario.toString()

            //startActivity(Intent(this, LoginActivity::class.java))
            //finish()
        }



    }
}
