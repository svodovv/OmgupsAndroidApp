package com.omgupsapp.data.repository;

import com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao;
import com.omgupsapp.data.local.DataStore.DataStoreManager;
import com.omgupsapp.data.remote.Retrofit.LogoutApi;
import com.omgupsapp.domain.repository.LogoutRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0011\u0010\r\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/omgupsapp/data/repository/LogoutRepositoryImpl;", "Lcom/omgupsapp/domain/repository/LogoutRepository;", "dataStoreManager", "Lcom/omgupsapp/data/local/DataStore/DataStoreManager;", "api", "Lcom/omgupsapp/data/remote/Retrofit/LogoutApi;", "cookieDao", "Lcom/example/omgupsandroidapp/data/local/Room/Cookie/CookieDao;", "(Lcom/omgupsapp/data/local/DataStore/DataStoreManager;Lcom/omgupsapp/data/remote/Retrofit/LogoutApi;Lcom/example/omgupsandroidapp/data/local/Room/Cookie/CookieDao;)V", "getApi", "()Lcom/omgupsapp/data/remote/Retrofit/LogoutApi;", "getDataStoreManager", "()Lcom/omgupsapp/data/local/DataStore/DataStoreManager;", "logout", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class LogoutRepositoryImpl implements com.omgupsapp.domain.repository.LogoutRepository {
    @org.jetbrains.annotations.NotNull
    private final com.omgupsapp.data.local.DataStore.DataStoreManager dataStoreManager = null;
    @org.jetbrains.annotations.NotNull
    private final com.omgupsapp.data.remote.Retrofit.LogoutApi api = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao cookieDao = null;
    
    @javax.inject.Inject
    public LogoutRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.omgupsapp.data.local.DataStore.DataStoreManager dataStoreManager, @org.jetbrains.annotations.NotNull
    com.omgupsapp.data.remote.Retrofit.LogoutApi api, @org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao cookieDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.omgupsapp.data.local.DataStore.DataStoreManager getDataStoreManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.omgupsapp.data.remote.Retrofit.LogoutApi getApi() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object logout(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}