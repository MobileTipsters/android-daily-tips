/* Sometimes we may face "name conflicts" 
* while importing API with same name/qualifier
* Kotlin allows you to rename your imports to fix the conflicts
* and also shorten your API names/qualifiers 
* instead of using full name/qualifier :)
*/
import android.os.Process as AndroidProcess
import java.lang.Process as JavaProcess

// Example usage of android.os.Process API
fun useAndroidProcess() {
    val myUid = AndroidProcess.myUid()
    println("My current UID: $myUid")
}

// Example usage of java.lang.Process API
fun useJavaProcess() {
    val cmdStr = arrayOf("sh", "-c", "echo Hello i'm sir mordred :)")
    val p: JavaProcess = Runtime.getRuntime().exec(cmdStr)
    p.waitFor()
}