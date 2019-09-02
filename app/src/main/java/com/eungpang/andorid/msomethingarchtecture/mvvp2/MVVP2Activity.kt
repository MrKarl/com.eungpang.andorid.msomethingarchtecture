package com.eungpang.andorid.msomethingarchtecture.mvvp2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.eungpang.andorid.msomethingarchtecture.R;
import com.eungpang.andorid.msomethingarchtecture.databinding.ActivityMvvp2Binding
import com.eungpang.andorid.msomethingarchtecture.viewmodel.MVVPViewModel

class MVVP2Activity : AppCompatActivity() {
    private lateinit var mvvpViewModel: MVVPViewModel
    private lateinit var binding: ActivityMvvp2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvp2)
        binding.lifecycleOwner = this

        mvvpViewModel = ViewModelProviders.of(this).get(MVVPViewModel::class.java)
        binding.mvvpViewModel = mvvpViewModel
    }
}
