package bensalcie.samples.koinpro.di

import bensalcie.samples.koinpro.shouting.MainRepository
import bensalcie.samples.koinpro.shouting.MainRepositoryImp
import bensalcie.samples.koinpro.shouting.MainViewModel
import bensalcie.samples.koinpro.shouting.MyApi
import bensalcie.samples.koinpro.shouting.NameRepositoryImp
import bensalcie.samples.koinpro.shouting.ShoutRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModules = module {
    single<ShoutRepository> { NameRepositoryImp() }
    //One instance accross app lifecycle.

    single {
        Retrofit.Builder().baseUrl("https://google.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }

    //Inform that we are providing it as an abstraction.
    //single <MainRepository>
    single <MainRepository>{ MainRepositoryImp(get()) }
    //Create unique instance for every request.

    //factory {  }


    // Di for Viewmodels.
    viewModel {
        MainViewModel(get())
    }
}