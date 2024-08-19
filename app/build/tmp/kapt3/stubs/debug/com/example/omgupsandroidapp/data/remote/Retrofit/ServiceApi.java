package com.example.omgupsandroidapp.data.remote.Retrofit;

import com.example.omgupsandroidapp.data.remote.dto.order.OrderDto;
import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto;
import retrofit2.http.GET;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"Lcom/example/omgupsandroidapp/data/remote/Retrofit/ServiceApi;", "", "getOrders", "Lcom/example/omgupsandroidapp/data/remote/dto/order/OrderDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScholarship", "Lcom/example/omgupsandroidapp/data/remote/dto/scholarship/ScholarshipDto;", "app_debug"})
public abstract interface ServiceApi {
    
    @retrofit2.http.GET(value = "student/getstipend")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getScholarship(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto> $completion);
    
    @retrofit2.http.GET(value = "student/getorders")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getOrders(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.order.OrderDto> $completion);
}