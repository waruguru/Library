package com.moringa.android.g4saccesscsystem.utils

import android.view.View

fun View.click(listener: (View) -> Unit) {
    setOnClickListener(listener)
}

