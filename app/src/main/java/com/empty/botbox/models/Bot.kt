package com.empty.botbox.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bots")
data class Bot(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "id") var id:Int,

    @ColumnInfo(name="token")
    val token:String,

    @ColumnInfo(name = "name")
    val name:String,

    @ColumnInfo(name = "description")
    var description:String="",

    @ColumnInfo(name="online")
    var isOnline:Boolean=false
)


