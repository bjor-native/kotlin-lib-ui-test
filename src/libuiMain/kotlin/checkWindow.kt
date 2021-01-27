import libui.ktx.*

fun windowCheck(name: String) = appWindow(
    title = name,
    width = 320,
    height = 240,

    ) {
    vbox {
        lateinit var checkList: Combobox
        val listProblems = listOf("Codec", "Camera", "Network", "Cable management")

        checkList = combobox {
            listProblems.forEach {
                item(it)
            }
            value = 0
        }
        hbox {
            val btnWorks = button("Works") {
                action {
                }
            }
            val btnNWorks = button("Not works") {
                action {
                }
            }

            checkList.action {
                if (checkList.value == 3) {
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