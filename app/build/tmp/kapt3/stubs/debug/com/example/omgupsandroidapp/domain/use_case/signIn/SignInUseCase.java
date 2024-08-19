package com.example.omgupsandroidapp.domain.use_case.signIn;

import android.util.Log;
import com.omgupsapp.data.local.DataStore.DataStoreManager;
import kotlinx.coroutines.flow.Flow;
import retrofit2.HttpException;
import java.io.IOException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/omgupsandroidapp/domain/use_case/signIn/SignInUseCase;", "", "dataStoreManager", "Lcom/omgupsapp/data/local/DataStore/DataStoreManager;", "(Lcom/omgupsapp/data/local/DataStore/DataStoreManager;)V", "isUserSignIn", "Lkotlinx/coroutines/flow/Flow;", "", "app_debug"})
public final class SignInUseCase {
    @org.jetbrains.annotations.NotNull
    private final com.omgupsapp.data.local.DataStore.DataStoreManager dataStoreManager = null;
    
    @javax.inject.Inject
    public SignInUseCase(@org.jetbrains.annotations.NotNull
    com.omgupsapp.data.local.DataStore.DataStoreManager dataStoreManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> isUserSignIn() {
        return null;
    }
}