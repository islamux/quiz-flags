package com.islamux.quizflags

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.islamux.quizflags.databinding.ActivityQuestionsBinding

class QuestionsActivity : AppCompatActivity() , View.OnClickListener{

    // binding step 1
    private lateinit var binding: ActivityQuestionsBinding

    private val TAG = "QuestionsActivity"

    private var currentPosition :Int  = 1 // Track the current question index
    private var questionsList: ArrayList<QuestionModule>? = null // List of questions
    private var selectedOptionPosition: Int = 0 // Track the selected option position
    private var correctAnswers: Int = 0 // Track the number of correct answers
    private var userName: String? = null // User's name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // binding 2:  inflate the layout Inflate the layout
        binding = ActivityQuestionsBinding.inflate(layoutInflater)

        // Set up the system bars
        ViewCompat.setOnApplyWindowInsetsListener(binding.mainQuestion) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // binding 3: set the content view to the root view of the binding
        setContentView(binding.root)

        Log.d(TAG, "Fathi onCreate called")

        userName = intent.getStringExtra(Constants.USER_NAME)
        questionsList = Constants.getQuestions()

        setQuestion()

        // Set click listeners for the options
        clickListenerForOption()

    }
    override fun onClick(v: View?) {
        //Log.d(TAG, "Fathi onClick : QuestionActivity")

        when(v?.id)
        {
            binding.tvOptionOne.id -> { selectedOptionView(binding.tvOptionOne, 1) }
            binding.tvOptionTwo.id -> { selectedOptionView(binding.tvOptionTwo, 2) }
            binding.tvOptionThree.id -> { selectedOptionView(binding.tvOptionThree, 3) }
            binding.tvOptionFour.id-> { selectedOptionView(binding.tvOptionFour, 4) }
            binding.submitButton.id -> {

                if(selectedOptionPosition == 0){
                    // Go to next question
                    currentPosition++

                    when{
                        currentPosition <= questionsList!!.size -> {
                            setQuestion()
                        }else -> { goToResultActivity() }
                    }
                }else {
                    val question = questionsList?.get(currentPosition -1)

                    if (question!!.correctAnswer != selectedOptionPosition) {
                        answerView(selectedOptionPosition, R.drawable.wrong_option_border_bg)

                    } else {
                        correctAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (currentPosition == questionsList!!.size){
                        binding.submitButton.text = getString(R.string.finish)

                    } else {
                        binding.submitButton.text = getString(R.string.submit)
                    }

                    selectedOptionPosition = 0
                }
            }
        }
    }

    //  *********  *** Functions ***   ***********//
    private fun clickListenerForOption() {
        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.submitButton.setOnClickListener(this)
    }
    private fun setQuestion() {
        val question = questionsList!!.get(currentPosition - 1)

        defaultOptionView()

        if (currentPosition == questionsList!!.size){
            Log.d(TAG, "Fathi submit Finish ")
            binding.submitButton.text = getString(R.string.finish)

        }else{
            binding.submitButton.text = getString(R.string.submit)
            Log.d(TAG, "Fathi submit")

        }

        binding.progressBar.progress = currentPosition
        binding.tvProgress.text = "$currentPosition / ${binding.progressBar.max}"
        binding.tvQuestion.text = question.question
        binding.tvImgView.setImageResource(question.image)
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour

    }
    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOptionOne)
        options.add(1,binding.tvOptionTwo)
        options.add(2,binding.tvOptionThree)
        options.add(3,binding.tvOptionFour)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this@QuestionsActivity,R.drawable.default_option_border_bg)
        }
    }
    private fun answerView(answer:Int, drawable:Int) {
        when(answer){
            1-> binding.tvOptionOne.background = ContextCompat.getDrawable(this,drawable)
            2-> binding.tvOptionTwo.background = ContextCompat.getDrawable(this,drawable)
            3-> binding.tvOptionThree.background = ContextCompat.getDrawable(this,drawable)
            4-> binding.tvOptionFour.background = ContextCompat.getDrawable(this,drawable)
        }
    }
    private fun selectedOptionView(textView: TextView, selectedOptionNum: Int ) {
        defaultOptionView()
        selectedOptionPosition = selectedOptionNum
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this@QuestionsActivity,R.drawable.selected_option_border_bg)
    }
    private fun goToResultActivity() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(Constants.USER_NAME, userName)
        intent.putExtra(Constants.CORRECT_ANSWER, correctAnswers)
        intent.putExtra(Constants.TOTAL_QUESTIONS, questionsList!!.size)
        startActivity(intent)
    }
}