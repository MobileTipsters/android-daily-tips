package com.raqun.kotlinext

import android.os.Build

/**
 * execute "func" if current version is grater than or equal to given version
 */
inline fun supportsVersion(ver: Int, func: () -> Unit) {
    if (Build.VERSION.SDK_INT >= ver) {
        func.invoke()
    }
}