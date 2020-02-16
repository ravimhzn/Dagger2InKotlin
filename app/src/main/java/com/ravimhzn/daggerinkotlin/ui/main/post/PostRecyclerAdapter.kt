package com.ravimhzn.daggerinkotlin.ui.main.post

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ravimhzn.daggerinkotlin.R
import com.ravimhzn.daggerinkotlin.models.Posts


class PostRecyclerAdapter : RecyclerView.Adapter<PostRecyclerAdapter.PostViewHolder>() {

    private var posts: List<Posts> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_post_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun setPosts(posts: List<Posts>) {
        this.posts = posts
        notifyDataSetChanged()
    }


    class PostViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private var title: TextView =
            itemView.findViewById(R.id.tvTitle)

        fun bind(post: Posts) {
            post.title?.let {
                title.text = it
            }
        }
    }
}


