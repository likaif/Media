package com.example.exoplayerdemo

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.OptIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.RawResourceDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.exoplayerdemo.ui.theme.ExoPlayerDemoTheme
import com.mkrdeveloper.videoplayercompose.VideoPlayerExo


class MainActivity : ComponentActivity() {
    private val player: ExoPlayer? = null
    private val playerView: PlayerView? = null
    @OptIn(UnstableApi::class) override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExoPlayerDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    GreetingImage(message = stringResource(R.string.happy_birthday_sam),
//                        from = stringResource(R.string.signature_text),
//                        modifier = Modifier.padding(8.dp))
//                    val videoUrl = "R.raw.sample"
                    val videoUrl = "android.resource://" + getPackageName() + "/" + "R.raw.sample"
//                    val videoUrl = RawResourceDataSource.buildRawResourceUri(R.raw.sample)
//                         Uri.parse("android.resource://com.mkrdeveloper.videoplayercompose/raw/sample")
//                    val videoUrl =
//                        "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"

                    Column {
                        /*YouTubePlayer(
                            youtubeVideoId = "kShAS6aafOU",
                            lifecycleOwner = LocalLifecycleOwner.current
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        VideoPlayer(videoUri =videoUri)*/
                        VideoPlayerExo(videoUrl =videoUrl)
                    }
                }
            }
        }
    }
}

//@Composable
//fun GreetingPlayer(context: Context, message: String, from: String, modifier: Modifier) {
//    val player = ExoPlayer.Builder(context).build()
//    val playerView: PlayerView
//    playerView.player = player
//    // Build the media item.
//        val mediaItem = MediaItem.fromUri(videoUri)
    // Set the media item to be played.
//        player.setMediaItem(mediaItem)
//    // Prepare the player.
//        player.prepare()
//    // Start the playback.
//        player.play()
//}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true, name = "test")
@Composable
fun GreetingPreview() {
    ExoPlayerDemoTheme {
        GreetingImage(
            message = stringResource(R.string.happy_birthday_sam),
            from = stringResource(R.string.signature_text),
            modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}