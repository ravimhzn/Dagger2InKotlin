package com.ravimhzn.daggerinkotlin.ui.main.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ravimhzn.daggerinkotlin.R
import com.ravimhzn.daggerinkotlin.models.User
import com.ravimhzn.daggerinkotlin.ui.auth.AuthResource
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ProfileFragment : DaggerFragment() {

    var TAG = ProfileFragment::class.java.name

    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory

    lateinit var viewModel: ProfileFragmentViewModel

    private lateinit var username: TextView
    private lateinit var email: TextView
    private lateinit var website: TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(requireContext(), "Profile Fragment", Toast.LENGTH_SHORT).show()
        var v = inflater.inflate(R.layout.fragment_profile, container, false)
        username = v.findViewById(R.id.username)
        email = v.findViewById(R.id.email)
        website = v.findViewById(R.id.website)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "OnViewCreated:::")
        viewModel =
            ViewModelProvider(this, providerFactory).get(ProfileFragmentViewModel::class.java)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.getAuthenticatedUser().removeObservers(viewLifecycleOwner)
        viewModel.getAuthenticatedUser().observe(viewLifecycleOwner, Observer {
            when (it) {
                is AuthResource.Success -> {
                    setUserDetails(it.data)
                }

                is AuthResource.Error -> {
                    setErrorDetails(it.message)
                }
            }
        })
    }

    private fun setErrorDetails(message: String?) {
        email.text = message
        username.text = "Error"
        website.text = "Error"
    }

    private fun setUserDetails(data: User?) {
        data?.let {
            email.text = it.email
            username.text = it.username
            website.text = it.website
        }
    }
}