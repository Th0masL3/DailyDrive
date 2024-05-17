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
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_page, container, false)

        //val leaderboard: Button = view.findViewById(R.id.leaderboard)
        //val Gamestore: Button = view.findViewById(R.id.store)
        val Game1: Button = view.findViewById(R.id.game1)
        //val Game2: Button = view.findViewById(R.id.game2)
        //val Game3: Button = view.findViewById(R.id.game3)
        //val Game4: Button = view.findViewById(R.id.game4)


        //leaderboard.setOnClickListener { switchFragment(LeaderBoardFrag()) }
        //Gamestore.setOnClickListener { switchFragment(StoreFrag()) }
        Game1.setOnClickListener { switchFragment(GamePage()) }
        //Game2.setOnClickListener { switchFragment(Game2Frag()) }
        //Game3.setOnClickListener { switchFragment(Game3Frag()) }
        //Game4.setOnClickListener { switchFragment(Game4Frag()) }


        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().supportFragmentManager.popBackStack()
            }
        })

        return view
    }

    // Method to switch fragments
    private fun switchFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.game1, fragment)
            .addToBackStack(null)
            .commit()
    }
}