package com.okugata.sintaksys

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.okugata.sintaksys.databinding.ActivityMainBinding
import com.okugata.sintaksys.ui.submit.SubmitActivity

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
