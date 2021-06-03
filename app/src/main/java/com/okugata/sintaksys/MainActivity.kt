package com.okugata.sintaksys

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.okugata.sintaksys.core.data.Resource
import com.okugata.sintaksys.databinding.ActivityMainBinding
import com.okugata.sintaksys.domain.model.Text
import com.okugata.sintaksys.ui.submit.SubmitActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            createNewButton.setOnClickListener(this@MainActivity)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.create_new_button -> {
                val moveWithDataIntent = Intent(this@MainActivity, SubmitActivity::class.java)
                moveWithDataIntent.putExtra(SubmitActivity.SUBMIT_TYPE, "CREATE")
                moveWithDataIntent.putExtra(SubmitActivity.SUBMIT_TEXT, "")
                startActivity(moveWithDataIntent)
            }
        }
    }
}
