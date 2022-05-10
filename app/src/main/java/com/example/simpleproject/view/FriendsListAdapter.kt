package com.example.simpleproject.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleproject.R
import com.example.simpleproject.data.db.FriendEntity
import kotlinx.android.synthetic.main.item_list_friend.view.item_name
import kotlinx.android.synthetic.main.item_list_friend.view.item_phone

class FriendsListAdapter(
    private val friendsList: List<FriendEntity>,
    private val context: Context
) : RecyclerView.Adapter<FriendsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list_friend, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return friendsList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.item_name
        val phone = itemView.item_phone

        fun bind(position: Int) {
            val item = friendsList[position]
            name.text = item.name
            phone.text = item.phone
        }
    }
}