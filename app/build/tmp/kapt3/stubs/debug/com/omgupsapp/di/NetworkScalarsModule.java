package com.omgupsapp.di;

import com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao;
import com.example.omgupsandroidapp.data.local.Room.Cookie.MyCookieJar;
import com.omgupsapp.common.Constants;
import com.omgupsapp.data.local.DataStore.DataStoreManager;
import com.omgupsapp.data.remote.Retrofit.AuthApi;
import com.omgupsapp.data.remote.Retrofit.LogoutApi;
import com.omgupsapp.data.repository.AuthRepositoryImpl;
import com.omgupsapp.data.repository.LogoutRepositoryImpl;
import com.omgupsapp.domain.repository.AuthRepository;
import com.omgupsapp.domain.repository.LogoutRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import javax.inject.Named;
import javax.inject.Singleton;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0007J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0015H\u0007\u00a8\u0006\u0019"}, d2 = {"Lcom/omgupsapp/di/NetworkScalarsModule;", "", "()V", "authApi", "Lcom/omgupsapp/data/remote/Retrofit/AuthApi;", "retrofit", "Lretrofit2/Retrofit;", "logoutApi", "Lcom/omgupsapp/data/remote/Retrofit/LogoutApi;", "provideAuthRepository", "Lcom/omgupsapp/domain/repository/AuthRepository;", "api", "dataStoreManager", "Lcom/omgupsapp/data/local/DataStore/DataStoreManager;", "provideLogoutRepository", "Lcom/omgupsapp/domain/repository/LogoutRepository;", "cookieDao", "Lcom/example/omgupsandroidapp/data/local/Room/Cookie/CookieDao;", "provideMyCookieJar", "Lcom/example/omgupsandroidapp/data/local/Room/Cookie/MyCookieJar;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "cookieJar", "provideRetrofit", "okHttpClient", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class NetworkScalarsModule {
    @org.jetbrains.annotations.NotNull
    public static final com.omgupsapp.di.NetworkScalarsModule INSTANCE = null;
    
    private NetworkScalarsModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.omgupsandroidapp.data.local.Room.Cookie.MyCookieJar provideMyCookieJar(@org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao cookieDao) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final okhttp3.OkHttpClient provideOkHttpClient(@org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.data.local.Room.Cookie.MyCookieJar cookieJar) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @javax.inject.Named(value = "Scalars")
    @org.jetbrains.annotations.NotNull
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.omgupsapp.data.remote.Retrofit.AuthApi authApi(@javax.inject.Named(value = "Scalars")
    @org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.omgupsapp.domain.repository.AuthRepository provideAuthRepository(@org.jetbrains.annotations.NotNull
    com.omgupsapp.data.remote.Retrofit.AuthApi api, @org.jetbrains.annotations.NotNull
    com.omgupsapp.data.local.DataStore.DataStoreManager dataStoreManager) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.omgupsapp.data.remote.Retrofit.LogoutApi logoutApi(@javax.inject.Named(value = "Scalars")
    @org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.omgupsapp.domain.repository.LogoutRepository provideLogoutRepository(@org.jetbrains.annotations.NotNull
    com.omgupsapp.data.remote.Retrofit.LogoutApi api, @org.jetbrains.annotations.NotNull
    com.omgupsapp.data.local.DataStore.DataStoreManager dataStoreManager, @org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao cookieDao) {
        return null;
    }
}