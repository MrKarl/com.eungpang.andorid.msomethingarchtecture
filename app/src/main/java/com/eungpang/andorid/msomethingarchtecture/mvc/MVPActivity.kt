package com.eungpang.andorid.msomethingarchtecture.mvc

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.eungpang.andorid.msomethingarchtecture.R
import com.eungpang.andorid.msomethingarchtecture.data.AppCount
import kotlinx.android.synthetic.main.activity_mvp.*

class MVPActivity : AppCompatActivity() {

    lateinit var pref: SharedPreferences
    lateinit var appCount: AppCount

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)

        // Load Count
        pref = PreferenceManager.getDefaultSharedPreferences(this)
        val countInt = pref.getInt("count", 0)
        appCount = AppCount(countInt)

        // Sync UI
        tv.text = appCount.count.toString()

        btn.setOnClickListener {
            // Business Logic
            this@MVPActivity.increaseAppCount()

            // Sync UI
            tv.text = appCount.count.toString()
        }

    }

    override fun onDestroy() {
        pref.edit().apply {
            putInt("count", appCount.count)
            apply()
        }

        super.onDestroy()
    }

    fun increaseAppCount() {
        appCount.count = appCount.count + 1
    }
}
