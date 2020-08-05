package com.empty.botbox.models

import java.util.ArrayList

data class BotResponse(
    val count:Int,
    val next:String,
    var previos:String,
    val result:ArrayList<Bot>

) {
}