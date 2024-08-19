package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ScholarshipScreen;

import androidx.lifecycle.ViewModel;
import com.example.omgupsandroidapp.domain.use_case.service.scholarship.GetScholarshipUseCase;
import com.example.omgupsandroidapp.domain.use_case.service.scholarship.GetTotalSumUseCase;
import com.omgupsapp.common.Resource;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/omgupsandroidapp/presentation/ui/ServicesScreen/services/ScholarshipScreen/ScholarshipViewModel;", "Landroidx/lifecycle/ViewModel;", "scholarshipUseCase", "Lcom/example/omgupsandroidapp/domain/use_case/service/scholarship/GetScholarshipUseCase;", "getTotalSumUseCase", "Lcom/example/omgupsandroidapp/domain/use_case/service/scholarship/GetTotalSumUseCase;", "(Lcom/example/omgupsandroidapp/domain/use_case/service/scholarship/GetScholarshipUseCase;Lcom/example/omgupsandroidapp/domain/use_case/service/scholarship/GetTotalSumUseCase;)V", "_scholarship", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/omgupsandroidapp/presentation/ui/ServicesScreen/services/ScholarshipScreen/ScholarshipState;", "scholarship", "Lkotlinx/coroutines/flow/StateFlow;", "getScholarship", "()Lkotlinx/coroutines/flow/StateFlow;", "", "getTotalSum", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ScholarshipViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.omgupsandroidapp.domain.use_case.service.scholarship.GetScholarshipUseCase scholarshipUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.omgupsandroidapp.domain.use_case.service.scholarship.GetTotalSumUseCase getTotalSumUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ScholarshipScreen.ScholarshipState> _scholarship = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ScholarshipScreen.ScholarshipState> scholarship = null;
    
    @javax.inject.Inject
    public ScholarshipViewModel(@org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.domain.use_case.service.scholarship.GetScholarshipUseCase scholarshipUseCase, @org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.domain.use_case.service.scholarship.GetTotalSumUseCase getTotalSumUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ScholarshipScreen.ScholarshipState> getScholarship() {
        return null;
    }
    
    private final void getScholarship() {
    }
    
    private final void getTotalSum() {
    }
}