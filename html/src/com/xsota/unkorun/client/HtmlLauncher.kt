package com.xsota.unkorun.client

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.backends.gwt.GwtApplication
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration
import com.xsota.unkorun.UnkoRun

class HtmlLauncher : GwtApplication() {

    override fun getConfig(): GwtApplicationConfiguration {
        return GwtApplicationConfiguration(480, 320)
    }

    override fun createApplicationListener(): ApplicationListener {
        return UnkoRun()
    }
}