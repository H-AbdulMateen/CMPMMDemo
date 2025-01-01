package com.abdulmateen.cmpmmdemo.core.network.di

import com.abdulmateen.cmpmmdemo.core.network.ktor.HttpClientFactory
import org.koin.dsl.module

val networkModule = module {
    single { HttpClientFactory.create(get()) }
}