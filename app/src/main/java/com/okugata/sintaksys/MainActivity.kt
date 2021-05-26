package com.okugata.sintaksys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.okugata.sintaksys.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            submitButton.setOnClickListener(this@MainActivity)
            textResult.visibility = View.GONE
        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.submit_button -> {
                binding.textResult.text = binding.textInput.text.toString()
                binding.textResult.visibility = View.VISIBLE
            }
        }
    }
}
