package com.jbs.qrcodesgr.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.jbs.qrcodesgr.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //region #Variables
    private val activityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mainViewModel: MainViewModel by viewModels()
    //endregion

    //region #InBuilt Methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)
        activityMainBinding.lifecycleOwner = this
        activityMainBinding.mainViewModel = mainViewModel
        activityMainBinding.clickListener = this

        // Initialize Views and Variables
        initialization()
    }
    //endregion

    //region #Custom Methods
    /**
     * Initialize views and variables
     */
    private fun initialization() {
        // Empty
    }
}
