package bensalcie.samples.koinpro.shouting

interface ShoutRepository {
    fun pickNameAndShoutItOut(firstName:String,lastName:String):String
    fun pickFirstNameAndShoutItOut(firstName:String):String
}