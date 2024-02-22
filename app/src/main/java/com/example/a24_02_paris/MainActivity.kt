package com.example.a24_02_paris

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.a24_02_paris.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    //version findViewById
    val et  by lazy { findViewById<EditText>(R.id.et) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btValidate.setOnClickListener {
            if (binding.rbLike.isChecked) {
                et.setText(binding.rbLike.text)
            }
            else if (binding.rbDislike.isChecked) {
                et.setText(binding.rbDislike.text)
            }

            binding.iv.setImageResource(R.drawable.baseline_flag_24)
        }

        binding.btCancel.setOnClickListener(this)


    }


    override fun onStart() {
        super.onStart()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onClick(v: View?) {
        if(v === binding.btCancel){
            binding.rg.clearCheck()
            et.setText("")

            startActivity(Intent(this, ComposeExActivity::class.java))
        }
    }

}