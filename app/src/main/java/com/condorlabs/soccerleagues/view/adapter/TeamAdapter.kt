package com.condorlabs.soccerleagues.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.condorlabs.soccerleagues.R
import com.condorlabs.soccerleagues.data.model.Team
import com.condorlabs.soccerleagues.data.model.TeamsResponse
import kotlinx.android.synthetic.main.item_team.view.*

class TeamAdapter(private val mTeamsList: TeamsResponse,
                  private val mListener: (Int) -> Unit ) : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_team, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mTeamsList.teams.size
    }

    override fun onBindViewHolder(holder: TeamAdapter.ViewHolder, position: Int) {
        holder.bind(mTeamsList.teams[position], mListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Team, mListener: (Int) -> Unit) = with(itemView) {

            itemTeam_name.text = item.strTeam
            itemTeam_stadiumName.text = item.strStadium
            if (item.strTeamBadge != null || item.strTeamBadge == "") {
                var requestOptions = RequestOptions()
                requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(10))
                Glide.with(itemTeam_badge_iv.context)
                        .load(item.strTeamBadge)
                        .apply(requestOptions)
                        .into(itemTeam_badge_iv)
            }


            itemTeam_temDetail_iv.setOnClickListener { mListener(item.idTeam) }

        }
    }
}