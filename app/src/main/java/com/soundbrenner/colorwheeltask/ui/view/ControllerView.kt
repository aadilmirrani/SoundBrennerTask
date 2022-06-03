package com.soundbrenner.colorwheeltask.ui.view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import com.soundbrenner.colorwheeltask.R
import com.soundbrenner.colorwheeltask.util.*

open class ControllerView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

  private val thumbWheel = ThumbWheel()
  private val hsvColor = HsvColor(value = 1f)

  var rgb
    get() = hsvColor.rgb
    set(rgb) {
      hsvColor.rgb = rgb
      hsvColor.set(value = 1f)
      invalidate()
    }

  var cvRadius
    get() = thumbWheel.radius
    set(value) {
      thumbWheel.radius = value
      invalidate()
    }

  var cvColor
    get() = thumbWheel.thumbColor
    set(value) {
      thumbWheel.thumbColor = value
      invalidate()
    }

  init {
    parseAttributes(context, attrs)
  }

  private fun parseAttributes(context: Context, attrs: AttributeSet?) {
    val array = context.obtainStyledAttributes(
      attrs,
      R.styleable.ControllerView,
      0,
      R.style.ControllerViewDefaultStyle
    )
    readCvRadius(array)
    readCvColor(array)
    array.recycle()
  }

  private fun readCvRadius(array: TypedArray) {
    cvRadius = array.getDimensionPixelSize(R.styleable.ControllerView_cv_radius, 0)
  }

  private fun readCvColor(array: TypedArray) {
    cvColor = array.getColor(R.styleable.ColorWheel_cw_thumbColor, 0)
  }

  fun setRgb(r: Int, g: Int, b: Int) {
    rgb = Color.rgb(r, g, b)
  }

  override fun onDraw(canvas: Canvas) {
    drawThumb(canvas)
  }

  private fun drawThumb(canvas: Canvas) {
    val hSpace = width - paddingLeft - paddingRight
    val vSpace = height - paddingTop - paddingBottom

    val x = (paddingLeft + hSpace / 2).toFloat()
    val y = (paddingTop + vSpace / 2).toFloat()

    thumbWheel.indicatorColor = hsvColor.rgb
    thumbWheel.setCoordinates(x, y)
    thumbWheel.draw(canvas)
  }
}