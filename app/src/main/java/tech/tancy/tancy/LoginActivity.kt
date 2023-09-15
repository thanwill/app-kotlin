package tech.tancy.tancy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import com.google.android.material.snackbar.Snackbar
import tech.tancy.tancy.data.Login
import tech.tancy.tancy.data.Util
import tech.tancy.tancy.databinding.ActivityLoginBinding

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
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
                email.error = "Email inválido"
                email.requestFocus()
                return@setOnClickListener
            }

            // verifica se a senha tem mais de 6 caracteres numéricos
            if (senha.text.toString().length < 6) {
                senha.error = "A senha deve ter mais de 6 caracteres"
                senha.requestFocus()
                return@setOnClickListener
            }

            // salva os dados no objeto login
            login.email = email.text.toString()
            login.senha = senha.text.toString()

            if (login.autenticar()) {
                if (login.emailVerificado()) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Snackbar.make(binding.root, "Email não verificado", Snackbar.LENGTH_LONG).show()
                }
            } else {
                Snackbar.make(binding.root, "Email ou senha incorretos", Snackbar.LENGTH_LONG).show()
            }
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
            Snackbar.make(binding.root, "Email enviado", Snackbar.LENGTH_LONG).show()
        }
    }
}