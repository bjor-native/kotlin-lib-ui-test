import libui.ktx.*

fun main() = appWindow(
    title = "Check list meeting room",
    width = 320,
    height = 240,
) {
    lateinit var cbRooms: Combobox
    val listMeetingRooms = listOf("Moscow", "Paris", "Madrid")
    vbox {
        group("Выбери переговорку") {
            cbRooms = combobox {
                listMeetingRooms.forEach {
                    item(it)
                }
                value = 0
            }
        }
        hbox {
            button("Enter") {
                action {
                    when (cbRooms.value) {
                        cbRooms.value -> windowCheck(listMeetingRooms.elementAt(cbRooms.value))
                    }
                }
            }
            button("Send report") {
                action {

                }
            }
        }
    }
}