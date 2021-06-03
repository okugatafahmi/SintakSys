package com.okugata.sintaksys.ui.submit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.okugata.sintaksys.MainViewModel
import com.okugata.sintaksys.R
import com.okugata.sintaksys.core.data.Resource
import com.okugata.sintaksys.databinding.ActivitySubmitBinding
import com.okugata.sintaksys.domain.model.Text
import com.okugata.sintaksys.ui.result.ResultActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SubmitActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivitySubmitBinding
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubmitBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val text = intent.getStringExtra(SUBMIT_TEXT)
//        val type = intent.getStringExtra(SUBMIT_TYPE)

//        if(type === "UPLOAD"){
////    SET TEXT INPUT DENGAN VAL TEXT
//        }

        binding.run {
            submitButton.setOnClickListener(this@SubmitActivity)
        }
    }

    override fun onClick(v: View){
        when (v.id){
            R.id.submit_button -> {
                mainViewModel.getCorrectedText(Text(binding.inputText.editText?.text.toString()))
                    .observe(this) {
                        when(it) {
                            is Resource.Success -> {
                                // SEND INTENT KE RESULT ACTIVITY
                                val moveWithDataIntent = Intent(this@SubmitActivity, ResultActivity::class.java)
                                moveWithDataIntent.putExtra(ResultActivity.RESULT, it.data?.message)
                                startActivity(moveWithDataIntent)
                            }
                            else -> {
                                Toast.makeText(
                                    this,
                                    "There is error",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
            }
        }
    }

    companion object {
        const val SUBMIT_TEXT = ""
        const val SUBMIT_TYPE = ""
    }
}