package com.tiyas.myviewmodel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
//    kelas mainViewModel itu digunakan untuk memisahlan logic san UI nya , ini
//    kita berikan untuk logicnya dulu
    var result = 0

    fun calculate(width : String, height : String, length : String){
        result = width.toInt() * height.toInt() * length.toInt()
    }
}