package com.phongbm.dsr

import android.app.Application
import dev.b3nedikt.restring.Restring
import dev.b3nedikt.reword.RewordInterceptor
import dev.b3nedikt.viewpump.ViewPump

/**
 * Created by PhongBM on 06/18/2021
 */

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Restring.init(this)
        ViewPump.init(RewordInterceptor)
    }

}