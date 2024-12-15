package pt.iade.games.gamedevedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import pt.iade.games.gamedevedex.R
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.models.ProjectAsset
import pt.iade.games.gamedevedex.models.ProjectAssetNotUri
import pt.iade.games.gamedevedex.models.Student
import java.net.URI

@Composable
fun ProjectDetail(
    project: Project,
    projectAsset: ProjectAssetNotUri,
    assetList: List<ProjectAssetNotUri>
){
    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Image(
                painter = painterResource(projectAsset.Asset),
                contentDescription = ""
            )
            Box(modifier = Modifier.fillMaxWidth()
                .border(2.dp, Color.Gray)){
                Row {
                    Text(
                        text = project.votes.toString(),
                        fontSize = 17.sp,
                        color = Color(255, 0, 0),
                    )

                    Text(
                        text = project.description,
                        fontSize = 17.sp,
                        color = Color(0, 0, 0),
                        modifier = Modifier.padding(start = 50.dp)
                    )
                }
            }
                var i = 0
                Column {
                    while (i < project.groupMembers.size) {
                        Box(modifier = Modifier.border(2.dp, Color.Gray)
                            .fillMaxWidth()){
                        Row(horizontalArrangement = Arrangement.spacedBy(30.dp)) {
                            Column {
                                AsyncImage(
                                    model = project.groupMembers[i].avatar.toString(),
                                    placeholder = painterResource(R.drawable.placeholder_cover_image),
                                    contentDescription = ""
                                )
                                Text(text = project.groupMembers[i].mood,
                                    fontSize = 17.sp,
                                    color = Color(255, 223, 0),
                                )
                            }
                            Column (Modifier.padding(end = 10.dp)){
                                Text(text = project.groupMembers[i].name,
                                    fontSize = 25.sp,
                                    color = Color(0, 0, 0),
                                    modifier =  Modifier.align(Alignment.CenterHorizontally))
                                Text(text = project.groupMembers[i].biography,
                                    fontSize = 15.sp,
                                    color = Color(0, 0, 0),
                                    modifier = Modifier.padding(top = 15.dp)
                                )
                            }
                        }
                            }
                        i++
                    }
                }
            var i2 = 0
            while (i2 < assetList.size){
                Box(modifier = Modifier.fillMaxWidth()){
                    Row( modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center ) {
                        Column() {
                            Image(
                                painter = painterResource(assetList[i2].Asset),
                                contentDescription = ""
                            )
                            Text(
                                text = assetList[i2].Description,
                                fontSize = 25.sp,
                                color = Color(0, 0, 0),
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                    }
                }
                i2++
            }
        }
    }
}

@Composable
@Preview
fun PreviewProjectDetail(){
    ProjectDetail(project = Project(
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
                biography = "Love playing Valorant. Currently thinking of switching courses.",
                mood = "Lucky",
                avatar = URI.create("https://media.gettyimages.com/photos/cristiano-ronaldo-of-portugal-poses-during-the-official-fifa-world-picture-id450555852?k=6&m=450555852&s=612x612&w=0&h=aUh0DVio_ubpFtCVvMv3WLR1MVPQji1sN5PDNKvHCT4=")
            )
        )
    ),
        projectAsset = ProjectAssetNotUri(
            Description = "",
            Asset = R.drawable.detectiveribbitlogo
        ),
        assetList = listOf(
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
    )
}