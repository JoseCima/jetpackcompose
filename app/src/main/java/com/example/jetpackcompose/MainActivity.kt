package com.example.jetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackcomposeTheme


private val mensajitos : List<miMensaje> = listOf(
    miMensaje("Hola 1", "Soy José Cima Soy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José Cima"),
    miMensaje("Hola 2", "Soy José Cima Soy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José Cima"),
    miMensaje("Hola 3", "Soy José Cima Soy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José Cima"),
    miMensaje("Hola 4", "Soy José Cima Soy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José Cima"),
    miMensaje("Hola 5", "Soy José Cima Soy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José Cima"),
    miMensaje("Hola 6", "Soy José Cima Soy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José Cima"),
    miMensaje("Hola 7", "Soy José Cima Soy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José Cima"),
    miMensaje("Hola 8", "Soy José Cima Soy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José Cima"),
    miMensaje("Hola 9", "Soy José Cima Soy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José Cima"),
    miMensaje("Hola 10", "Soy José Cima Soy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José CimaSoy José Cima")
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            //Themes
            JetpackcomposeTheme() {
                misMensajes(mensajitos)
            }
            //elementos composables

        }
    }
}

data class miMensaje(val titulo: String, val body: String)

@Composable
fun miComponente(mensaje: miMensaje){
    Row(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(8.dp)) {
        miImagen()
        misTexts(mensaje)
    }
}

@Composable
fun miImagen(){
    Image(
        painterResource(id = R.drawable.ic_launcher_foreground),
        "Mi imagen de prueba",
        modifier = Modifier
            .clip(CircleShape)
            .size(64.dp)
            .background(MaterialTheme.colors.primary)
    )
}
@Composable
fun misMensajes(mensajes: List<miMensaje>){
    LazyColumn(){
        items(mensajes){
            mensaje ->  miComponente(mensaje = mensaje)
        }
    }
}

@Composable
fun misTexts(mensaje: miMensaje){

    var expanded by remember{ mutableStateOf(false)}
    Column(Modifier.padding(start = 8.dp).clickable{
       expanded = !expanded
    } ){
        miTexto(text = mensaje.titulo, MaterialTheme.colors.primary, MaterialTheme.typography.subtitle1)
        Spacer( Modifier.height(16.dp))
        miTexto(text = mensaje.body, MaterialTheme.colors.onBackground, MaterialTheme.typography.subtitle2, lines = if(expanded) Int.MAX_VALUE else 1)


    }
}

//Señala que es un elemento grafico
@Composable
fun miTexto(text: String, color: Color, style: TextStyle, lines:Int = Int.MAX_VALUE){
    Text(text, color =  color, style = style, maxLines = lines)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComposes(){
    JetpackcomposeTheme {
        //Añadiendo un scroll
        val scrollstate = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(scrollstate)){
                misMensajes(mensajitos)
        }
    }
}
