package com.example.omgupsandroidapp.di;

import com.example.omgupsandroidapp.data.remote.Retrofit.ServiceApi;
import com.omgupsapp.common.Constants;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import javax.inject.Named;
import javax.inject.Singleton;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/example/omgupsandroidapp/di/NetworkGsonModule;", "", "()V", "provideRetrofitGson", "Lretrofit2/Retrofit;", "okHttpClient", "Lokhttp3/OkHttpClient;", "provideServiceApi", "Lcom/example/omgupsandroidapp/data/remote/Retrofit/ServiceApi;", "retrofit", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class NetworkGsonModule {
    @org.jetbrains.annotations.NotNull
    public static final com.example.omgupsandroidapp.di.NetworkGsonModule INSTANCE = null;
    
    private NetworkGsonModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @javax.inject.Named(value = "gson")
    @org.jetbrains.annotations.NotNull
    public final retrofit2.Retrofit provideRetrofitGson(@org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.omgupsandroidapp.data.remote.Retrofit.ServiceApi provideServiceApi(@javax.inject.Named(value = "gson")
    @org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
}