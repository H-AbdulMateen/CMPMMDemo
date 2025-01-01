package com.abdulmateen.cmpmmdemo.core.common.di


import com.abdulmateen.cmpmmdemo.core.network.di.networkModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null){
    startKoin {
        config?.invoke(this)
        modules(networkModule)
    }
}