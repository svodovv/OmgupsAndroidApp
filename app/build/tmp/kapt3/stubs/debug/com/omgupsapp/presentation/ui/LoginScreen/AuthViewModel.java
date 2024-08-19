package com.omgupsapp.presentation.ui.LoginScreen;

import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import com.example.omgupsandroidapp.presentation.ui.LoginScreen.AuthenticationState;
import com.omgupsapp.common.Resource;
import com.omgupsapp.domain.use_case.login.GetCsrfTokenUseCase;
import com.omgupsapp.domain.use_case.login.AuthenticationUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/omgupsapp/presentation/ui/LoginScreen/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "getCsrfTokenUseCase", "Lcom/omgupsapp/domain/use_case/login/GetCsrfTokenUseCase;", "authenticationUseCase", "Lcom/omgupsapp/domain/use_case/login/AuthenticationUseCase;", "(Lcom/omgupsapp/domain/use_case/login/GetCsrfTokenUseCase;Lcom/omgupsapp/domain/use_case/login/AuthenticationUseCase;)V", "_stateAuthentication", "Landroidx/compose/runtime/MutableState;", "Lcom/example/omgupsandroidapp/presentation/ui/LoginScreen/AuthenticationState;", "_stateToken", "Lcom/omgupsapp/presentation/ui/LoginScreen/GetTokenState;", "stateAuthentication", "Landroidx/compose/runtime/State;", "getStateAuthentication", "()Landroidx/compose/runtime/State;", "stateToken", "getStateToken", "getToken", "", "isNotLoading", "onChangeLogin", "login", "", "onChangePassword", "password", "userAuthenticated", "userStateAuth", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.omgupsapp.domain.use_case.login.GetCsrfTokenUseCase getCsrfTokenUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.omgupsapp.domain.use_case.login.AuthenticationUseCase authenticationUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<com.omgupsapp.presentation.ui.LoginScreen.GetTokenState> _stateToken = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.omgupsapp.presentation.ui.LoginScreen.GetTokenState> stateToken = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<com.example.omgupsandroidapp.presentation.ui.LoginScreen.AuthenticationState> _stateAuthentication = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.example.omgupsandroidapp.presentation.ui.LoginScreen.AuthenticationState> stateAuthentication = null;
    
    @javax.inject.Inject
    public AuthViewModel(@org.jetbrains.annotations.NotNull
    com.omgupsapp.domain.use_case.login.GetCsrfTokenUseCase getCsrfTokenUseCase, @org.jetbrains.annotations.NotNull
    com.omgupsapp.domain.use_case.login.AuthenticationUseCase authenticationUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.omgupsapp.presentation.ui.LoginScreen.GetTokenState> getStateToken() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.example.omgupsandroidapp.presentation.ui.LoginScreen.AuthenticationState> getStateAuthentication() {
        return null;
    }
    
    private final void getToken() {
    }
    
    public final void userAuthenticated() {
    }
    
    public final void onChangeLogin(@org.jetbrains.annotations.NotNull
    java.lang.String login) {
    }
    
    public final void onChangePassword(@org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
    
    public final void userStateAuth() {
    }
    
    public final void isNotLoading() {
    }
}