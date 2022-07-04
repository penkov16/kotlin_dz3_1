fun main(){
    val time = 10
    println("был(а) в сети ${agoToText(time)}")
}
fun agoToText(time: Int): String {
    val minute = 60
    val hour = 60*60
    val day = 24*60*60
    val translateMinute = time / minute
    val translateHour = time / hour
    return when {
        time in 0..minute -> "только что"
        time in (minute + 1)..hour -> "$translateMinute ${minute(translateMinute)}"
        time in (hour + 1)..day -> "$translateHour ${hour(translateHour)}"
        time in (day+1)..2*day -> "сегодня"
        time in (2*day +1)..3*day -> "вчера"
        else -> {"давно"}
    }
}
fun minute(minute: Int): String {
    return when(minute){
        1,21,31,41,51 -> "минуту назад"
        2,3,4,32,33,34,42,43,44,52,53,54 -> "минуты назад"
        else -> "минут назад"
    }
}
fun hour(hour: Int): String {
    return when(hour){
        1,21 -> "час назад"
        2,3,4,22,23,24 -> "часа назад"
        else -> "часов назад"
    }
}