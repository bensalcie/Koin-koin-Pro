package bensalcie.samples.koinpro.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import bensalcie.samples.koinpro.shouting.MainViewModel
import bensalcie.samples.koinpro.shouting.MyApi
import bensalcie.samples.koinpro.shouting.NameRepositoryImp
import bensalcie.samples.koinpro.shouting.ShoutRepository
import bensalcie.samples.koinpro.ui.theme.KoinProTheme
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.GlobalContext.get
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

class MainActivity : ComponentActivity(), AndroidScopeComponent{
    override val scope: Scope
       by activityScope()

    private val myviewmodel by viewModel<MainViewModel>()
    private val hello by inject<String> (named("hello-main"))

    //Imediate injection

    //val myApi = get<MyApi>()
    //    lazy injection
    //val myApi by inject<MyApi> ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            KoinProTheme {
                val vmodel = getViewModel<MainViewModel>()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(username=  myviewmodel.shoutTheName()
                    )
                }
            }
        }
    }


}

@Composable
fun Greeting(username:String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $username}!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KoinProTheme {
        Greeting(username = "Ben Salcie Test")
    }
}