// Generated by Dagger (https://dagger.dev).
package com.example.omgupsandroidapp.domain.use_case.service.scholarship;

import com.example.omgupsandroidapp.data.repository.ServiceRepositoryImpl;
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
public final class GetScholarshipUseCase_Factory implements Factory<GetScholarshipUseCase> {
  private final Provider<ServiceRepositoryImpl> serviceRepositoryImplProvider;

  public GetScholarshipUseCase_Factory(
      Provider<ServiceRepositoryImpl> serviceRepositoryImplProvider) {
    this.serviceRepositoryImplProvider = serviceRepositoryImplProvider;
  }

  @Override
  public GetScholarshipUseCase get() {
    return newInstance(serviceRepositoryImplProvider.get());
  }

  public static GetScholarshipUseCase_Factory create(
      Provider<ServiceRepositoryImpl> serviceRepositoryImplProvider) {
    return new GetScholarshipUseCase_Factory(serviceRepositoryImplProvider);
  }

  public static GetScholarshipUseCase newInstance(ServiceRepositoryImpl serviceRepositoryImpl) {
    return new GetScholarshipUseCase(serviceRepositoryImpl);
  }
}
