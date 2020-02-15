package com.ravimhzn.daggerinkotlin.ui.main.post

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ravimhzn.daggerinkotlin.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class PostFragment : DaggerFragment() {

    private var TAG = PostFragment::class.java.name
    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory

    lateinit var viewModel: PostViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(requireContext(), "Profile Fragment", Toast.LENGTH_SHORT).show()
        var v = inflater.inflate(R.layout.fragment_post, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel =
            ViewModelProvider(this, providerFactory).get(PostViewModel::class.java)
        subscribeObserver()
    }

    private fun subscribeObserver() {
        viewModel.observePosts().removeObservers(viewLifecycleOwner)
        viewModel.observePosts().observe(viewLifecycleOwner, Observer {
            when (it) {
                is PostResource.Success -> {
                    Log.d(TAG, "onChanged: " + it.data);
                }

                is PostResource.Error -> {
                    Log.d(TAG, "onError: ${it.data}");
                }
            }
        })
    }
}