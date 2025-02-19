package com.cursoandroid.retrofitcomposeapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GameApplication: Application() {
}

// este archivo le indicará al manifest que nustra aplicación usará inyección de dependencias con Hilt

// Debemos declarar este archivo en el  Manifest:
//  <application
// android:name="GameApplication"