package com.moringa.android.g4saccesscsystem

import android.content.Context
import android.graphics.*
import android.graphics.Bitmap.CompressFormat
import android.graphics.Paint.Join
import android.util.AttributeSet
import android.util.Base64
import android.view.MotionEvent
import android.view.View
import android.widget.RelativeLayout
import com.moringa.android.g4saccesscsystem.ui.home.visitor.VisitorDetailsFragment
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import kotlin.jvm.internal.DefaultConstructorMarker
import kotlin.jvm.internal.Intrinsics

@Metadata(
    mv = [1, 4, 3],
    bv = [1, 0, 3],
    k = 1,
    d1 = ["\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0002-.B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\tJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001J\u0006\u0010\u001d\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012H\u0002J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%H\u0014J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0012H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"],
    d2 = ["Lcom/moringa/android/g4saccesscsystem/CanvasCapture;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "canvasCallBack", "Lcom/moringa/android/g4saccesscsystem/ui/home/visitor/VisitorDetailsFragment;", "view", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/moringa/android/g4saccesscsystem/ui/home/visitor/VisitorDetailsFragment;Landroid/view/View;)V", "bitmap", "Landroid/graphics/Bitmap;", "Lcom/moringa/android/g4saccesscsystem/CanvasCapture\$SurfaceCanvasCallBack;", "dirtyRect", "Landroid/graphics/RectF;", "imageEncoded", "", "lastTouchX", "", "lastTouchY", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "rlSignature", "Landroid/widget/RelativeLayout;", "captureCanvas", "", "v", "clear", "debug", "string", "expandDirtyRect", "historicalX", "historicalY", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "resetDirtyRect", "eventX", "eventY", "Companion", "SurfaceCanvasCallBack", "G4S_Access_C_System.app"]
)
class CanvasCapture(
    context: Context,
    attrs: AttributeSet?,
    canvasCallBack: VisitorDetailsFragment,
    view: View?
) :
    View() {
    private var bitmap: Bitmap? = null
    private val rlSignature: RelativeLayout? = null
    private var imageEncoded: String? = null
    private val paint: Paint
    private val path: Path
    private var lastTouchX = 0f
    private var lastTouchY = 0f
    private val canvasCallBack: SurfaceCanvasCallBack
    private val dirtyRect: RectF
    fun captureCanvas(v: View) {
        Intrinsics.checkNotNullParameter(v, "v")
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(v.width, v.height, Bitmap.Config.RGB_565)
        }
        val var10002 = bitmap
        Intrinsics.checkNotNull(var10002)
        val canvas = Canvas(var10002!!)
        v.draw(canvas)
        val baos = ByteArrayOutputStream()
        val var10000 = bitmap
        Intrinsics.checkNotNull(var10000)
        var10000!!.compress(CompressFormat.PNG, 20, baos as OutputStream)
        val b = baos.toByteArray()
        imageEncoded = Base64.encodeToString(b, 0)
        canvasCallBack.onCaptureCallBack(imageEncoded, bitmap, v)
    }

    fun clear() {
        path.reset()
        this.invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas")
        canvas.drawPath(path, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        Intrinsics.checkNotNullParameter(event, "event")
        val eventX = event.x
        val eventY = event.y
        return when (event.action) {
            0 -> {
                path.moveTo(eventX, eventY)
                lastTouchX = eventX
                lastTouchY = eventY
                true
            }
            1, 2 -> {
                resetDirtyRect(eventX, eventY)
                val historySize = event.historySize
                var i = 0
                while (i < historySize) {
                    val historicalX = event.getHistoricalX(i)
                    val historicalY = event.getHistoricalY(i)
                    expandDirtyRect(historicalX, historicalY)
                    path.lineTo(historicalX, historicalY)
                    ++i
                }
                path.lineTo(eventX, eventY)
                this.invalidate(
                    (dirtyRect.left - 2.5f).toInt(),
                    (dirtyRect.top - 2.5f).toInt(),
                    (dirtyRect.right + 2.5f).toInt(),
                    (dirtyRect.bottom + 2.5f).toInt()
                )
                lastTouchX = eventX
                lastTouchY = eventY
                true
            }
            else -> {
                debug("Ignored touch event: $event")
                false
            }
        }
    }

    private fun debug(string: String) {}
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

    @Metadata(
        mv = [1, 4, 3],
        bv = [1, 0, 3],
        k = 1,
        d1 = ["\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"],
        d2 = ["Lcom/moringa/android/g4saccesscsystem/CanvasCapture\$SurfaceCanvasCallBack;", "", "onCaptureCallBack", "", "base64Image", "", "bitmapImage", "Landroid/graphics/Bitmap;", "view", "Landroid/view/View;", "G4S_Access_C_System.app"]
    )
    interface SurfaceCanvasCallBack {
        fun onCaptureCallBack(var1: String?, var2: Bitmap?, var3: View?)
    }

    @Metadata(
        mv = [1, 4, 3],
        bv = [1, 0, 3],
        k = 1,
        d1 = ["\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"],
        d2 = ["Lcom/moringa/android/g4saccesscsystem/CanvasCapture\$Companion;", "", "()V", "HALF_STROKE_WIDTH", "", "STROKE_WIDTH", "G4S_Access_C_System.app"]
    )
    class Companion private constructor() {
        // $FF: synthetic method
        constructor(`$constructor_marker`: DefaultConstructorMarker?) : this() {}
    }

    companion object {
        private const val STROKE_WIDTH = 5.0f
        private const val HALF_STROKE_WIDTH = 2.5f
        val Companion = Companion(null as DefaultConstructorMarker?)
    }

    init {
        Intrinsics.checkNotNullParameter(context, "context")
        Intrinsics.checkNotNullParameter(canvasCallBack, "canvasCallBack")
        super(context, attrs)
        paint = Paint()
        path = Path()
        dirtyRect = RectF()
        paint.isAntiAlias = true
        paint.color = -16777216
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Join.ROUND
        paint.strokeWidth = 5.0f
        this.canvasCallBack = canvasCallBack
    }
}