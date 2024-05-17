package com.example.dailydrive

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dailydrive.ui.theme.DailyDriveTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check if this is the first creation of the activity
        if (savedInstanceState == null) {
            // Add the MainPage fragment to the 'fragment_container'
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainPage())
                .commit()
        }
    }
}