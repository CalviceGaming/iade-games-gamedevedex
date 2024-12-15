package pt.iade.games.gamedevedex.models

import java.io.Serializable
import java.net.URI

data class Project(
    val id: Int,
    val title: String,
    var votes: Int,
    val assets: List<URI>,
    val description: String,
    val groupMembers: List<Student>,
    val semester: Int
):Serializable
