package com.condorlabs.soccerleagues.data.api

import com.condorlabs.soccerleagues.data.model.LeaguesResponse
import com.condorlabs.soccerleagues.data.model.TeamsResponse
import io.reactivex.Single

interface ApiService {
    fun getTeamsByLeague(id_league: String): Single<TeamsResponse>
    fun getTeamById(id_team: String): Single<TeamsResponse>
    fun getLeagueById(id_league: String): Single<LeaguesResponse>
}

