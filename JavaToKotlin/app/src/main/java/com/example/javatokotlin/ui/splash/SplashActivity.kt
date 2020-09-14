package com.example.javatokotlin.ui.splash

import androidx.lifecycle.ViewModelProviders
import com.example.javatokotlin.ui.base.BaseActivity
import com.example.javatokotlin.ui.main.MainActivity
import com.example.javatokotlin.ui.note.NoteActivity.Companion.start

class SplashActivity : BaseActivity<Boolean?, SplashViewState>() {

    override val viewModel: SplashViewModel by lazy {
        ViewModelProviders.of(this).get(SplashViewModel::class.java)
    }

    override val layoutRes = null

    override fun onResume() {
        super.onResume()
        viewModel.requestUser()
    }

    override fun renderData(data: Boolean?) {
        data?.takeIf { it }?.let {
            startMainActivity()
        }
    }

    private fun startMainActivity(){
        MainActivity.start(this)
        finish()
    }

}

