import libui.ktx.*
import platform.CoreServices.pUserName
import platform.Foundation.NSFullUserName
import platform.Foundation.NSUserName
import platform.darwin.time_value
import platform.darwin.time_value_t
import platform.darwin.user
import platform.posix.FILE
import platform.posix.timezone_
import platform.posix.user_from_uid
import utils.writeAllLines
import utils.writeAllText
import kotlin.math.absoluteValue
import kotlin.time.ExperimentalTime
import kotlin.time.hours

fun windowCheck(name: String) = appWindow(
    title = name,
    width = 400,
    height = 150,

    ) {
    vbox {
        vbox {
            lateinit var checkList: Combobox
            val listProblems = listOf(
                "Camera", "Codec", "TV", "TMALL Pad",
                "Phone", "HDMI", "Sound via HDMI", "Network", "Microphone", "Cable management"
            )

            group("Check items from the list") {
                checkList = combobox {
                    listProblems.forEach {
                        item(it)
                    }
                    value = 0
                }
            }
            writeAllText("checklist.txt", "---Meeting room: $name-----------------\n")
            val btnWorks = button("Works") {
                action {
                    writeAllText(
                        "checklist.txt",
                        "${listProblems.elementAt(checkList.value)} - ${this@button.text}. Checked by ${NSFullUserName()} \n"
                    )
                }
            }
            val btnNWorks = button("Not works") {
                action {
                    writeAllText("checklist.txt", "$name|works")
                }
            }

            checkList.action {
                if (checkList.value == listProblems.lastIndex) {
                    btnWorks.text = "Clean"
                    btnNWorks.text = "Not clean"
                } else {
                    btnWorks.text = "Works"
                    btnNWorks.text = "Not works"
                }
            }
        }
    }
    onClose {
        true
    }
}