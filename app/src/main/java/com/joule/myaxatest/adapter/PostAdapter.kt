package com.joule.myaxatest.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joule.myaxatest.R
import com.joule.myaxatest.dataClass.Post
import com.joule.myaxatest.databinding.ItemPostBinding
import com.joule.myaxatest.ui.DetailActivity

class PostAdapter(val items : ArrayList<Post>) : RecyclerView.Adapter<PostAdapter.viewHolder>() {
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemPostBinding.bind(itemView)
        fun onBind(post: Post) {
            binding.tvUserId.text =  "User id ${post.userId.toString()}"
            binding.tvId.text = "Id ${post.id.toString()}"
            binding.tvTitle.text = "title : ${post.title}"
            binding.parent.setOnClickListener{
                val intent = Intent(it.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, post)
                it.context.startActivity(intent)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.viewHolder, position: Int) {
        holder.onBind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}