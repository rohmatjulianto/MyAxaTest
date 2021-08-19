package com.joule.myaxatest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.joule.myaxatest.R
import com.joule.myaxatest.dataClass.Post
import com.joule.myaxatest.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = intent.getParcelableExtra<Post>(EXTRA_DATA)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        title = "Detail id ${post?.id}"

        post?.let {
            binding.tvUserId.text =  "User id ${post.userId.toString()}"
            binding.tvId.text = "Id ${post.id.toString()}"
            binding.tvTitle.text = "title : ${post.title}"
            binding.tvBody.text = "body: ${post.body}"
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressed()
        }
        return false
    }

    companion object{
        val EXTRA_DATA = "data"
    }
}