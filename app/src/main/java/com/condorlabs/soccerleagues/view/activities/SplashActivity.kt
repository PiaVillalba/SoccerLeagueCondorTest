package com.condorlabs.soccerleagues.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.condorlabs.soccerleagues.R
import kotlinx.android.synthetic.main.activity_splash.*
import android.content.Intent
import android.os.Handler


class SplashActivity : AppCompatActivity() {

    private val mWaitHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        lottieAnimationView.imageAssetsFolder = "assets/"

        splashDuration()


    }

    private fun splashDuration(){
        mWaitHandler.postDelayed(Runnable {

            try {
                goMainActivity()
            } catch (ignored: Exception) {
                ignored.printStackTrace()
            }
        }, 4000)
    }

    private fun goMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}

