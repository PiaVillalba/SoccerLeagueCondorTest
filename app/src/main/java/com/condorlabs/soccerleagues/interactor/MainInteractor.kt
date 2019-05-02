package com.condorlabs.soccerleagues.interactor

import com.condorlabs.soccerleagues.data.api.ApiClient
import com.condorlabs.soccerleagues.data.api.ApiService
import com.condorlabs.soccerleagues.data.model.LeaguesResponse
import com.condorlabs.soccerleagues.data.model.TeamsResponse

import io.reactivex.observers.DisposableSingleObserver
import timber.log.Timber

class MainInteractor(val mainInteractorInterface: MainInteractorInterface) {
    val apiService: ApiService = ApiClient()

    fun getTeamsByLeague(id_league: String) {
        apiService.getTeamsByLeague(id_league).subscribeWith(object : DisposableSingleObserver<TeamsResponse>() {
            override fun onSuccess(value: TeamsResponse) {
                Timber.i("Consulta exitosa ${value.teams[1].strTeam}")
                mainInteractorInterface.onSuccessTeams(value)

            }

            override fun onError(e: Throwable) {
                Timber.i("Consulta erronea ${e.message}")
                    mainInteractorInterface.onError(e.message!!)
            }
        })

    }

    fun getLeagueById(id_league: String){
        apiService.getLeagueById(id_league).subscribeWith(object : DisposableSingleObserver<LeaguesResponse>() {
            override fun onSuccess(value: LeaguesResponse) {
                Timber.i("Consulta exitosa ${value.leagues[0].strLeague}")
                mainInteractorInterface.onSuccessLeague(value.leagues[0])
            }

            override fun onError(e: Throwable) {
                Timber.i("Consulta erronea ${e.message}")
                mainInteractorInterface.onError(e.message!!)
            }
        })
    }

}