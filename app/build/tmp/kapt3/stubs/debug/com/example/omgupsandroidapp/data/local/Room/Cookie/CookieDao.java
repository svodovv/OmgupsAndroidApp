package com.example.omgupsandroidapp.data.local.Room.Cookie;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Upsert;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\'J\u0019\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/example/omgupsandroidapp/data/local/Room/Cookie/CookieDao;", "", "deleteAllCookies", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteExpiredCookies", "currentTime", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCookiesForHost", "", "Lcom/example/omgupsandroidapp/data/local/Room/Cookie/CookieEntity;", "host", "", "insertCookie", "cookie", "(Lcom/example/omgupsandroidapp/data/local/Room/Cookie/CookieEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface CookieDao {
    
    @androidx.room.Upsert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertCookie(@org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.data.local.Room.Cookie.CookieEntity cookie, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM cookies WHERE host = :host")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.omgupsandroidapp.data.local.Room.Cookie.CookieEntity> getCookiesForHost(@org.jetbrains.annotations.NotNull
    java.lang.String host);
    
    @androidx.room.Query(value = "DELETE FROM cookies")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteAllCookies(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM cookies WHERE expiresAt < :currentTime")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteExpiredCookies(long currentTime, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}