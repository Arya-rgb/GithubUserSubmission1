package com.thorin.dicoding.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thorin.dicoding.R
import com.thorin.dicoding.model.DataUsers
import com.thorin.dicoding.view.UserDetail

class UserListAdapter(var dataList: ArrayList<DataUsers>) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewgroup: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(viewgroup.context).inflate(R.layout.user_item, viewgroup, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")

    override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {
        val user = dataList[position]
        viewholder.username.text = user.username
        viewholder.name.text = user.name
        viewholder.avatar.setImageResource(user.avatar)
        viewholder.follower.text = "Follower ${user.follower}"
        viewholder.following.text = "Following ${user.following}"
        viewholder.company.text = user.company
        viewholder.location.text = user.location
        viewholder.repository.text = "Repo ${user.repository}"

        //Move To Detail Activity
        val dataUserIntent = DataUsers(
            user.username,
            user.name,
            user.avatar,
            user.follower,
            user.following,
            user.company,
            user.location,
            user.repository
        )

        val sUser = viewholder.itemView.context

        viewholder.itemView.setOnClickListener {
            val moveSpec = Intent(sUser, UserDetail::class.java)
            moveSpec.putExtra(UserDetail.EXTRA_DETAIL, dataUserIntent)
            sUser.startActivity(moveSpec)
        }
    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val username: TextView = itemView.findViewById(R.id.username)
        val name: TextView = itemView.findViewById(R.id.name)
        val avatar: ImageView = itemView.findViewById(R.id.avatar)
        val follower: TextView = itemView.findViewById(R.id.follower)
        val following: TextView = itemView.findViewById(R.id.following)
        val company: TextView = itemView.findViewById(R.id.company)
        val location: TextView = itemView.findViewById(R.id.location)
        val repository: TextView = itemView.findViewById(R.id.repository)

    }

    fun filterList(filteredCourseList: ArrayList<DataUsers>) {
        this.dataList = filteredCourseList
        notifyDataSetChanged()
    }

}