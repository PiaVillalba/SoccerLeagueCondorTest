package com.condorlabs.soccerleagues.view.activities

import com.condorlabs.soccerleagues.data.model.League
import com.condorlabs.soccerleagues.data.model.TeamsResponse

interface MainViewInterace {
    fun setUpRecyclerView(listTeams: TeamsResponse)
    fun setUpHeader(league: League)
}