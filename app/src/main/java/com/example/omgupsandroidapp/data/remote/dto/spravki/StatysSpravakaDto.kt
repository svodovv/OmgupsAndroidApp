package com.example.omgupsandroidapp.data.remote.dto.spravki

import com.google.gson.annotations.SerializedName

data class  StatusSpravakaDto (
    @SerializedName("status")
    val responseStatus : String
)

data class  StatusSpravakaDtoItem (
    val responseStatus : String
)


fun StatusSpravakaDtoItem.StatusSpravakaDtoItem(): StatusSpravakaDto {
    return StatusSpravakaDto(
        responseStatus = responseStatus
    )
}
