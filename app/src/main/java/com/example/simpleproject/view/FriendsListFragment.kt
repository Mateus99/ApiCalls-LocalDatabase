package com.example.simpleproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleproject.R
import com.example.simpleproject.data.db.FriendEntity
import com.example.simpleproject.databinding.FragmentFriendsListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FriendsListFragment : Fragment() {

    private lateinit var binding: FragmentFriendsListBinding
    private lateinit var friendsListAdapter: FriendsListAdapter
    private val viewModel by viewModel<FriendsListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        binding = FragmentFriendsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        setUpObservers()
        binding.apply {
            addFriendButton.setOnClickListener { onCreateFriendClick() }
            goToRoomScreenButton.setOnClickListener { findNavController().navigate(R.id.action_to_retrofitCallsFragment) }
        }
    }

    private fun setUpView() {
        viewModel.getAllFriends()
    }

    private fun setUpObservers() {
        viewModel.friendsList.observe(viewLifecycleOwner, { handleRecyclerView(it) })
    }

    private fun onCreateFriendClick() {
        binding.apply {
            viewModel.createFriend(nameEditText.text.toString(), phoneEditText.text.toString())
            nameEditText.setText("")
            phoneEditText.setText("")
        }
    }

    private fun handleRecyclerView(friendsList: List<FriendEntity>) {
        friendsListAdapter = FriendsListAdapter(friendsList, requireContext())
        binding.friendsListRecyclerView.run {
            adapter = friendsListAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}