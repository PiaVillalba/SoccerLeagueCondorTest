package com.condorlabs.soccerleagues.view.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.condorlabs.soccerleagues.BaseApp
import com.condorlabs.soccerleagues.ID_SPANISH_LEAGUE
import com.condorlabs.soccerleagues.ID_TEAM
import com.condorlabs.soccerleagues.R
import com.condorlabs.soccerleagues.data.model.League
import com.condorlabs.soccerleagues.data.model.TeamsResponse
import com.condorlabs.soccerleagues.presenter.MainPresenter
import com.condorlabs.soccerleagues.presenter.MainPresenterInterface
import com.condorlabs.soccerleagues.view.adapter.TeamAdapter
import com.condorlabs.soccerleagues.view.dialogs.SelectLeagueDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_header_main.*
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class MainActivity : AppCompatActivity(), MainViewInterace, SelectLeagueDialog.SelectLeagueInterface {

    private lateinit var mApp: BaseApp
    private val presenter: MainPresenterInterface = MainPresenter(this)
    private lateinit var idLeague: String
    private val mDialogFilter: SelectLeagueDialog by lazy {
        SelectLeagueDialog(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Global
        mApp = applicationContext as BaseApp
        idLeague = ID_SPANISH_LEAGUE
        mainActivity_recyclerView.setHasFixedSize(true)
        getData(idLeague)
        mainActivity_filterIcon.setOnClickListener { addFilter() }
    }

    private fun getData(id_league: String){
        presenter.getTeamsByLeague(id_league)
        presenter.getLeagueById(id_league)
    }


    override fun setUpRecyclerView(listTeams: TeamsResponse) {
        var adapter = TeamAdapter(listTeams) {
            openDetailTeamActivity(it)
        }
        mainActivity_recyclerView.adapter = adapter
    }

    override fun setUpHeader(league: League) {
        mainActivity_leagueName.text = league.strLeague
        Glide.with(this)
                .load(league.strFanart1)
                .into(mainActivity_leagueImage)
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    private fun openDetailTeamActivity(idTeam: Int) {
        val intentDetailActivity = Intent(this, DetailTeamActivity::class.java)
        intentDetailActivity.putExtra(ID_TEAM, idTeam)
        startActivity(intentDetailActivity)
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out)
    }

    private fun addFilter(){
        mDialogFilter.show()
        mDialogFilter.setCanceledOnTouchOutside(false)
    }

    override fun selectLeague(id_league: String) {
        getData(id_league)
    }
}
