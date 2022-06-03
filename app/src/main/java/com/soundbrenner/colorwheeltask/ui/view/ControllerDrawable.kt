package com.soundbrenner.colorwheeltask.ui.view

import android.graphics.Canvas
import android.graphics.Paint
import com.soundbrenner.colorwheeltask.util.ensureWithinRange

internal class ControllerDrawable {

  private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply { strokeWidth = 1f }
  private var x = 0f
  private var y = 0f

  var indicatorColor = 0
  var radius = 0

  var colorCircleScale = 0f
    set(value) { field = ensureWithinRange(value, 0f, 1f) }

  fun draw(canvas: Canvas) {
    drawColorIndicator(canvas)
  }

  private fun drawColorIndicator(canvas: Canvas) {
    val colorIndicatorCircleRadius = radius * colorCircleScale

    paint.color = indicatorColor
    paint.style = Paint.Style.FILL
    canvas.drawCircle(x, y, colorIndicatorCircleRadius, paint)
  }
}