package bensalcie.samples.koinpro.di

import bensalcie.samples.koinpro.main.MainActivity
import org.koin.core.qualifier.named
import org.koin.dsl.module

val activityModule = module {
    scope<MainActivity> {
        scoped (qualifier = named("hello-main")) {
            "Hello there am in MainActivity "
        }
        scoped (qualifier = named("hello-second")) {
            "Hello there am in MainActivity but second string "
        }
    }
}