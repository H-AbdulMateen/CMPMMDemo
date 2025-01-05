package com.abdulmateen.cmpmmdemo

import android.app.Application
import com.abdulmateen.cmpmmdemo.di.initKoin
import org.koin.android.ext.koin.androidContext

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MyApplication)
        }
    }

}