package com.example.omgupsandroidapp.data.remote.dto.spravki

import com.example.omgupsandroidapp.domain.model.SpravkaPostModel
import com.google.gson.annotations.SerializedName

data class LoadSpravka(
    @SerializedName("type")
    val type : Int,
    @SerializedName("count")
    val count: Int
)

data class LoadSpravkaDto (
    val spravkaForm : List<LoadSpravka>
)

fun LoadSpravka.toDtoLoadSpravka() : LoadSpravkaDto {
    return LoadSpravkaDto(
        listOf(this)
    )
}

data class LoadSpravkaDtoItem(
    @SerializedName("type")
    val type : Int,
    @SerializedName("count")
    val count: Int
)
fun LoadSpravkaDtoItem.toSpravkaPostModel() : LoadSpravka {
    return  LoadSpravka(
        type = type,
        count = count
    )
}
/*data class TypeSpravkiDtoItem(
    //@SerializedName("type")
    val type : String
)*/

