package com.islamux.quizflags

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.islamux.quizflags.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    // binding step 1
    private lateinit var binding: ActivityResultBinding
    private val TAG = "ResultActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // binding 2:  inflate the layout Inflate the layout
        binding = ActivityResultBinding.inflate(layoutInflater)

        // Set up the system bars
        ViewCompat.setOnApplyWindowInsetsListener(binding.mainResult) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // binding 3: set the content view to the root view of the binding
        setContentView(binding.root)

        Log.d(TAG, "Fathi onCreate: ")

        val userName:String = intent.getStringExtra(Constants.USER_NAME).toString()
        binding.tvName.text = userName
        val totalQuestion:Int = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswer:Int = intent.getIntExtra(Constants.CORRECT_ANSWER,0)
        binding.tvScore.text = " أجبت عن   $correctAnswer   من  $totalQuestion"

        binding.btnFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}