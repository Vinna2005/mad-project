package com.example.expirytracker

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient

    // Replaces deprecated startActivityForResult
    private val signInLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        try {
            val account = GoogleSignIn
                .getSignedInAccountFromIntent(result.data)
                .getResult(ApiException::class.java)
            Toast.makeText(
                this,
                "Welcome ${account.displayName}!",
                Toast.LENGTH_SHORT
            ).show()
            goToHome(account.email ?: "google@user.com")
        } catch (e: ApiException) {
            Toast.makeText(this, "Google Sign-In failed", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail    = findViewById<TextInputEditText>(R.id.etEmail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val btnLogin   = findViewById<MaterialButton>(R.id.btnLogin)
        val btnGoogle  = findViewById<MaterialButton>(R.id.btnGoogleSignIn)
        val tvSkip     = findViewById<TextView>(R.id.tvSkip)

        val gso = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val pass  = etPassword.text.toString().trim()
            when {
                email.isEmpty()   -> etEmail.error    = "Email required"
                pass.isEmpty()    -> etPassword.error = "Password required"
                pass.length < 6   -> etPassword.error = "Min 6 characters"
                else              -> goToHome(email)
            }
        }

        btnGoogle.setOnClickListener {
            signInLauncher.launch(googleSignInClient.signInIntent)
        }

        tvSkip.setOnClickListener {
            goToHome("guest@expirytracker.com")
        }
    }

    private fun goToHome(email: String) {
        getSharedPreferences("UserData", MODE_PRIVATE)
            .edit()
            .putString("email", email)
            .apply()
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}

