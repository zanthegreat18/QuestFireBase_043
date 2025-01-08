package com.tugas.firebass15

import android.app.Application
import com.tugas.firebass15.di.AppContainer
import com.tugas.firebass15.di.MahasiswaContainer

class MahasiswaApplications: Application() {
    lateinit var container: MahasiswaContainer
    override fun onCreate() {
        super.onCreate()
        container= MahasiswaContainer()
    }
}