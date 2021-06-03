package com.okugata.sintaksys.ui.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okugata.sintaksys.R
import com.okugata.sintaksys.databinding.ActivityResultBinding
import com.okugata.sintaksys.databinding.ActivitySubmitBinding
import com.okugata.sintaksys.ui.submit.SubmitActivity

class ResultActivity : AppCompatActivity() {
    private lateinit var binding : ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val text = intent.getStringExtra(RESULT)
        binding.resultTextview.text = text
    }

    companion object {
        const val RESULT = "extra_result"
    }
}