/**
* execute "body" if app in debug mode
*/

inline fun debug(body: () -> Unit) {
	if (BuildConfig.DEBUG) body()
}