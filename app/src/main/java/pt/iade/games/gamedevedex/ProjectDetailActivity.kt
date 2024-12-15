package pt.iade.games.gamedevedex

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.models.ProjectAsset
import pt.iade.games.gamedevedex.models.ProjectAssetNotUri
import pt.iade.games.gamedevedex.models.Student
import pt.iade.games.gamedevedex.ui.components.ProjectDetail
import pt.iade.games.gamedevedex.ui.theme.GamedevedexTheme
import java.io.Serializable
import java.net.URI

class ProjectDetailActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val projectName = intent.getStringExtra("ProjectName")
        //val projectGroup = intent.getParcelableArrayExtra("ProjectMembers")
        enableEdgeToEdge()
        setContent {
            GamedevedexTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(Project().title)
                            },
                            colors = topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            )
                        )
                    }
                ){innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        ProjectDetail(
                            project = Project(),
                            projectAsset = ProjectDetail(),
                            assetList = ListofAss()
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GamedevedexTheme {
        Greeting("Android")
    }
}

fun Project(): Project {
    return Project(
        title = "Detective Ribbit",
        votes = 2,
        description = "This Game if very good and a lot of fun and as you can see this description is very very very long and very very very descriptive of the game.",
        id = 404,
        semester = 1,
        assets = listOf(
            URI.create("https://cdn.mobygames.com/screenshots/12341377-among-us-windows-calling-an-emergency-meeting.png"),
            URI.create("https://lutris.net/media/games/screenshots/ss_649e19ff657fa518d4c2b45bed7ffdc4264a4b3a.jpg")
        ),
        groupMembers = listOf(
            Student(
                id = 123,
                name = "João Pedro",
                biography = "Gambler addict, loves plinko and blackjack is 30000 euros in debt",
                mood = "Lucky",
                avatar = URI.create("https://media.gettyimages.com/photos/cristiano-ronaldo-of-portugal-poses-during-the-official-fifa-world-picture-id450555852?k=6&m=450555852&s=612x612&w=0&h=aUh0DVio_ubpFtCVvMv3WLR1MVPQji1sN5PDNKvHCT4=")
            )
        )
    )
}

fun ProjectDetail(): ProjectAssetNotUri {
    return ProjectAssetNotUri(
        Description = "",
        Asset = R.drawable.detectiveribbitlogo
    )
    }
fun ListofAss(): List<ProjectAssetNotUri>{
    return listOf(
        ProjectAssetNotUri(
            Description = "Ribbit him self",
            Asset = R.drawable.frog1
        ),
        ProjectAssetNotUri(
            Description = "Ribbit's room'",
            Asset = R.drawable.room
        ),
        ProjectAssetNotUri(
            Description = "Fly Mafia Photo",
            Asset = R.drawable.flymafiaphoto
        ),
        ProjectAssetNotUri(
            Description = "Spec Sheet",
            Asset = R.drawable.spec_thing
        ),
        ProjectAssetNotUri(
            Description = "Funny Pipe :D",
            Asset = R.drawable.funnyactivepipe
        ),
    )
}