package com.condorlabs.soccerleagues.presenter

import com.condorlabs.soccerleagues.data.model.Team
import com.condorlabs.soccerleagues.interactor.DetailInteractor
import com.condorlabs.soccerleagues.interactor.DetailInteractorInterface
import com.condorlabs.soccerleagues.view.activities.DetailViewInterface

class DetailPresenter (val view: DetailViewInterface) : DetailInteractorInterface,DetailPresenterInterface {
    val interactor: DetailInteractor = DetailInteractor(this)
    override fun onSuccess(team: Team) {
        view.setUpView(team)
    }

    override fun onError(mensaje: String) {
    }

    override fun getTeamById(id_team: String) {
        interactor.getTeamById(id_team)
    }





}