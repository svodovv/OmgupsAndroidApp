package com.example.omgupsandroidapp.data.remote.dto.spravki

import com.google.gson.annotations.SerializedName

data class LoadSpravkaDto(
    @SerializedName("type")
    val type: String,
    @SerializedName("count")
    val count: Int
)

data class LoadSpravkaModel(
    val type: String,
    val count: Int
)

/*data class LoadSpravkaDto (
    val SpravkaForm : LoadSpravka,
)*/

data class SpravkaResponse(
    val status: String
)

fun LoadSpravkaDto.toDtoLoadSpravka() : LoadSpravkaDto {
    return LoadSpravkaDto(
        type = type,
        count = count
    )
}

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

