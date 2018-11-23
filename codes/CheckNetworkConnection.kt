import android.content.Context
import android.net.ConnectivityManager

internal fun isConnected(context: Context): Boolean {
    val connetivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return connetivityManager.activeNetworkInfo?.isConnectedOrConnecting ?: false
}