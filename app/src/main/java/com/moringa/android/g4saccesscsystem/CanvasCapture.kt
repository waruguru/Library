package com.moringa.android.g4saccesscsystem

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Base64
import android.view.MotionEvent
import android.view.View
import android.widget.RelativeLayout
import com.moringa.android.g4saccesscsystem.ui.home.visitor.VisitorDetailsFragment
import java.io.ByteArrayOutputStream

class CanvasCapture(
    context: Context,
    attrs: AttributeSet?,
    canvasCallBack: VisitorDetailsFragment,
    view: View?
) :
    View(context, attrs) {
    private var bitmap: Bitmap? = null
    private val rlSignature: RelativeLayout? = null
    private var imageEncoded: String? = null
    private val paint = Paint()
    private val path = Path()
    private var lastTouchX = 0f
    private var lastTouchY = 0f
    private var canvasCallBack:SurfaceCanvasCallBack
    private val dirtyRect = RectF()

    /**
     * Capture canvas.
     *
     * @param v the v
     */
    fun captureCanvas(v: View) {
        // LoggerService.logDebug("log_tag", "Width: " + v.getWidth());
        //LoggerService.logDebug("log_tag", "Height: " + v.getHeight());
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(v.width, v.height, Bitmap.Config.RGB_565)
        }
        val canvas = Canvas(bitmap!!)
        v.draw(canvas)
        val baos = ByteArrayOutputStream()
        bitmap!!.compress(Bitmap.CompressFormat.PNG, 20, baos)
        val b = baos.toByteArray()
        imageEncoded = Base64.encodeToString(b, Base64.DEFAULT)
        canvasCallBack.onCaptureCallBack(imageEncoded, bitmap, v)
    }

    /**
     * Clear.
     */
    fun clear() {
        path.reset()
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawPath(path, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val eventX = event.x
        val eventY = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(eventX, eventY)
                lastTouchX = eventX
                lastTouchY = eventY
                return true
            }
            MotionEvent.ACTION_MOVE, MotionEvent.ACTION_UP -> {
                resetDirtyRect(eventX, eventY)
                val historySize = event.historySize
                var i = 0
                while (i < historySize) {
                    val historicalX = event.getHistoricalX(i)
                    val historicalY = event.getHistoricalY(i)
                    expandDirtyRect(historicalX, historicalY)
                    path.lineTo(historicalX, historicalY)
                    i++
                }
                path.lineTo(eventX, eventY)
            }
            else -> {
                debug("Ignored touch event: $event")
                return false
            }
        }
        invalidate(
            (dirtyRect.left - HALF_STROKE_WIDTH).toInt(),
            (dirtyRect.top - HALF_STROKE_WIDTH).toInt(),
            (dirtyRect.right + HALF_STROKE_WIDTH).toInt(),
            (dirtyRect.bottom + HALF_STROKE_WIDTH).toInt()
        )
        lastTouchX = eventX
        lastTouchY = eventY
        return true
    }

    private fun debug(string: String) {

        // LoggerService.logDebug("log_tag", string);
    }

    private fun expandDirtyRect(historicalX: Float, historicalY: Float) {
        if (historicalX < dirtyRect.left) {
            dirtyRect.left = historicalX
        } else if (historicalX > dirtyRect.right) {
            dirtyRect.right = historicalX
        }
        if (historicalY < dirtyRect.top) {
            dirtyRect.top = historicalY
        } else if (historicalY > dirtyRect.bottom) {
            dirtyRect.bottom = historicalY
        }
    }

    private fun resetDirtyRect(eventX: Float, eventY: Float) {
        dirtyRect.left = Math.min(lastTouchX, eventX)
        dirtyRect.right = Math.max(lastTouchX, eventX)
        dirtyRect.top = Math.min(lastTouchY, eventY)
        dirtyRect.bottom = Math.max(lastTouchY, eventY)
    }

    /**
     * The interface Surface canvas call back.
     */
    interface SurfaceCanvasCallBack {
        /**
         * On capture call back.
         *
         * @param base64Image the base 64 image
         * @param bitmapImage the bitmap image
         */
        fun onCaptureCallBack(
            base64Image: String?,
            bitmapImage: Bitmap?,
            view: View?
        )
    }

    companion object {
        private const val STROKE_WIDTH = 5f
        private const val HALF_STROKE_WIDTH = STROKE_WIDTH / 2
    }

    /**
     * Instantiates a new Canvas capture.
     *
     * @param context        the context
     * @param attrs          the attrs
     * @param canvasCallBack the canvas call back
     */
    init {
        paint.isAntiAlias = true
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeWidth = STROKE_WIDTH
        this@CanvasCapture.canvasCallBack = canvasCallBack
    }


}