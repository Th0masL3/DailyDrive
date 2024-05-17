package com.example.dailydrive

import android.os.Bundle
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main_activity)

        // Display the first fragment when the app starts
        if (savedInstanceState == null) {
            switchFragment(FirstFragment())
        }

        // Set up button listeners for each fragment
        val buttonFragment1: Button = findViewById(R.id.button_fragment1)
        val buttonFragment2: Button = findViewById(R.id.button_fragment2)
        val buttonFragment3: Button = findViewById(R.id.button_fragment3)
        val buttonFragment4: Button = findViewById(R.id.button_fragment4)
        val buttonFragment5: Button = findViewById(R.id.button_fragment5)
        val buttonFragment6: Button = findViewById(R.id.button_fragment6)
        val buttonFragment7: Button = findViewById(R.id.button_fragment7)
        val buttonBack: Button = findViewById(R.id.button_back)

        buttonFragment1.setOnClickListener { switchFragment(FirstFragment()) }
        buttonFragment2.setOnClickListener { switchFragment(SecondFragment()) }
        buttonFragment3.setOnClickListener { switchFragment(thirdFragment()) }
        buttonFragment4.setOnClickListener { switchFragment(FourthFragment()) }
        buttonFragment5.setOnClickListener { switchFragment(FifthFragment()) }
        buttonFragment6.setOnClickListener { switchFragment(sixthFragment()) }
        buttonFragment7.setOnClickListener { switchFragment(sevenFragment()) }

        // Set up back button listener
        buttonBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        // Handle the back press using OnBackPressedDispatcher
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (supportFragmentManager.backStackEntryCount > 0) {
                    supportFragmentManager.popBackStack()
                } else {
                    finish() // Close the activity if no fragments are in the back stack
                }
            }
        })
    }

    // Method to switch fragments
    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}