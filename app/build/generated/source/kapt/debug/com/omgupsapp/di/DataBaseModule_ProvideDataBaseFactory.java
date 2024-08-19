// Generated by Dagger (https://dagger.dev).
package com.omgupsapp.di;

import android.content.Context;
import com.omgupsapp.data.local.Room.AppDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DataBaseModule_ProvideDataBaseFactory implements Factory<AppDatabase> {
  private final Provider<Context> contextProvider;

  public DataBaseModule_ProvideDataBaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public AppDatabase get() {
    return provideDataBase(contextProvider.get());
  }

  public static DataBaseModule_ProvideDataBaseFactory create(Provider<Context> contextProvider) {
    return new DataBaseModule_ProvideDataBaseFactory(contextProvider);
  }

  public static AppDatabase provideDataBase(Context context) {
    return Preconditions.checkNotNullFromProvides(DataBaseModule.INSTANCE.provideDataBase(context));
  }
}