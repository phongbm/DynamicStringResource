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

        setTexts()

        binding.btnChangeStringResource.setOnClickListener {
            changeStringResource()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun getDelegate() = appCompatDelegate

    fun setTexts() {
        binding.txtTextByCode.setText(R.string.common_android)
    }

    private fun changeStringResource() {
        val enStrings = mapOf(
            "common.hello" to "Hello-en",
            "common.android" to "Android-en"
        )
        Restring.putStrings(Locale.US, enStrings)

        val viStrings = mapOf(
            "common.hello" to "Hello-vi",
            "common.android" to "Android-vi"
        )
        val vnLocale = Locale("vi", "VN")
        Restring.putStrings(vnLocale, viStrings)

        Reword.reword(binding.root)
        setTexts()
    }

}