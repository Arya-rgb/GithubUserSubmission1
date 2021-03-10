package com.thorin.dicoding.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import com.thorin.dicoding.R
import com.thorin.dicoding.model.DataUsers
import java.lang.StringBuilder

class UserDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }

    private lateinit var itemUser: DataUsers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        itemUser = intent.getParcelableExtra<DataUsers>(EXTRA_DETAIL) as DataUsers

        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = itemUser.name

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val shareBody = "hay, Aku mau merekomendasikan akun github untuk belajar, langsung klik -> https://github.com/${itemUser.username}, pemilik akun nya adalah ${itemUser.name}, Selamat Belajar."
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, itemUser.name)
            intent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(intent, "Mau Share Kemana Nih ?"))
        }

        findViewById<ImageView>(R.id.avatar).setImageResource(itemUser.avatar)
        findViewById<TextView>(R.id.username).text = itemUser.username
        findViewById<TextView>(R.id.name).text = itemUser.name
        findViewById<TextView>(R.id.follower).text = StringBuilder(resources.getString(R.string.Follower)).append(" ${itemUser.follower}")
        findViewById<TextView>(R.id.following).text = StringBuilder(resources.getString(R.string.Following)).append(" ${itemUser.following}")
        findViewById<TextView>(R.id.company).text = StringBuilder(resources.getString(R.string.Company)).append(" ${itemUser.company}")
        findViewById<TextView>(R.id.location).text = StringBuilder(resources.getString(R.string.Location)).append(" ${itemUser.location}")
        findViewById<TextView>(R.id.repository).text = StringBuilder(resources.getString(R.string.Repository)).append(" ${itemUser.repository}")
        findViewById<TextView>(R.id.profil).text = StringBuilder(resources.getString(R.string.Profil)).append(" ${itemUser.name}")

        findViewById<TextView>(R.id.showprofile).setOnClickListener {
            val url = "https://github.com/${itemUser.username}"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}