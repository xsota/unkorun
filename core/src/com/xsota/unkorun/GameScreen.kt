package com.xsota.unkorun

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.FillViewport


/**
 * Created by sota on 2016/11/27.
 */

class GameScreen(game: UnkoRun) : Screen {
  val stage : Stage = Stage(FillViewport(game.SCREEN_SIZE_WIDTH, game.SCREEN_SIZE_HEIGHT))

  override fun show() {
    Gdx.input.inputProcessor = stage
  }

  override fun render(delta: Float) {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    stage.act(Gdx.graphics.deltaTime)
    stage.draw()
  }

  override fun resize(width: Int, height: Int) {
    stage.viewport.update(width, height, true)
  }

  override fun pause() {

  }

  override fun resume() {

  }

  override fun hide() {

  }

  override fun dispose() {

  }
}
