package com.condorlabs.soccerleagues.presenter

interface MainPresenterInterface {
    fun getTeamsByLeague(id_league: String)
    fun getLeagueById(id_league: String)
}