package com.example.dailydrive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main_page)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.game1, MainPage())
                .commit()
        }
    }
}
