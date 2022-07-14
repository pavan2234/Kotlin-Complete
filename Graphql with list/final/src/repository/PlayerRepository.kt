package com.raywenderlich.kgraphqlfootball.repository

import com.raywenderlich.kgraphqlfootball.data.players
import com.raywenderlich.kgraphqlfootball.model.Player
import com.raywenderlich.kgraphqlfootball.model.PlayerInput
import com.raywenderlich.kgraphqlfootball.model.Position

class PlayerRepository : IPlayerRepository {

    override fun createPlayer(player: Player) {
        players.add(player)
    }

    override fun deletePlayer(uid: String) {
        players.removeIf { it.uid == uid }
    }

    override fun listPlayers(): List<Player> {
        return players
    }

    override fun filterPlayersByPosition(position: Position): List<Player> {
        return players.filter { it.position == position }
    }

    override fun filterPlayersByTeam(team: String): List<Player> {
        return players.filter { it.team == team }
    }

    override fun updatePlayer(uid: String, playerInput: PlayerInput) {
        players.find { it.uid == uid }?.apply {
            name = playerInput.name
            position = playerInput.position
            team = playerInput.team
        }
    }

}