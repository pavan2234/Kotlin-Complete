
package com.raywenderlich.kgraphqlfootball

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.raywenderlich.kgraphqlfootball.model.Player
import com.raywenderlich.kgraphqlfootball.model.PlayerInput
import com.raywenderlich.kgraphqlfootball.model.Position
import com.raywenderlich.kgraphqlfootball.repository.IPlayerRepository
import com.raywenderlich.kgraphqlfootball.repository.PlayerRepository
import java.lang.Exception
import java.util.*


fun SchemaBuilder.schemaValue() {

    val repository: IPlayerRepository = PlayerRepository()

    mutation("createPlayer") {
        description = "Create a new player"
        resolver { playerInput: PlayerInput ->
            try {
                val uid = UUID.randomUUID().toString()
                val player = Player(uid, playerInput.name, playerInput.team, playerInput.position)
                repository.createPlayer(player)
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    mutation("deletePlayer") {
        description = "Delete a player by his identifier"
        resolver { uid: String ->
            try {
                repository.deletePlayer(uid)
                true
            } catch (e: Exception) {
                false
            }

        }
    }

    mutation("updatePlayer") {
        description = "Update a player by his identifier"
        resolver { uid: String, playerInput: PlayerInput ->
            try {
                repository.updatePlayer(uid, playerInput)
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    query("playersByTeam") {
        description = "Retrieve all the players by his team"
        resolver { team: String ->
            try {
                repository.filterPlayersByTeam(team)
            } catch (e: Exception) {
                emptyList<Player>()
            }
        }
    }

    query("playersByPosition") {
        description = "Retrieve all the players by his position"
        resolver { position: Position ->
            try {
                repository.filterPlayersByPosition(position)
            } catch (e: Exception) {
                emptyList<Player>()
            }
        }
    }

    query("players") {
        description = "Retrieve all players"
        resolver { ->
            try {
                repository.listPlayers()
            } catch (e: Exception) {
                emptyList<Player>()
            }
        }
    }

    inputType<PlayerInput>{
        description = "The input of the player without the identifier"
    }
    type<Player>{
        description = "Player object with the attributes name, team, position and identifier"
    }
    enum<Position>()
}
