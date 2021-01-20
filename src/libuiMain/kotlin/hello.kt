import libui.ktx.*

fun main() = appWindow(
    title = "Check list meeting room",
    width = 320,
    height = 240,
) {
    vbox {
        lateinit var cbRooms: Combobox
        val listMeetingRooms = listOf("Moscow", "Paris", "Madrid")

        form {
            cbRooms = combobox {
                listMeetingRooms.forEach {
                    item(it)
                }
            }
        }
        button("Enter") {
            action {
                when (cbRooms.value) {
                    cbRooms.value -> windowCheck(listMeetingRooms.elementAt(cbRooms.value))
                }
            }
        }
    }
}