package com.example.a24_02_paris.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.a24_02_paris.R
import com.example.a24_02_paris.model.PictureBean
import com.example.a24_02_paris.model.pictureList
import com.example.a24_02_paris.ui.theme._24_02_parisTheme

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SearchScreenPreview() {
    //Il faut remplacer NomVotreAppliTheme par le thème de votre application
    //Utilisé par exemple dans MainActivity.kt sous setContent {...}
    _24_02_parisTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            SearchScreen()
        }
    }
}

@Composable
fun SearchScreen() {
    Column(modifier =Modifier.background(Color.LightGray)) {
        PictureRowItem(data = pictureList[0])
        PictureRowItem(data = pictureList[1])
        PictureRowItem(data = pictureList[2])
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable //Composable affichant 1 PictureBean
fun PictureRowItem(modifier: Modifier = Modifier, data: PictureBean) {
    Row(
        modifier = modifier.background(Color.White).fillMaxWidth()
    ) {

        GlideImage(
            model = data.url,
            //Dans string.xml
            //contentDescription = getString(R.string.picture_of_cat),
            //En dur
            contentDescription = "une photo de chat",
            loading = placeholder(R.mipmap.ic_launcher_round), // Image de chargement
            // Image d'échec. Permet également de voir l'emplacement de l'image dans la Preview
            failure = placeholder(R.mipmap.ic_launcher),
            contentScale = ContentScale.Fit,
            //même autres champs qu'une Image classique
            modifier = Modifier.heightIn(max = 100.dp) //Sans hauteur il prendra tous l'écran
                .widthIn(max= 100.dp)
        )

        Column {
            Text(
                text = data.title,
                fontSize = 20.sp,
            )
            Text(
                text = data.longText.take(20) + "...",
                fontSize = 14.sp,
                color = Color.Blue,
            )
        }


    }

}