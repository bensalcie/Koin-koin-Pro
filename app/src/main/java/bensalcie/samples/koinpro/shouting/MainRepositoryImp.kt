package bensalcie.samples.koinpro.shouting

class MainRepositoryImp constructor(private val api: MyApi): MainRepository {
    override fun getMemes() {
        return api.callApi()
    }


}