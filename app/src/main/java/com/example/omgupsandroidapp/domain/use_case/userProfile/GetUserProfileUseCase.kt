package com.example.omgupsandroidapp.domain.use_case.userProfile

import android.util.Log
import com.example.omgupsandroidapp.data.remote.dto.UserProfileDto.toUserProfileModel
import com.example.omgupsandroidapp.data.remote.dto.order.toOrderModel
import com.example.omgupsandroidapp.data.repository.UserProfileRepositoryImpl
import com.omgupsapp.common.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUserProfileUseCase @Inject constructor(
    private val userProfileRepositoryImpl: UserProfileRepositoryImpl
) {
    operator fun invoke() = flow {
        try {
            emit(Resource.Loading())
            val userProfile = userProfileRepositoryImpl.getUserProfile()?.toUserProfileModel()
            emit(Resource.Success(userProfile))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "IO Exception"))
            Log.e("GetScholarshipUseCase", "IO Exception $e")
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "HTTP Exception"))
            Log.e("GetScholarshipUseCase", "HTTP Exception $e")
        }
    }
}