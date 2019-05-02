package com.condorlabs.soccerleagues.interactor

import com.condorlabs.soccerleagues.data.model.League
import com.condorlabs.soccerleagues.data.model.TeamsResponse

interface MainInteractorInterface {
    fun onSuccessTeams(teamsResponse: TeamsResponse)
    fun onError(mensaje: String)
    fun onSuccessLeague(league: League)
}