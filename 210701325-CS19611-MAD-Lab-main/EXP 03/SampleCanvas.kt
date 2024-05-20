package com.example.shapes

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


class hello @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr)

{
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint:Paint=Paint()
        paint.setColor(Color.YELLOW)
        canvas.drawPaint(paint)
        paint.setColor(Color.RED)
        paint.setTextSize(50f)
        canvas.drawText("Circle",100f,100f,paint)
        canvas.drawCircle(200f,300f,150f,paint)
        paint.setColor(Color.GREEN)
        paint.setTextSize(50f)
        canvas.drawText("Rectangle",600f,100f,paint)
        canvas.drawRect(600f,150f,800f,500f,paint)
        paint.setColor(Color.BLUE)
        paint.setTextSize(50f)
        canvas.drawText("Square",100f,650f,paint)
        canvas.drawRect(100f,700f,300f,900f,paint)
        paint.setColor(Color.WHITE)
        canvas.drawText("Line",600f,650f,paint)
        canvas.drawLine(10f,10f,20f,20f,paint)






    }

}
