package com.example.omgupsandroidapp.data.remote.Retrofit;

import com.example.omgupsandroidapp.data.remote.dto.order.OrderDto;
import com.example.omgupsandroidapp.data.remote.dto.schedule.SheduleDto;
import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto;
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravka;
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDto;
import com.example.omgupsandroidapp.data.remote.dto.spravki.ReferenceHistoryDto;
import com.example.omgupsandroidapp.data.remote.dto.spravki.StatusSpravakaDto;
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeSpravkaDto;
import com.example.omgupsandroidapp.domain.model.SpravkaPostModel;
import com.omgupsapp.common.Resource;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0011\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/example/omgupsandroidapp/data/remote/Retrofit/ServiceApi;", "", "getOrders", "Lcom/example/omgupsandroidapp/data/remote/dto/order/OrderDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReferenceHistory", "Lcom/example/omgupsandroidapp/data/remote/dto/spravki/ReferenceHistoryDto;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScholarship", "Lcom/example/omgupsandroidapp/data/remote/dto/scholarship/ScholarshipDto;", "getShudule", "Lcom/example/omgupsandroidapp/data/remote/dto/schedule/SheduleDto;", "getStatysSpravka", "Lcom/example/omgupsandroidapp/data/remote/dto/spravki/StatusSpravakaDto;", "getTypesSpravki", "Lcom/example/omgupsandroidapp/data/remote/dto/spravki/TypeSpravkaDto;", "postSpravka", "Lcom/example/omgupsandroidapp/data/remote/dto/spravki/LoadSpravkaDto;", "post", "(Lcom/example/omgupsandroidapp/data/remote/dto/spravki/LoadSpravkaDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ServiceApi {
    
    @retrofit2.http.GET(value = "student/getstipend")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getScholarship(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto> $completion);
    
    @retrofit2.http.GET(value = "student/getorders")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getOrders(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.order.OrderDto> $completion);
    
    @retrofit2.http.GET(value = "student/getschedule")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getShudule(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.schedule.SheduleDto> $completion);
    
    @retrofit2.http.POST(value = "spravkaapi/spravka/create")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object postSpravka(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDto post, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDto> $completion);
    
    @retrofit2.http.GET(value = "spravkaapi/spravka/get-history")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getReferenceHistory(@retrofit2.http.Query(value = "type")
    int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.spravki.ReferenceHistoryDto> $completion);
    
    @retrofit2.http.GET(value = "spravkaapi/spravka/get-types")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTypesSpravki(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.spravki.TypeSpravkaDto> $completion);
    
    @retrofit2.http.GET(value = "/spravkaapi/spravka/get-status")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getStatysSpravka(@retrofit2.http.Query(value = "type")
    int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.spravki.StatusSpravakaDto> $completion);
}