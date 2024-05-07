package com.example.omgupsandroidapp.data.remote.dto.spravki

import com.example.omgupsandroidapp.domain.model.SpravkaPostModel
import com.google.gson.annotations.SerializedName

data class SpravkiDtoItem(
    //@SerializedName("type")
    val type : Int,
   // @SerializedName("count")
    val count: Int
)

/*fun SpravkiDtoItem.toSpravkaPostModel() : SpravkaPostModel {
    return  SpravkaPostModel(
        type = type,
        current = count
    )
}*/
/*data class TypeSpravkiDtoItem(
    //@SerializedName("type")
    val type : String
)*/

