package com.capstone.culturama.response

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.capstone.culturama.MainActivity
import com.capstone.culturama.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class SiginFragment : Fragment(), View.OnClickListener {

    private lateinit var emailView: EditText
    private lateinit var passwordView: EditText
    private lateinit var signInButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sigin_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        emailView = view.findViewById(R.id.emailEditText)
        passwordView = view.findViewById(R.id.passwordEditText)
        signInButton = view.findViewById(R.id.loginButton)
        signInButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val email = emailView.text.toString()
        val password = passwordView.text.toString()
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "Please enter your email and password", Toast.LENGTH_SHORT).show()
        } else {
            val result = signIn(email, password)
            if (result) {
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
                activity?.finish()
            } else {
                Toast.makeText(context, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private suspend fun signIn(email: String, password: String): Boolean {
        val auth = FirebaseAuth.getInstance()
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            true
        } catch (e: Exception) {
            false
        }
    }
}
