package com.example.materialdesign.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.materialdesign.R
import com.example.materialdesign.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val vBinding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var musicFragment: MainFragment
        var photoFragment: PhotoFragment
        var videoFragment: VideoFragment
        var settingsFragment: SettingsFragment

        musicFragment = MainFragment()
        openFragment(musicFragment)

        vBinding.bnv.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.musicPage -> {
                    musicFragment = MainFragment()
                    openFragment(musicFragment)
                    snackbarShow()
                }
                R.id.photoPage -> {
                    photoFragment = PhotoFragment()
                    openFragment(photoFragment)
                }
                R.id.videoPage -> {
                    videoFragment = VideoFragment()
                    openFragment(videoFragment)
                }
                R.id.settingsPage -> {
                    settingsFragment = SettingsFragment()
                    openFragment(settingsFragment)
                }
            }
            true
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    private fun snackbarShow() {
        val contextView = findViewById<View>(R.id.musicPage)
        Snackbar.make(contextView, R.string.no_connection, Snackbar.LENGTH_SHORT)
            .setAnchorView(R.id.bnv)
            .setAction(R.string.retry) { viewAction ->
                Snackbar.ANIMATION_MODE_FADE.apply {
                    Snackbar.make(
                        viewAction,
                        R.string.list_update,
                        Snackbar.LENGTH_SHORT
                    )
                        .setAnchorView(R.id.bnv)
                        .show()
                }
            }
            .show()
    }

}