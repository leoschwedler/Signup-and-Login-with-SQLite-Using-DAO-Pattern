package com.example.loginandsignupwithsqlite.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.loginandsignupwithsqlite.database.UserDAO
import com.example.loginandsignupwithsqlite.databinding.ActivityLoginBinding
import com.example.loginandsignupwithsqlite.model.User

class LoginActivity : AppCompatActivity() {

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private lateinit var userDAO: UserDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        userDAO = UserDAO(this)

        with(binding) {
            imageViewLogar.setOnClickListener {
                val loginEmail = binding.editTextEmail.text.toString()
                val loginPassword = binding.editTextPassword.text.toString()
                if (validateInputs(loginEmail, loginPassword)) {
                    val login = User(-1,"", loginEmail, loginPassword)
                    loginDataBase(login)
                }
            }
            textViewRegister.setOnClickListener {
                val intent = Intent(this@LoginActivity, SignupActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loginDataBase(user: User) {
        val existingUser = userDAO.readUser(user)
        if (existingUser) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateInputs(email: String, password: String): Boolean {
        return when {
            email.isEmpty() -> {
                showToast("Please enter a email")
                false
            }

            password.isEmpty() -> {
                showToast("Please enter a password")
                false
            }

            else -> true
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}