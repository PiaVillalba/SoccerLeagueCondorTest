package com.condorlabs.soccerleagues.interactor

import com.condorlabs.soccerleagues.data.model.Team
import com.condorlabs.soccerleagues.data.model.TeamsResponse

interface DetailInteractorInterface {
    fun onSuccess(team: Team)
    fun onError(mensaje: String)
}