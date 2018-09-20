package com.example.asus.retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.asus.retrofit.adapter.PostAdapter
import com.example.asus.retrofit.model.Post
import com.example.asus.retrofit.retrofit.MyApi
import com.example.asus.retrofit.retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal lateinit var jsonApi:MyApi
    var compositeDisposable: CompositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = RetrofitClient.instance
        jsonApi = retrofit.create(MyApi::class.java)

        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(this)

        compositeDisposable.add(jsonApi.posts
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{posts->displayPost(posts)})

    }

    private fun displayPost(posts: List<Post>?) {

        val adapter = PostAdapter(this,posts!!)
        recycler.adapter = adapter

    }


}


