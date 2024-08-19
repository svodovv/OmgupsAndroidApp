package com.omgupsapp.presentation.ui.SettingsScreen;

import androidx.lifecycle.ViewModel;
import com.example.omgupsandroidapp.presentation.ui.SettingsScreen.ThemeState;
import com.omgupsapp.domain.use_case.logout.LogoutUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/omgupsapp/presentation/ui/SettingsScreen/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "logoutUseCase", "Lcom/omgupsapp/domain/use_case/logout/LogoutUseCase;", "(Lcom/omgupsapp/domain/use_case/logout/LogoutUseCase;)V", "_themeState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/omgupsandroidapp/presentation/ui/SettingsScreen/ThemeState;", "themeState", "Lkotlinx/coroutines/flow/StateFlow;", "getThemeState", "()Lkotlinx/coroutines/flow/StateFlow;", "logout", "", "themeUpdate", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.omgupsapp.domain.use_case.logout.LogoutUseCase logoutUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.omgupsandroidapp.presentation.ui.SettingsScreen.ThemeState> _themeState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.omgupsandroidapp.presentation.ui.SettingsScreen.ThemeState> themeState = null;
    
    @javax.inject.Inject
    public SettingsViewModel(@org.jetbrains.annotations.NotNull
    com.omgupsapp.domain.use_case.logout.LogoutUseCase logoutUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.omgupsandroidapp.presentation.ui.SettingsScreen.ThemeState> getThemeState() {
        return null;
    }
    
    public final void logout() {
    }
    
    public final void themeUpdate(boolean themeState) {
    }
}