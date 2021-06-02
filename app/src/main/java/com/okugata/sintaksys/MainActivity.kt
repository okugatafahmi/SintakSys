package com.okugata.sintaksys

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.okugata.sintaksys.core.data.Resource
import com.okugata.sintaksys.databinding.ActivityMainBinding
import com.okugata.sintaksys.domain.model.Text
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
//            submitButton.setOnClickListener(this@MainActivity)
//            textResult.visibility = View.GONE
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
//            R.id.submit_button -> {
//                mainViewModel.getCorrectedText(Text(binding.textInput.text.toString()))
//                    .observe(this) {
//                        when(it) {
//                            is Resource.Success -> {
//                                binding.textResult.text = it.data?.message
//                                binding.textResult.visibility = View.VISIBLE
//                            }
//                            else -> {
//                                Toast.makeText(
//                                    this,
//                                    "There is error",
//                                    Toast.LENGTH_SHORT
//                                ).show()
//                            }
//                        }
//                    }
//            }
        }
    }
}
