package com.example.omgupsandroidapp.data.remote.dto.spravki

import com.google.gson.annotations.SerializedName

data class LoadSpravka(
    @SerializedName("type")
    val type: String,
    @SerializedName("count")
    val count: String
)

data class LoadSpravkaDto (
    val SpravkaForm : LoadSpravka,
)

fun LoadSpravka.toDtoLoadSpravka() : LoadSpravkaDto {
    return LoadSpravkaDto(
        LoadSpravka(
        type = type,
        count = count
        )
    )
}

data class LoadSpravkaDtoItem(
    @SerializedName("type")
    val type : Int,
    @SerializedName("count")
    val count: Int
)
/*fun LoadSpravkaDtoItem.toSpravkaPostModel() : LoadSpravka {
    return  LoadSpravka(
        type = type,
        count = count
    )
}*/
/*data class TypeSpravkiDtoItem(
    //@SerializedName("type")
    val type : String
)*/

