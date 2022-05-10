package com.example.simpleproject.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.simpleproject.databinding.FragmentRetrofitCallsBinding
import com.example.simpleproject.model.Post
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Response

class RetrofitCallsFragment : Fragment() {

    private lateinit var binding: FragmentRetrofitCallsBinding
    private val viewModel by viewModel<RetrofitCallsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRetrofitCallsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        setUp()
    }

    private fun setUp() = binding.apply {
        val options: HashMap<String, String> = HashMap()
        val myPost = Post(1, 1, "Test", "More Test")
        options["_sort"] = "id"
        options["_order"] = "desc"

        button1.setOnClickListener { viewModel.getPost() }
        button2.setOnClickListener { viewModel.getPost2(2) }
        button3.setOnClickListener { viewModel.getCustomPosts(2, "id", "desc") }
        button4.setOnClickListener { viewModel.getCustomPosts2(2, options) }
        button5.setOnClickListener { viewModel.pushPost(myPost) }
        button6.setOnClickListener { myPost.run { viewModel.pushPost2(userId, id, title, body) } }
    }

    private fun setUpObservers() {
        viewModel.myResponse.observe(viewLifecycleOwner, { handleResponseReceived(it) })
        viewModel.myResponse2.observe(viewLifecycleOwner, { handleResponse2Received(it) })
        viewModel.myCustomPosts.observe(viewLifecycleOwner, { handleCustomPosts(it) })
        viewModel.myCustomPosts2.observe(viewLifecycleOwner, { handleCustomPosts2(it) })
        viewModel.myPost.observe(viewLifecycleOwner, { handlePostRequest(it) })
        viewModel.myPost2.observe(viewLifecycleOwner, { handlePostRequest2(it) })
    }

    private fun handleResponseReceived(response: Response<Post>) {
        if (response.isSuccessful) {
            Log.d("Response", response.body()?.userId.toString())
            Log.d("Response", response.body()?.id.toString())
            response.body()?.let { Log.d("Response", it.title) }
            response.body()?.body?.let { Log.d("Response", it) }
            Log.d("Response", "============================")
        } else {
            Log.d("Response", response.errorBody().toString())
        }
    }

    private fun handleResponse2Received(response: Response<Post>) {
        if (response.isSuccessful) {
            Log.d("Response2", response.body()?.userId.toString())
            Log.d("Response2", response.body()?.id.toString())
            response.body()?.let { Log.d("Response2", it.title) }
            response.body()?.body?.let { Log.d("Response2", it) }
            Log.d("Response2", "============================")
        } else {
            Log.d("Response2", response.errorBody().toString())
        }
    }

    private fun handleCustomPosts(response: Response<List<Post>>) {
        if (response.isSuccessful) {
            response.body()?.forEach {
                Log.d("Response3", it.userId.toString())
                Log.d("Response3", it.id.toString())
                Log.d("Response3", it.title)
                Log.d("Response3", it.body)
                Log.d("Response3", "============================")
            }
        }
    }

    private fun handleCustomPosts2(response: Response<List<Post>>) {
        if (response.isSuccessful) {
            response.body()?.forEach {
                Log.d("Response3", it.userId.toString())
                Log.d("Response3", it.id.toString())
                Log.d("Response3", it.title)
                Log.d("Response3", it.body)
                Log.d("Response3", "============================")
            }
        }
    }

    private fun handlePostRequest(response: Response<Post>) {
        if (response.isSuccessful) {
            Log.d("PostRequest", response.body().toString())
            Log.d("PostRequest", response.code().toString())
            Log.d("PostRequest", response.message())
        }
    }

    private fun handlePostRequest2(response: Response<Post>) {
        if (response.isSuccessful) {
            Log.d("PostRequest", response.body().toString())
            Log.d("PostRequest", response.code().toString())
            Log.d("PostRequest", response.message())
        }
    }
}