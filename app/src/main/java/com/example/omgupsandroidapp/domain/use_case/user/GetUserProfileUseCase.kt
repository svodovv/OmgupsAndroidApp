package com.example.omgupsandroidapp.domain.use_case.user

import android.net.http.HttpException
import android.util.Log
import com.example.omgupsandroidapp.data.repository.UserProfileRepositoryImpl
import com.omgupsapp.common.Resource
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class GetUserProfileUseCase @Inject constructor(
    private val userProfileRepositoryImpl: UserProfileRepositoryImpl
) {
    operator fun invoke() = flow {
        try {
            emit(Resource.Loading())
            val userProfile = userProfileRepositoryImpl.getUserInfo()
            //val userPhoto = userProfileRepositoryImpl.getUserPhoto()
            emit(Resource.Success(userProfile))
           // emit(Resource.Success(userPhoto))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "IO Exception"))
            Log.e("GetScholarshipUseCase", "IO Exception $e")
        } catch (e: retrofit2.HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "HTTP Exception"))
            Log.e("GetScholarshipUseCase", "HTTP Exception $e")
        }
    }
}

class GetUserPhotoUseCase @Inject constructor(
    private val userProfileRepositoryImpl: UserProfileRepositoryImpl
) {
    operator fun invoke() = flow {
        try {
            emit(Resource.Loading())
            val userPhoto = userProfileRepositoryImpl.getUserPhoto()
            emit(Resource.Success(userPhoto))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "IO Exception"))
            Log.e("GetScholarshipUseCase", "IO Exception $e")
        } catch (e: retrofit2.HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "HTTP Exception"))
            Log.e("GetScholarshipUseCase", "HTTP Exception $e")
        }
    }
}