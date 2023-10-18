package com.aregyan.compose.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.aregyan.compose.R
import com.aregyan.compose.ui.components.NoNetwork

@Composable
fun DetailsScreen() {
    val viewModel = hiltViewModel<DetailsViewModel>()
    val uiState = viewModel.uiState

    if (uiState.offline) {
        NoNetwork()
    } else {
        Box(Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(dimensionResource(id = com.intuit.sdp.R.dimen._16sdp))
                    .padding(dimensionResource(id = com.intuit.sdp.R.dimen._16sdp))
            ) {
                AsyncImage(
                    modifier = Modifier.size(dimensionResource(id = com.intuit.sdp.R.dimen._100sdp)),
                    model = uiState.detail.avatar,
                    contentDescription = null
                )
                Column {
                    Text(
                        modifier = Modifier.padding(start = dimensionResource(id = com.intuit.sdp.R.dimen._16sdp)),
                        text = uiState.detail.name.orEmpty(),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = dimensionResource(id = com.intuit.ssp.R.dimen._12ssp).value.sp
                    )
                    Text(
                        modifier = Modifier.padding(
                            start = dimensionResource(id = com.intuit.sdp.R.dimen._16sdp),
                            top = dimensionResource(id = com.intuit.sdp.R.dimen._16sdp)
                        ),
                        text = uiState.formattedUserSince,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = dimensionResource(id = com.intuit.ssp.R.dimen._12ssp).value.sp
                    )
                    Text(
                        modifier = Modifier.padding(start = dimensionResource(id = com.intuit.sdp.R.dimen._16sdp), top = dimensionResource(id = com.intuit.sdp.R.dimen._16sdp)),
                        text = uiState.detail.location.orEmpty(),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = dimensionResource(id = com.intuit.ssp.R.dimen._12ssp).value.sp
                    )
                }
            }

            Row(Modifier.fillMaxSize()) {
                Spacer(Modifier.weight(1f))
                Column(
                    Modifier
                        .width(dimensionResource(id = com.intuit.sdp.R.dimen._10sdp))
                        .fillMaxHeight()
                        .background(Color.Red)) {

                }
                Spacer(Modifier.weight(1f))
            }
        }

    }
}