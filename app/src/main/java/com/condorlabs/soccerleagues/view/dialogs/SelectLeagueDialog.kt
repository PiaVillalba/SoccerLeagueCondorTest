package com.condorlabs.soccerleagues.view.dialogs

import android.content.Context
import android.view.View
import com.condorlabs.soccerleagues.ID_ITALIAN_LEAGUE
import com.condorlabs.soccerleagues.ID_PREMIER_LEAGUE
import com.condorlabs.soccerleagues.ID_SPANISH_LEAGUE
import com.condorlabs.soccerleagues.R
import com.flyco.animation.BounceEnter.BounceBottomEnter
import com.flyco.animation.SlideExit.SlideBottomExit
import com.flyco.animation.ZoomExit.ZoomOutExit
import com.flyco.dialog.widget.base.BaseDialog
import kotlinx.android.synthetic.main.dialog_select_league.*
import timber.log.Timber

class SelectLeagueDialog(context: Context) : BaseDialog<SelectLeagueDialog>(context) {

    /**
     * Member Variables
     */
    private lateinit var mInterface: SelectLeagueInterface

    override fun onCreateView(): View {
        widthScale(1f)
        showAnim(BounceBottomEnter())

        dismissAnim(ZoomOutExit())
        val inflate = View.inflate(mContext, R.layout.dialog_select_league, null)

        // Interface
        mInterface = mContext as SelectLeagueInterface

        return inflate
    }

    override fun onBackPressed() {
        super.onBackPressed()
        dismissAnim(SlideBottomExit())
        dismiss()
    }

    override fun setUiBeforShow() {
        dialog_italianLeague.setOnClickListener {
            mInterface.selectLeague(ID_ITALIAN_LEAGUE)
            dismissAnim(SlideBottomExit())
            dismiss()
        }

        dialog_premierLeague.setOnClickListener{
            mInterface.selectLeague(ID_PREMIER_LEAGUE)
            dismissAnim(SlideBottomExit())
            dismiss()
        }

        dialog_spanishLeague.setOnClickListener {
            mInterface.selectLeague(ID_SPANISH_LEAGUE)
            dismissAnim(SlideBottomExit())
            dismiss()
        }
    }

    /**
     * Interface for handling the ok action
     */
    interface SelectLeagueInterface {
        fun selectLeague(id_league: String)
    }
}