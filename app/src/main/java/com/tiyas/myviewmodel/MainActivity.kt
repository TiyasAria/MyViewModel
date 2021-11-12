package com.tiyas.myviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.tiyas.myviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  activityMainBinding: ActivityMainBinding
//    private lateinit var  viewModel: MainViewModel
//    nah disini kita bisa menyederhanakan kode untuk memanggil viewModel dg delegation by viewModels()
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

//        kita pasangkan vieModelnya disini
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResult()

        activityMainBinding.btnCalculate.setOnClickListener {
            val width = activityMainBinding.edWidth.text.toString()
            val height = activityMainBinding.edHeight.text.toString()
            val length = activityMainBinding.edLength.text.toString()

            when{
                width.isEmpty() -> {
                    activityMainBinding.edWidth.error = "Masih Kosong"
                }
                height.isEmpty() -> {
                    activityMainBinding.edHeight.error = "Masih Kosong"
                }
                length.isEmpty() -> {
                    activityMainBinding.edLength.error = "MasihKosong"
                }
                else -> {
                    viewModel.calculate(width, height, length)
                    displayResult()
                }
            }
        }
    }

    private fun displayResult() {
        activityMainBinding.tvResult.text = viewModel.result.toString()
    }
}