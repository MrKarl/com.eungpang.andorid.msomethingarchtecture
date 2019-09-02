package com.eungpang.andorid.msomethingarchtecture.mvvp1;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.eungpang.andorid.msomethingarchtecture.R
import com.eungpang.andorid.msomethingarchtecture.data.AppCount
import com.eungpang.andorid.msomethingarchtecture.viewmodel.MVVPViewModel
import kotlinx.android.synthetic.main.activity_mvvp1.*

class MVVP1Activity : AppCompatActivity() {
    private lateinit var mvvpViewModel: MVVPViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvp1)

        mvvpViewModel = ViewModelProviders.of(this).get(MVVPViewModel::class.java)

        // Business Logic Linking
        btn.setOnClickListener {
            mvvpViewModel.increaseAppCount()
        }

        // Sync UI
        mvvpViewModel.appCount.observe(this, Observer<AppCount> { appCount: AppCount? ->
            if (appCount == null) {
                return@Observer
            }

            tv.text = appCount.count.toString()
        })
    }
}
