package com.condorlabs.soccerleagues.data.api

import com.condorlabs.soccerleagues.data.api.retrofit.RetrofitClient
import com.condorlabs.soccerleagues.data.model.LeaguesResponse
import com.condorlabs.soccerleagues.data.model.TeamsResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ApiClient : RetrofitClient(), ApiService {

    override fun getLeagueById(id_league: String): Single<LeaguesResponse> {
        return getApiService()!!.getLeagueById(id_league)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getTeamsByLeague(id_league: String): Single<TeamsResponse> {
        return getApiService()!!.getTeamsByLeague(id_league)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getTeamById(id_team: String): Single<TeamsResponse> {
        return getApiService()!!.getTeamById(id_team)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}