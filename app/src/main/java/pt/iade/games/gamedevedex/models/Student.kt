package pt.iade.games.gamedevedex.models

import java.io.Serializable
import java.net.URI

data class Student(
    val id: Int,
    val name: String,
    val avatar: URI,
    val biography: String,
    val mood: String
):Serializable
