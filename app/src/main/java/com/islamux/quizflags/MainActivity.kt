package com.islamux.quizflags

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.islamux.quizflags.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // binding step 1
    private lateinit var binding: ActivityMainBinding

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // binding 2:  inflate the layout
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Set up the system bars
        ViewCompat.setOnApplyWindowInsetsListener(binding.nameText) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // binding 3: set the content view to the root view of the binding
        setContentView(binding.root)

        Log.d(TAG, "Fathi onCreate called")

        // btnStar setOnClickListener
        binding.btnStart.setOnClickListener {
            if (binding.nameText.toString().isEmpty()){
                Toast.makeText(this@MainActivity, getString(R.string.please_enter_your_name),Toast.LENGTH_SHORT).show()

            }else{
                val intent = Intent(this@MainActivity,QuestionsActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}