package com.phongbm.dsr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.ViewPumpAppCompatDelegate
import com.phongbm.dsr.databinding.ActivityMainBinding
import dev.b3nedikt.restring.Restring
import dev.b3nedikt.reword.Reword
import java.util.*

/**
 * Created by PhongBM on 06/18/2021
 */

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    private val appCompatDelegate: AppCompatDelegate by lazy {
        ViewPumpAppCompatDelegate(
            baseDelegate = super.getDelegate(),
            baseContext = this,
            wrapContext = { baseContext -> Restring.wrapContext(baseContext) }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChangeStringResource.setOnClickListener {
            changeStringResource()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun getDelegate() = appCompatDelegate

    private fun changeStringResource() {
        val strings = mapOf(
            Pair("common.hello", "Hello World")
        )
        Restring.putStrings(Locale.US, strings)
        Reword.reword(binding.root)
    }

}