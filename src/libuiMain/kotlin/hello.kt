import libui.ktx.*
import utils.readAllText

fun main() = appWindow(
    title = "Check list meeting room",
    width = 400,
    height = 150,
) {
    lateinit var cbRooms: Combobox
    val listMeetingRooms = listOf(
        "Moscow", "New York", "Shanghai", "Paris", "London", "Madrid", "Beijing", "Alibaba",
        "Ural-1", "Ural-2", "Jason Liu", "CEO Dmitry", "Vladivostok", "Irkutsk", "Novosibirsk", "Kazan",
        "Tagil", "Sochi", "St.Peterburg", "Murmansk"
    )
    vbox {
        vbox {
            group("Choose a meeting room") {
                cbRooms = combobox {
                    listMeetingRooms.forEach {
                        item(it)
                    }
                    value = 0
                }
            }
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
            button("Show log") {
                action {

                }
            }
        }
    }
}