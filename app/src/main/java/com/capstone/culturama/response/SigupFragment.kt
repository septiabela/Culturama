package com.capstone.culturama.response

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.capstone.culturama.R

class SigupFragment : Fragment(), View.OnClickListener {

    // Add necessary EditText and Button variables for sign-up

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sigup_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameView = view.findViewById(R.id.nameEditText)
        emailView = view.findViewById(R.id.emailEditText)
        passwordView = view.findViewById(R.id.password)
        confirmPasswordView = view.findViewById(R.id.confirm_password)
        signUpButton = view.findViewById(R.id.signUpButton)

        // Set the click listener on the sign-up button
        // signUpButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        // Implement sign-up logic similar to SiginFragment
    }
}
