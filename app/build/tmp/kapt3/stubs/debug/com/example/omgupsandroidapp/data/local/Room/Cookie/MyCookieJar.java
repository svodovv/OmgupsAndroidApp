package com.example.omgupsandroidapp.data.local.Room.Cookie;

import android.util.Log;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/omgupsandroidapp/data/local/Room/Cookie/MyCookieJar;", "Lokhttp3/CookieJar;", "cookieDao", "Lcom/example/omgupsandroidapp/data/local/Room/Cookie/CookieDao;", "(Lcom/example/omgupsandroidapp/data/local/Room/Cookie/CookieDao;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "loadForRequest", "", "Lokhttp3/Cookie;", "url", "Lokhttp3/HttpUrl;", "saveFromResponse", "", "cookies", "app_debug"})
public final class MyCookieJar implements okhttp3.CookieJar {
    @org.jetbrains.annotations.NotNull
    private final com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao cookieDao = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    
    @javax.inject.Inject
    public MyCookieJar(@org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao cookieDao) {
        super();
    }
    
    @java.lang.Override
    public void saveFromResponse(@org.jetbrains.annotations.NotNull
    okhttp3.HttpUrl url, @org.jetbrains.annotations.NotNull
    java.util.List<okhttp3.Cookie> cookies) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.util.List<okhttp3.Cookie> loadForRequest(@org.jetbrains.annotations.NotNull
    okhttp3.HttpUrl url) {
        return null;
    }
}