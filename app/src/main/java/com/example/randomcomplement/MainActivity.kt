package com.example.randomcomplement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var complementText: TextView
    private lateinit var getComplementButton: Button

    private val complementViewModel: ComplementViewModel by lazy {
        ViewModelProvider(this)[ComplementViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        complementText = findViewById(R.id.complement_text_view)
        getComplementButton = findViewById(R.id.get_complement_button)



        // Issue to work on, the API request takes time and sometimes will not load a complement
        // when the button is first pressed. Alternatively if the button is pressed twice sometimes
        //rotation will cause the second message to be displayed.
        getComplementButton.setOnClickListener{
            complementViewModel.getComplement()
            complementText.text = complementViewModel.complementText
        }

        // Allows for persistence over rotation
        complementText.text = complementViewModel.complementText


    }
}