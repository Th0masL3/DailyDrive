package com.example.dailydrive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class GuessTheBrand : Fragment() {
    private lateinit var questionTextView: TextView
    private lateinit var answerButton1: Button
    private lateinit var answerButton2: Button
    private lateinit var answerButton3: Button
    private lateinit var answerButton4: Button
    private lateinit var submitButton: Button

    private var currentQuestionIndex = 0
    private var selectedAnswerIndex = -1
    private var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_guess_the_brand, container, false)
        questionTextView = view.findViewById(R.id.questionTextView)
        answerButton1 = view.findViewById(R.id.answerButton1)
        answerButton2 = view.findViewById(R.id.answerButton2)
        answerButton3 = view.findViewById(R.id.answerButton3)
        answerButton4 = view.findViewById(R.id.answerButton4)
        submitButton = view.findViewById(R.id.submitButton)

        loadQuestion()
        setupAnswerButtons()
        submitButton.setOnClickListener {
            checkAnswer()
        }
        return view
    }

    private fun setupAnswerButtons() {
        val answerButtons = listOf(answerButton1, answerButton2, answerButton3, answerButton4)
        answerButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                selectedAnswerIndex = index
                Toast.makeText(context, "Answer ${index + 1} selected", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun loadQuestion() {
        val questionResId = resources.getIdentifier(
            "question_brand_${currentQuestionIndex + 1}",  // Updated resource ID for GuessTheBrand
            "string",
            requireContext().packageName
        )
        questionTextView.text = getString(questionResId)
        val answers = resources.getStringArray(
            resources.getIdentifier(
                "answers_brand_${currentQuestionIndex + 1}",  // Updated resource ID for GuessTheBrand
                "array",
                requireContext().packageName
            )
        )
        answerButton1.text = answers[0]
        answerButton2.text = answers[1]
        answerButton3.text = answers[2]
        answerButton4.text = answers[3]
        selectedAnswerIndex = -1
    }

    private fun checkAnswer() {
        val correctAnswerIndex = resources.getInteger(
            resources.getIdentifier(
                "correct_answer_brand_${currentQuestionIndex + 1}",  // Updated to fetch correct answer dynamically for GuessTheBrand
                "integer",
                requireContext().packageName
            )
        ) - 1  // Adjust because indices start from 0 in code but 1 in resources
        if (selectedAnswerIndex == correctAnswerIndex) {
            score++
            Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Wrong!", Toast.LENGTH_SHORT).show()
        }
    }
}