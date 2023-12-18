package com.example.lifecycle

import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lifecycle.ui.theme.LifeCycleTheme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    val T = "Estado";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LifeCycleTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                Greeting("Brave, new world.")
                Log.d(T,"estoy creandolo");

                }
            }
        }
        fun Calc (op:()->Unit) {
            op()
        }
        Calc{
            Log.d("Calculo","No hago nada :P")
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(T,"estoy arrancando");
    }
    override fun onResume() {
        super.onResume()
        Log.d(T,"estoy onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.d(T,"estoy en Pausa");
    }

    override fun onStop() {
        super.onStop()
        Log.d(T,"estoy parado");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(T,"estoy muerto :(");
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
        Column {
            Text(
                fontSize = 30.sp,
                color = Color(255,204,255),
                text = "Hello. $name",
                modifier = modifier
            )
            Box(modifier = Modifier){
            Image(
                painter = painterResource(id = R.drawable.nana ),
                contentDescription ="icono")
            Image(
                painter = painterResource(id = R.drawable.shi ),
                contentDescription ="icon",
                modifier = Modifier.padding(35.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LifeCycleTheme {
        Greeting("How are you?")
    }
}