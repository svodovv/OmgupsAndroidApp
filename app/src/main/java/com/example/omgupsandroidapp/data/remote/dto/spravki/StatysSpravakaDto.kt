package com.example.omgupsandroidapp.data.remote.dto.spravki
data class  StatusSpravakaDto (
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
