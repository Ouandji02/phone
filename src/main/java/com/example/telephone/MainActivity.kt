package com.example.telephone

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.telephone.ui.Routes.BottomGraph
import com.example.telephone.ui.Routes.GlobalNavigation
import com.example.telephone.ui.presentation.RecentCallComposable
import com.example.telephone.ui.theme.TelephoneTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TelephoneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val statePermission = rememberPermissionState(permission = android.Manifest.permission.CALL_PHONE)
                    val lifecycleOwner = LocalLifecycleOwner.current
                    DisposableEffect(key1 = lifecycleOwner) {
                        val eventObservable = LifecycleEventObserver { _, event ->
                            when (event) {
                                Lifecycle.Event.ON_START -> {
                                    statePermission.launchPermissionRequest()
                                }
                                else -> {}
                            }
                        }
                        lifecycleOwner.lifecycle.addObserver(eventObservable)
                        onDispose {
                            lifecycleOwner.lifecycle.removeObserver(eventObservable)
                        }
                    }
                    when {
                        statePermission.hasPermission -> Toast.makeText(this, "j'ai la permission d'appel", Toast.LENGTH_LONG).show()
                        else -> Toast.makeText(this, "j'ai pas la permission d'appel", Toast.LENGTH_LONG).show()
                    }
                    GlobalNavigation()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TelephoneTheme {
        Greeting("Android")
    }
}