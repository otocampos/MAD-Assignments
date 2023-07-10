package br.com.ocdev.myapplication

import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.ocdev.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnCount.setOnClickListener {
                count++
                txtCount.text = count.toString()
            }
        }

    }

    override fun onStop() {
        super.onStop()
        count = 0
        binding.txtCount.text = count.toString()
    }


}