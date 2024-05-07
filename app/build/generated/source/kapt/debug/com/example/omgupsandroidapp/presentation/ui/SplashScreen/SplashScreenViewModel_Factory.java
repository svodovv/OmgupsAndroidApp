// Generated by Dagger (https://dagger.dev).
package com.example.omgupsandroidapp.presentation.ui.SplashScreen;

import com.example.omgupsandroidapp.domain.use_case.signIn.SignInUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class SplashScreenViewModel_Factory implements Factory<SplashScreenViewModel> {
  private final Provider<SignInUseCase> signInUseCaseProvider;

  public SplashScreenViewModel_Factory(Provider<SignInUseCase> signInUseCaseProvider) {
    this.signInUseCaseProvider = signInUseCaseProvider;
  }

  @Override
  public SplashScreenViewModel get() {
    return newInstance(signInUseCaseProvider.get());
  }

  public static SplashScreenViewModel_Factory create(
      Provider<SignInUseCase> signInUseCaseProvider) {
    return new SplashScreenViewModel_Factory(signInUseCaseProvider);
  }

  public static SplashScreenViewModel newInstance(SignInUseCase signInUseCase) {
    return new SplashScreenViewModel(signInUseCase);
  }
}
