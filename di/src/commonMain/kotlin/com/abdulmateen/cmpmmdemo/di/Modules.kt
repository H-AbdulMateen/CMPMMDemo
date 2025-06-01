package com.abdulmateen.cmpmmdemo.di

import com.abdulmateen.cmpmmdemo.core.network.ktor.HttpClientFactory
import com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.data.network.ktor.KtorUserDataSource
import com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.data.network.ktor.RemoteUserDataSource
import com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.data.repository.LoginRepositoryImpl
import com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.domain.LoginRepository
import com.abdulmateen.cmpmmdemo.feature.auth.presentation.login.presentation.LoginViewModel
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.data.network.ktor.KtorProductsDataSource
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.data.network.ktor.RemoteProductsDataSource
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.data.repository.ProductRepositoryImpl
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.domain.ProductRepository
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.presentation.ProductListViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModelOf

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorProductsDataSource).bind<RemoteProductsDataSource>()
    singleOf(::ProductRepositoryImpl).bind<ProductRepository>()
    singleOf(::KtorUserDataSource).bind<RemoteUserDataSource>()
    singleOf(::LoginRepositoryImpl).bind<LoginRepository>()

    viewModelOf(::ProductListViewModel)
    viewModelOf(::LoginViewModel)


}