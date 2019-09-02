package com.eungpang.andorid.msomethingarchtecture.viewmodel

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.eungpang.andorid.msomethingarchtecture.data.AppCount

class MVVPViewModel(application: Application) : AndroidViewModel(application) {
    val appCount = MutableLiveData<AppCount>()
    val pref: SharedPreferences

    init {
        // Load Count
        pref = PreferenceManager.getDefaultSharedPreferences(application.applicationContext)
        val countInt = pref.getInt("count", 0)

        val data = AppCount(countInt)
        appCount.value = data
    }

    // Business Logic
    fun increaseAppCount() {
        val previousAppCount: AppCount = appCount.value!!
        previousAppCount.count = previousAppCount.count + 1

        // set the value with synchronous way
//        appCount.value = previousAppCount

        // set the value with asynchronous way
         appCount.postValue(previousAppCount)
    }
}