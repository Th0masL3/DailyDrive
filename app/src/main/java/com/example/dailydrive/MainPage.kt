package com.example.dailydrive

import android.widget.Button
import androidx.activity.OnBackPressedCallback
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MainPage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_page, container, false)

        val game1Button: Button = view.findViewById(R.id.DailyChallenge)
        val game2Button: Button = view.findViewById(R.id.Level2)
        // Optional: Additional game buttons can be initialized here.

        game1Button.setOnClickListener { switchFragment(GamePage()) }
        game2Button.setOnClickListener { switchFragment(GamePage2()) }
        // Set up other buttons if necessary.

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().supportFragmentManager.popBackStack()
            }
        })

        return view
    }

    // Method to switch fragments dynamically based on the button clicked
    private fun switchFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
