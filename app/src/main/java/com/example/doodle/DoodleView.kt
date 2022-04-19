package com.example.doodle

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class DoodleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr:Int =0
):View(context,attrs,defStyleAttr) {

    init{

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }


}