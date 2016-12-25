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

class GameScreen(val game: UnkoRun) : Screen {
  val stage : Stage = Stage(FillViewport(game.SCREEN_SIZE_WIDTH, game.SCREEN_SIZE_HEIGHT))
  val jumpUnkoImage: Image = Image(Texture("unchi.png"))
  val enemy = Image(Texture("unchi.png"))

  override fun show() {
    Gdx.input.inputProcessor = stage
    jumpUnkoImage.setPosition(100f,0f)

    jumpUnkoImage.addListener(object : ClickListener(){
      override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
        if (jumpUnkoImage.hasActions()){
          super.touchDown(event, x, y, pointer, button)
        }

        val up = Actions.moveBy(0f, 144f, 0.3f, Interpolation.pow2)
        val down = Actions.moveBy(0f, -144f, 0.3f, Interpolation.pow2)

        val jump = Actions.sequence()
        jump.addAction(up)
        jump.addAction(down)

        jumpUnkoImage.addAction(jump)
        return super.touchDown(event, x, y, pointer, button)
      }
    })



    enemy.setPosition(game.SCREEN_SIZE_WIDTH,0f)
    val toLeft = Actions.moveBy(-(game.SCREEN_SIZE_WIDTH), 0f, 3f, Interpolation.linear)

    enemy.addAction(toLeft)

    stage.addActor(enemy)
    stage.addActor(jumpUnkoImage)
  }

  override fun render(delta: Float) {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    stage.act(Gdx.graphics.deltaTime)
    stage.draw()



    if ((enemy.x.toInt() in jumpUnkoImage.x.toInt()-3..jumpUnkoImage.x.toInt()+3) && jumpUnkoImage.y <= enemy.y){
      Gdx.app.log("hit","うんこ")
    }
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
