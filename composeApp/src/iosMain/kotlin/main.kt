import androidx.compose.ui.window.ComposeUIViewController
import com.eacipher.KMPApp.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
