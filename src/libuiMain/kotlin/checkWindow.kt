import libui.ktx.*

fun windowCheck(name: String) = appWindow(
    title = name,
    width = 320,
    height = 240,

    ) {
    vbox {
        lateinit var checkList: Combobox
        val listProblems = listOf("Codec", "Camera", "Network")

        form {
            checkList = combobox {
                listProblems.forEach {
                    item(it)
                }
            }
        }
        hbox {
            button("Works") {
                action {

                }
            }
            button("Not works") {
                action {

                }
            }
            button("Send report") {
                action {

                }
            }
        }
    }
    onClose {
        true
    }
}