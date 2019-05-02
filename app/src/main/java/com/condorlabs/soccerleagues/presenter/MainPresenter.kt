package com.condorlabs.soccerleagues.presenter

import com.condorlabs.soccerleagues.data.model.League
import com.condorlabs.soccerleagues.data.model.TeamsResponse
import com.condorlabs.soccerleagues.interactor.MainInteractor
import com.condorlabs.soccerleagues.interactor.MainInteractorInterface
import com.condorlabs.soccerleagues.view.activities.MainViewInterace

class MainPresenter (val view: MainViewInterace) : MainInteractorInterface,MainPresenterInterface {
    val interactor: MainInteractor = MainInteractor(this)

    override fun onSuccessLeague(league: League) {
        view.setUpHeader(league)
    }



    override fun onSuccessTeams(teamsResponse: TeamsResponse) {
        view.setUpRecyclerView(teamsResponse)
    }

    override fun onError(mensaje: String) {

    }

    override fun getTeamsByLeague(id_league: String) {
        interactor.getTeamsByLeague(id_league)
    }

    override fun getLeagueById(id_league: String) {
        interactor.getLeagueById(id_league)
    }


}