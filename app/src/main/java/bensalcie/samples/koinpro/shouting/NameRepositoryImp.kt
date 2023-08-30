package bensalcie.samples.koinpro.shouting

class NameRepositoryImp: ShoutRepository {
    override fun pickNameAndShoutItOut(firstName: String, lastName: String): String {
        return  "$firstName $lastName is the Shouted name!!!!!!"
    }

    override fun pickFirstNameAndShoutItOut(firstName: String): String {
        return "Hi $firstName , I am Shouting your name"
    }

}