package com.example.a24_02_paris.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.a24_02_paris.R
import com.example.a24_02_paris.model.MainViewModel
import com.example.a24_02_paris.ui.theme._24_02_parisTheme

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DetailScreenPreview() {
    _24_02_parisTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            DetailScreen(1)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable //id du PictureBean à afficher
fun DetailScreen(idPicture: Int, navController: NavHostController? = null , viewModel : MainViewModel = viewModel()){

    val picture = viewModel.myList.find { it.id == idPicture }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = picture?.title ?: "Pas de donnée",
            fontSize = 36.sp,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.fillMaxWidth()
        )

        if(picture != null) {
            GlideImage(
                model = picture?.url,
                //Dans string.xml
                //contentDescription = getString(R.string.picture_of_cat),
                //En dur
                contentDescription = "une photo de chat",
                loading = placeholder(R.mipmap.ic_launcher_round), // Image de chargement
                // Image d'échec. Permet également de voir l'emplacement de l'image dans la Preview
                failure = placeholder(R.mipmap.ic_launcher),
                contentScale = ContentScale.Fit,
                //même autres champs qu'une Image classique
                modifier = Modifier
                    .heightIn(max = 100.dp) //Sans hauteur il prendra tous l'écran
                    .widthIn(max = 100.dp)
            )
        }

        Text(
            text = picture?.longText ?: "Pas de donnée",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.size(16.dp))

        Button(
            onClick = { navController?.popBackStack() },
            contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
            modifier = Modifier
                .padding(8.dp)
                .align(CenterHorizontally)
        ) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "Localized description",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Retour")
        }


    }


}
