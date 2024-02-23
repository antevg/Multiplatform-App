package com.eacipher.KMPApp

import com.eacipher.KMPApp.di.getAllSharedModules
import org.koin.core.context.startKoin

fun doInitKoin(){
    startKoin {
        modules(getAllSharedModules())
    }
}