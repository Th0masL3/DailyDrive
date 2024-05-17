package com.example.dailydrive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class HigherOrLower : Fragment() {
    private lateinit var questionTextView: TextView
    private lateinit var higherButton: Button
    private lateinit var lowerButton: Button
    private lateinit var submitButton: Button

    private var displayedPrice = 450000  // Price displayed to the user
    private var guessedHigher: Boolean? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_higher_or_lower, container, false)
        questionTextView = view.findViewById(R.id.questionTextView)
        questionTextView.text = "Is the actual price higher or lower than $450,000?"
        higherButton = view.findViewById(R.id.answerButton1)
        lowerButton = view.findViewById(R.id.answerButton2)
        submitButton = view.findViewById(R.id.submitButton)

        higherButton.setOnClickListener { guessedHigher = true }
        lowerButton.setOnClickListener { guessedHigher = false }
        submitButton.setOnClickListener { checkAnswer() }

        return view
    }

    private fun checkAnswer() {
        // Fetch the correct actual price dynamically from resources
        val actualPrice = resources.getInteger(R.integer.correct_price)

        guessedHigher?.let {
            if ((it && actualPrice > displayedPrice) || (!it && actualPrice < displayedPrice)) {
                Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Wrong!", Toast.LENGTH_SHORT).show()
            }
        } ?: run {
            Toast.makeText(context, "Please make a guess first!", Toast.LENGTH_SHORT).show()
        }
    }
}
