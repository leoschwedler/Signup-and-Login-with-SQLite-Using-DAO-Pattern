package com.example.loginandsignupwithsqlite.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.loginandsignupwithsqlite.database.UserDAO
import com.example.loginandsignupwithsqlite.databinding.ActivitySignupBinding
import com.example.loginandsignupwithsqlite.model.User

class SignupActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }
    private lateinit var userDAO: UserDAO


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        userDAO = UserDAO(this)
        binding.imageViewCreate.setOnClickListener {
            val signupEmail = binding.editTextEmail.text.toString()
            val signUpPassword = binding.editTextPassword.text.toString()
            val signUpUser = binding.editTextName.text.toString()

            if (validateInputs(signupEmail, signUpUser, signUpPassword)) {
                val newUser = User(-1, signUpUser, signupEmail, signUpPassword)
                signUpDataBase(newUser)
            }
        }
    }

    private fun validateInputs(email: String, username: String, password: String): Boolean {
        return when {
            username.isEmpty() -> {
                showToast("Please enter a username")
                false
            }

            email.isEmpty() -> {
                showToast("Please enter an email")
                false
            }

            password.isEmpty() -> {
                showToast("Please enter a password")
                false
            }

            password.length < 6 -> {
                showToast("Password must be at least 6 characters long")
                false
            }

            else -> true
        }
    }

    private fun signUpDataBase(user: User) {
        binding.imageViewCreate.isEnabled = false
        val insertRowId = userDAO.insertUser(user)
        binding.imageViewCreate.isEnabled = true
        if (insertRowId != -1L) {
            showToast("Signup successful")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            showToast("Signup failed")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
