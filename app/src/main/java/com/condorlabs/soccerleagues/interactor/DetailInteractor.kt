package com.condorlabs.soccerleagues.interactor

import com.condorlabs.soccerleagues.data.api.ApiClient
import com.condorlabs.soccerleagues.data.api.ApiService
import com.condorlabs.soccerleagues.data.model.TeamsResponse
import io.reactivex.observers.DisposableSingleObserver
import timber.log.Timber

class DetailInteractor(val detailInteractorInterface: DetailInteractorInterface) {
    val apiService: ApiService = ApiClient()

    fun getTeamById(id_team: String) {
        apiService.getTeamById(id_team).subscribeWith(object : DisposableSingleObserver<TeamsResponse>() {
            override fun onSuccess(value: TeamsResponse) {
                Timber.i("Consulta exitosa ${value.teams[0].strTeam}")
                detailInteractorInterface.onSuccess(value.teams[0])
            }

            override fun onError(e: Throwable) {
                Timber.i("Consulta erronea ${e.message}")
                detailInteractorInterface.onError(e.message!!)
            }
        })

    }
}
