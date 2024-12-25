package com.example.omgupsandroidapp.data.repository

import com.example.omgupsandroidapp.R
import com.example.omgupsandroidapp.data.remote.Retrofit.UserInfoApi
import com.example.omgupsandroidapp.data.remote.dto.user.UserProfileDto
import com.example.omgupsandroidapp.data.remote.dto.user.toUserInfoModel
import com.example.omgupsandroidapp.data.remote.dto.user.toUserPhotoUrl
import com.example.omgupsandroidapp.domain.model.user.UserInfoModel
import com.example.omgupsandroidapp.domain.model.user.UserPhotoUrlModel
import com.example.omgupsandroidapp.domain.repository.UserProfileRepository
import com.omgupsapp.common.Constants
import javax.inject.Inject

class UserProfileRepositoryImpl @Inject constructor(
    private val userInfoApi: UserInfoApi
) : UserProfileRepository {

    override suspend fun getUserInfo(): UserInfoModel {
        val responseUserInfo = userInfoApi.getUserInfo()
        /*if (userPhoto == "Фотография отсутствует"){
            return responseUserInfo.toUserInfoModel(R.drawable.icon_profile.toString())
        }else{
            return responseUserInfo.toUserInfoModel(Constants.BASE_URL + userPhoto)
        }*/
        return responseUserInfo.toUserInfoModel()
    }

    override suspend fun getUserPhoto(): UserPhotoUrlModel {
        val userPhoto = userInfoApi.getPhoto()
        return userPhoto.toUserPhotoUrl(Constants.BASE_URL + userPhoto.photoUrl)
    }
}