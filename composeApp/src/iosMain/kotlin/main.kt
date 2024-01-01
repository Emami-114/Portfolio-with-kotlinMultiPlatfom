import androidx.compose.ui.window.ComposeUIViewController
import org.emami.portfolio.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
