package com.condorlabs.soccerleagues.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.condorlabs.soccerleagues.ID_TEAM
import com.condorlabs.soccerleagues.R
import com.condorlabs.soccerleagues.data.model.Team
import com.condorlabs.soccerleagues.presenter.DetailPresenter
import com.condorlabs.soccerleagues.presenter.DetailPresenterInterface
import kotlinx.android.synthetic.main.activity_detail_team.*

class DetailTeamActivity : AppCompatActivity(), DetailViewInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)

        // Toolbar
        setSupportActionBar(detailActivity_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        getData(intent.getIntExtra(ID_TEAM,1))

    }

    private fun getData(id_team: Int){
        val presenter: DetailPresenterInterface = DetailPresenter(this)
        presenter.getTeamById(id_team.toString())
    }


    override fun setUpView(team: Team) {
        detailTeam_teamName.text = team.strTeam
        detailActivity_nameTeam.text = team.strTeam
        detailService_teamYear.text = team.intFormedYear.toString()
        detailService_teamDescription.text = team.strDescriptionEN

        Glide.with(this)
                .load(team.strTeamBadge)
                .into(detailActivity_logoTeam)
        Glide.with(this)
                .load(team.strTeamFanart1)
                .into(detailTeamBanner)

        Glide.with(this)
                .load(team.strTeamBadge)
                .into(detailTeam_logo)
        Glide.with(this)
                .load(team.strTeamJersey)
                .into(detailTeam_jersey)
    }

}
