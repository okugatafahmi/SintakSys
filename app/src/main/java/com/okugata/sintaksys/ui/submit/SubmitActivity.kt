package com.okugata.sintaksys.ui.submit

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.okugata.sintaksys.R
import com.okugata.sintaksys.core.data.Resource
import com.okugata.sintaksys.core.utils.StringUtils
import com.okugata.sintaksys.databinding.ActivitySubmitBinding
import com.okugata.sintaksys.domain.model.Text
import com.okugata.sintaksys.ui.result.ResultActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SubmitActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivitySubmitBinding
    private val submitViewModel: SubmitViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubmitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            submitButton.setOnClickListener(this@SubmitActivity)
        }
    }

    override fun onClick(v: View){
        when (v.id){
            R.id.submit_button -> {
                val input = binding.inputText.editText?.text.toString()
                submitViewModel.getCorrectedText(Text(input))
                    .observe(this) {
                        when(it) {
                            is Resource.Success -> {
                                val result = it.data?.message?.let { message ->
                                    val temp = StringUtils.addPunctuation(input, message)
                                    StringUtils.addColor(input, temp)
                                } ?: "Empty result"
                                // SEND INTENT KE RESULT ACTIVITY
                                val moveWithDataIntent = Intent(this@SubmitActivity, ResultActivity::class.java)
                                moveWithDataIntent.putExtra(ResultActivity.RESULT, result)
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