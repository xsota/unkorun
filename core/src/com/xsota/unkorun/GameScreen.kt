package com.xsota.unkorun

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Interpolation
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.viewport.FillViewport


/**
 * Created by sota on 2016/11/27.
 */

class GameScreen(game: UnkoRun) : Screen {
  val stage : Stage = Stage(FillViewport(game.SCREEN_SIZE_WIDTH, game.SCREEN_SIZE_HEIGHT))
  val jumpUnkoImage: Image = Image(Texture("unchi.png"))

  override fun show() {
    Gdx.input.inputProcessor = stage
    jumpUnkoImage.setPosition(100f,0f)

    jumpUnkoImage.addListener(object : ClickListener(){
      override fun clicked(event: InputEvent?, x: Float, y: Float) {
        if (jumpUnkoImage.hasActions()){
          return
        }

        val up = Actions.moveBy(0f, 144f, 0.3f, Interpolation.pow2)
        val down = Actions.moveBy(0f, -144f, 0.3f, Interpolation.pow2)

        val jump = Actions.sequence()
        jump.addAction(up)
        jump.addAction(down)

        jumpUnkoImage.addAction(jump)
      }
    } )

    stage.addActor(jumpUnkoImage)
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
