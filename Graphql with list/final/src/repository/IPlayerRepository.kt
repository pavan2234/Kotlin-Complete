package com.raywenderlich.kgraphqlfootball.repository

import com.raywenderlich.kgraphqlfootball.model.Player
import com.raywenderlich.kgraphqlfootball.model.PlayerInput
import com.raywenderlich.kgraphqlfootball.model.Position

interface IPlayerRepository {
    fun createPlayer(player: Player)
    fun deletePlayer(uid: String)
    fun listPlayers() : List<Player>
    fun filterPlayersByPosition(position: Position): List<Player>
    fun filterPlayersByTeam(team: String): List<Player>
    fun updatePlayer(uid: String, playerInput: PlayerInput)

}