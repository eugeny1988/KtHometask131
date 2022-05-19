val seconds: Int = 33333
val oneMinute = 60
val oneHour = 3600
val oneDay = oneHour * 24
val back = "назад"
fun main() {
    print(agoToText(seconds))
}

fun agoToText(time: Int): String {
    return when (time) {
        in 0..oneMinute - 1 -> "только что"
        in oneMinute..oneHour - 1 -> minutesEnding(time)
        in oneHour..oneDay - 1 -> hoursEnding(time)
        in oneDay..oneDay * 2 - 1 -> "сегодня"
        in oneDay * 2..oneDay * 3 - 1 -> "вчера"
        else -> "давно"
    }
}

fun minutesEnding(number: Int): String {
    val minutes = number / 60
    if (number in 5..20) return "$minutes минут $back"
    else
        return when (minutes.mod(10)) {
            0, in 5..9 -> "$minutes минут $back"
            1 -> "$minutes минуту $back"
            else -> "$minutes минуты $back"
        }
}

fun hoursEnding(number: Int): String {
    val hours = number / 3600
    if (hours in 5..20) return "$hours часов $back"
    else
        return when (hours.mod(10)) {
            0, in 5..9 -> "$hours часов $back"
            1 -> "$hours час $back"
            else -> "$hours часа $back"
        }
}
//fun daysEnding(number: Int):String{
//
//}