package bensalcie.samples.koinpro.shouting

import androidx.lifecycle.ViewModel

class MainViewModel constructor(private val repository: ShoutRepository):ViewModel() {
    fun shoutTheName(firstName:String,lastName:String){
        repository.pickNameAndShoutItOut(firstName,lastName)
    }

    fun shoutTheName():String{
        return  "Ben Salcie"
    }

}