package com.joule.myaxatest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.joule.myaxatest.adapter.PostAdapter
import com.joule.myaxatest.dataClass.Post
import com.joule.myaxatest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    var arrPost: ArrayList<Post> = ArrayList()
    var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getPost()

        viewModel.post.observe(this, {
            it?.let {
                arrPost.addAll(it)
                setPage()
            }
        })

        binding.rvList.layoutManager = LinearLayoutManager(this)
        viewModel.postByPage.observe(this, {
            binding.rvList.adapter = PostAdapter(it)
        })

        binding.tvNext.setOnClickListener {
            arrPost?.let {
                if (page < 10) {
                    page = page + 1
                    setPage()
                }
            }
        }

        binding.tvPrev.setOnClickListener {
            arrPost?.let {
                if (page > 1) {
                    page = page - 1
                    setPage()
                }
            }
        }
    }

    fun setPage() {
        arrPost?.let {
            binding.tvPage.text = "Page $page"
            viewModel.getPostByPage(page, arrPost)
        }
    }

}
