package com.xsota.unkorun

import com.badlogic.gdx.Game
import com.badlogic.gdx.Screen

class UnkoRun : Game() {
  val SCREEN_SIZE_WIDTH: Float = 800f
  val SCREEN_SIZE_HEIGHT: Float = 480f

  override fun create() {
    setScreen(GameScreen(this))
  }

  override fun render() {
    super.render()
  }

  override fun dispose() {
    super.dispose()
  }

  // screenの切り替え
  override fun setScreen(screen: Screen) {
    getScreen()?.dispose()

    super.setScreen(screen)
  }
}
