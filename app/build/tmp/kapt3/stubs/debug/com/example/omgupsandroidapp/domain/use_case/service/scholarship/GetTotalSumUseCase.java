package com.example.omgupsandroidapp.domain.use_case.service.scholarship;

import android.os.Build;
import com.example.omgupsandroidapp.domain.model.service.ScholarshipModel;
import com.example.omgupsandroidapp.domain.model.TotalSumPerMonthModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086\u0002\u00a8\u0006\t"}, d2 = {"Lcom/example/omgupsandroidapp/domain/use_case/service/scholarship/GetTotalSumUseCase;", "", "()V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/omgupsandroidapp/domain/model/TotalSumPerMonthModel;", "listScholarship", "", "Lcom/example/omgupsandroidapp/domain/model/service/ScholarshipModel;", "app_debug"})
public final class GetTotalSumUseCase {
    
    @javax.inject.Inject
    public GetTotalSumUseCase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.example.omgupsandroidapp.domain.model.TotalSumPerMonthModel> invoke(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.omgupsandroidapp.domain.model.service.ScholarshipModel> listScholarship) {
        return null;
    }
}