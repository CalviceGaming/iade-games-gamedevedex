package pt.iade.games.gamedevedex.models

import java.io.Serializable
import java.net.URI

data class ProjectAsset(
    val Description: String,
    val Asset: URI
):Serializable
