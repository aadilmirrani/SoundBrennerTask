package com.soundbrenner.colorwheeltask.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.soundbrenner.colorwheeltask.R
import com.soundbrenner.colorwheeltask.databinding.ActivityMainBinding
import com.soundbrenner.colorwheeltask.ui.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    val maViewModel: MainActivityViewModel by viewModels()

    binding.cvMa.colorChangeListener = { rgb ->
      Log.i("111222", rgb.toString())
      binding.cvMa1.setRgb(1, 1, 1)
    }
  }
}