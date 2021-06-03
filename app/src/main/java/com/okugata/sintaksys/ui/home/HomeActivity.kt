package com.okugata.sintaksys.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.okugata.sintaksys.R
import com.okugata.sintaksys.databinding.ActivityHomeBinding
import com.okugata.sintaksys.ui.submit.SubmitActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            createNewButton.setOnClickListener(this@HomeActivity)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.create_new_button -> {
                val moveWithDataIntent = Intent(this@HomeActivity, SubmitActivity::class.java)
                moveWithDataIntent.putExtra(SubmitActivity.SUBMIT_TYPE, "CREATE")
                moveWithDataIntent.putExtra(SubmitActivity.SUBMIT_TEXT, "")
                startActivity(moveWithDataIntent)
            }
        }
    }
}
