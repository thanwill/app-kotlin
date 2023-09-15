package tech.tancy.tancy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import com.google.android.material.snackbar.Snackbar
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

        // cria um usuário no SharedPreferenc para ser comparado com as entradas do usuário
        val sharedPreferences = getSharedPreferences("tancy", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("email", "admin")
        editor.putString("senha", "2020")
        editor.apply()

        // botão de login

        binding.buttonLogin.setOnClickListener(){
            // faz a comparação com o usuário criado no SharedPreferenc
            if( email.text.toString() == sharedPreferences.getString("email", "admin") &&
                senha.text.toString() == sharedPreferences.getString("senha", "2020")){
                // iniciar a MainActivity
                startActivity(Intent(this, MainActivity::class.java ))
            }else{
                // mostrar mensagem de erro
                val snackbar = Snackbar.make(binding.root, "Usuário ou senha inválidos", Snackbar.LENGTH_LONG)
                snackbar.show()
            }
        }
    }
}