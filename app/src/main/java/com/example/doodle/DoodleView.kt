package com.example.doodle

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat

private const val STROKE_WIDTH = 12f

class DoodleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr:Int =0
):View(context,attrs,defStyleAttr) {

    private lateinit var extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap

    private val backgroundColor = ResourcesCompat.getColor(resources,R.color.colorBackground,null)
    private val drawColor = ResourcesCompat.getColor(resources, R.color.colorPaint, null)
    // Set up the paint with which to draw.
    private val paint = Paint().apply {
        color = drawColor
        // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        strokeWidth = STROKE_WIDTH // default: Hairline-width (really thin)
    }

    init{

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        Log.e("Doodle","Size has changed")
        super.onSizeChanged(w, h, oldw, oldh)
        //First recycle the old bitmap before creating a new one to prevent memory leaks
        if(::extraBitmap.isInitialized) extraBitmap.recycle()
        //Create a new bitmap
        extraBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888)
        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawColor(backgroundColor)

    }

    override fun onDraw(canvas: Canvas?) {
        Log.e("Doodle","OnDraw")
        super.onDraw(canvas)
        canvas!!.drawBitmap(extraBitmap,0F,0F,null)
    }


}