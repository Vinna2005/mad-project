package com.example.expirytracker

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
<<<<<<< HEAD
import androidx.activity.result.contract.ActivityResultContracts
=======
>>>>>>> 5d55251bf52f28edc59179d41fb3c428be9c85a3
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

<<<<<<< HEAD
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

=======
    private val RC_SIGN_IN = 100
    private lateinit var googleSignInClient: GoogleSignInClient

>>>>>>> 5d55251bf52f28edc59179d41fb3c428be9c85a3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

<<<<<<< HEAD
        val etEmail    = findViewById<TextInputEditText>(R.id.etEmail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val btnLogin   = findViewById<MaterialButton>(R.id.btnLogin)
        val btnGoogle  = findViewById<MaterialButton>(R.id.btnGoogleSignIn)
        val tvSkip     = findViewById<TextView>(R.id.tvSkip)

        val gso = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
=======
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
        val btnGoogle = findViewById<MaterialButton>(R.id.btnGoogleSignIn)
        val tvSkip = findViewById<TextView>(R.id.tvSkip)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
>>>>>>> 5d55251bf52f28edc59179d41fb3c428be9c85a3
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
<<<<<<< HEAD
            val pass  = etPassword.text.toString().trim()
            when {
                email.isEmpty()   -> etEmail.error    = "Email required"
                pass.isEmpty()    -> etPassword.error = "Password required"
                pass.length < 6   -> etPassword.error = "Min 6 characters"
                else              -> goToHome(email)
=======
            val pass = etPassword.text.toString().trim()
            when {
                email.isEmpty() -> etEmail.error = "Email required"
                pass.isEmpty() -> etPassword.error = "Password required"
                pass.length < 6 -> etPassword.error = "Min 6 characters"
                else -> goToHome()
>>>>>>> 5d55251bf52f28edc59179d41fb3c428be9c85a3
            }
        }

        btnGoogle.setOnClickListener {
<<<<<<< HEAD
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

=======
            startActivityForResult(googleSignInClient.signInIntent, RC_SIGN_IN)
        }

        tvSkip.setOnClickListener { goToHome() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            try {
                val account = GoogleSignIn.getSignedInAccountFromIntent(data)
                    .getResult(ApiException::class.java)
                Toast.makeText(this, "Welcome ${account.displayName}!", Toast.LENGTH_SHORT).show()
                goToHome()
            } catch (e: ApiException) {
                Toast.makeText(this, "Google Sign-In failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun goToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}
>>>>>>> 5d55251bf52f28edc59179d41fb3c428be9c85a3
