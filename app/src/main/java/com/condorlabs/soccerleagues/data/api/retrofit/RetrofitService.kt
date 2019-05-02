package com.condorlabs.soccerleagues.data.api.retrofit

import com.condorlabs.soccerleagues.DETAIL_LEAGUE
import com.condorlabs.soccerleagues.TEAMS_SEARCH
import com.condorlabs.soccerleagues.TEAM_SEARCH
import com.condorlabs.soccerleagues.data.model.LeaguesResponse
import com.condorlabs.soccerleagues.data.model.Team
import com.condorlabs.soccerleagues.data.model.TeamsResponse
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.*

/**
 * Interface with all the Web Services methods
 */
interface RetrofitService {


    @GET(TEAMS_SEARCH)
    fun getTeamsByLeague(
            @Query ("id") id_league: String
    ): Single<TeamsResponse>

    @GET(TEAM_SEARCH)
    fun getTeamById(
            @Query ("id") id_team: String
    ): Single<TeamsResponse>

    @GET(DETAIL_LEAGUE)
    fun getLeagueById(
            @Query ("id") id_league: String
    ): Single<LeaguesResponse>


}