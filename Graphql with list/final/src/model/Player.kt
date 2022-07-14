
package com.raywenderlich.kgraphqlfootball.model

enum class Position {
    GK, // Goalkeeper
    DEF, // Defender
    MID, // Midfielder
    FRW  // Forward
}

// Player class
data class Player(var uid: String, var name: String, var team: String, var position: Position)

// PlayerInput
data class PlayerInput(val name: String, val team: String, val position: Position)