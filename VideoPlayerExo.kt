package com.mkrdeveloper.videoplayercompose

import androidx.annotation.OptIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.RawResourceDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.exoplayerdemo.R
import com.example.exoplayerdemo.VideoSurface

@OptIn(UnstableApi::class) @Composable
fun VideoPlayerExo(
    videoUrl: String
) {
    val context = LocalContext.current
    val player = ExoPlayer.Builder(context).build().apply {
        setMediaItem(MediaItem.fromUri(RawResourceDataSource.buildRawResourceUri(R.raw.sample)))
//        setMediaItem(MediaItem.fromUri(videoUrl))
    }

//    val playerView = PlayerView(context)
    val playWhenReady by rememberSaveable {
        mutableStateOf(true)
    }

//    playerView.player = player
    VideoSurface(modifier = Modifier.fillMaxSize(), exoPlayer = player)
    LaunchedEffect(player) {
        player.prepare()
        player.playWhenReady = playWhenReady
    }

//    AndroidView(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//            .clip(RoundedCornerShape(16.dp)),
//        factory = {
//            playerView
//        })

}