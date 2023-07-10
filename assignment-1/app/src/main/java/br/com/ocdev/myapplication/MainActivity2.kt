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
    private var initialNumber = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnCount.setOnClickListener {
                txtCount.text = count(initialNumber).toString()
            }
        }

    }


    override fun onStop() {
        super.onStop()
        binding.txtCount.text = resetCount().toString()
    }

    private fun resetCount(): Int {
        initialNumber = 0
        return initialNumber
    }

    @Suppress("UNUSED_CHANGED_VALUE")
    private fun count(current: Int): Int {
        initialNumber = current
        return ++initialNumber
    }

}