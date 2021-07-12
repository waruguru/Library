package com.moringa.android.g4saccesscsystem

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.jvm.internal.Intrinsics

@RunWith(AndroidJUnit4::class)
//@Metadata(
//    mv = [1, 4, 3],
//    bv = [1, 0, 3],
//    k = 1,
//    d1 = ["\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"],
//    d2 = ["Lcom/moringa/android/g4saccesscsystem/ExampleInstrumentedTest;", "", "()V", "useAppContext", "", "G4S_Access_C_System.app"]
//)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        val var10000 = InstrumentationRegistry.getInstrumentation()
        Intrinsics.checkNotNullExpressionValue(
            var10000,
            "InstrumentationRegistry.getInstrumentation()"
        )
        val appContext = var10000.targetContext
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext")
        Assert.assertEquals("com.moringa.android.g4saccesscsystem", appContext.packageName)
    }
}