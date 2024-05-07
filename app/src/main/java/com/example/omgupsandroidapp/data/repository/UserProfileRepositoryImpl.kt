package com.example.omgupsandroidapp.data.repository

import com.example.omgupsandroidapp.data.remote.dto.UserProfileDto.UserProfileDto
import com.example.omgupsandroidapp.domain.repository.UserProfileRepository
import javax.inject.Inject

class UserProfileRepositoryImpl @Inject constructor() : UserProfileRepository {

    override suspend fun getUserProfile(): UserProfileDto? {
        return UserProfileDto(
            imageVector = null,
            name = "Владимир",
            surname = "Кондратьев",
            patronymic = "Андреевич",
            institute = "Институт автоматики, телекоммуникаций и информационных технологий (на правах факультета ОмГУПСа)",
            specialization = "Информационные системы и технологии",
            direction = "Программирование и информационные технологии",
            group = "20з",
            formEducation = "очная",
            typeEducation = "Является студентом",
            statusEducation = "активен",
            lvlEducation = "Бакалавр",
            course = 4
        )
    }
}