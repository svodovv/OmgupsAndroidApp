package com.example.omgupsandroidapp.domain.use_case.service.scholarship;

import android.util.Log;
import com.example.omgupsandroidapp.data.repository.ServiceRepositoryImpl;
import com.omgupsapp.common.Resource;
import retrofit2.HttpException;
import java.io.IOException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/omgupsandroidapp/domain/use_case/service/scholarship/GetScholarshipUseCase;", "", "serviceRepositoryImpl", "Lcom/example/omgupsandroidapp/data/repository/ServiceRepositoryImpl;", "(Lcom/example/omgupsandroidapp/data/repository/ServiceRepositoryImpl;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/omgupsapp/common/Resource;", "", "Lcom/example/omgupsandroidapp/domain/model/service/ScholarshipModel;", "app_debug"})
public final class GetScholarshipUseCase {
    @org.jetbrains.annotations.NotNull
    private final com.example.omgupsandroidapp.data.repository.ServiceRepositoryImpl serviceRepositoryImpl = null;
    
    @javax.inject.Inject
    public GetScholarshipUseCase(@org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.data.repository.ServiceRepositoryImpl serviceRepositoryImpl) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.omgupsapp.common.Resource<java.util.List<com.example.omgupsandroidapp.domain.model.service.ScholarshipModel>>> invoke() {
        return null;
    }
}