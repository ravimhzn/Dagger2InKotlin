package com.ravimhzn.daggerinkotlin.ui.main.post

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ravimhzn.daggerinkotlin.R
import com.ravimhzn.daggerinkotlin.utils.VerticalSpaceItemDecoration
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class PostFragment : DaggerFragment() {

    private var TAG = PostFragment::class.java.name
    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory

    lateinit var viewModel: PostViewModel

    @Inject
    lateinit var postRecyclerAdapter: PostRecyclerAdapter

    private lateinit var recyclerView: RecyclerView


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
        recyclerView = view.findViewById(R.id.recycler_view)
        initRecyclerView()
        viewModel =
            ViewModelProvider(this, providerFactory).get(PostViewModel::class.java)
        subscribeObserver()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        var verticalSpaceItemDecoration = VerticalSpaceItemDecoration(15)
        recyclerView.addItemDecoration(verticalSpaceItemDecoration)
        recyclerView.adapter = postRecyclerAdapter
    }

    private fun subscribeObserver() {
        viewModel.observePosts().removeObservers(viewLifecycleOwner)
        viewModel.observePosts().observe(viewLifecycleOwner, Observer {
            when (it) {
                is PostResource.Success -> {
                    Log.d(TAG, "onChanged: " + it.data);
                    it.data?.let { it1 -> postRecyclerAdapter.setPosts(it1) }
                }

                is PostResource.Error -> {
                    Log.d(TAG, "onError: ${it.data}");
                }
            }
        })
    }
}