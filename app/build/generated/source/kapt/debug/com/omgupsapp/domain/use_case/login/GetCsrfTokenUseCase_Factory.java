// Generated by Dagger (https://dagger.dev).
package com.omgupsapp.domain.use_case.login;

import com.omgupsapp.domain.repository.AuthRepository;
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
public final class GetCsrfTokenUseCase_Factory implements Factory<GetCsrfTokenUseCase> {
  private final Provider<AuthRepository> repositoryProvider;

  public GetCsrfTokenUseCase_Factory(Provider<AuthRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetCsrfTokenUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetCsrfTokenUseCase_Factory create(Provider<AuthRepository> repositoryProvider) {
    return new GetCsrfTokenUseCase_Factory(repositoryProvider);
  }

  public static GetCsrfTokenUseCase newInstance(AuthRepository repository) {
    return new GetCsrfTokenUseCase(repository);
  }
}
