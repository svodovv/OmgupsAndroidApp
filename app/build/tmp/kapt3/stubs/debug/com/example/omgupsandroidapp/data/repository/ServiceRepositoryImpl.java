package com.example.omgupsandroidapp.data.repository;

import com.example.omgupsandroidapp.data.remote.Retrofit.ServiceApi;
import com.example.omgupsandroidapp.data.remote.dto.order.OrderDto;
import com.example.omgupsandroidapp.data.remote.dto.schedule.SheduleDto;
import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto;
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravka;
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDto;
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDtoItem;
import com.example.omgupsandroidapp.data.remote.dto.spravki.ReferenceHistoryDto;
import com.example.omgupsandroidapp.data.remote.dto.spravki.StatusSpravakaDto;
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeStatusList;
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeSpravkaDto;
import com.example.omgupsandroidapp.domain.model.SpravkaPostModel;
import com.example.omgupsandroidapp.domain.repository.ServiceRepository;
import com.omgupsapp.common.Resource;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0011\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0011\u0010\u0013\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/example/omgupsandroidapp/data/repository/ServiceRepositoryImpl;", "Lcom/example/omgupsandroidapp/domain/repository/ServiceRepository;", "serviceApi", "Lcom/example/omgupsandroidapp/data/remote/Retrofit/ServiceApi;", "(Lcom/example/omgupsandroidapp/data/remote/Retrofit/ServiceApi;)V", "getOrder", "Lcom/example/omgupsandroidapp/data/remote/dto/order/OrderDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReferenceHistory", "Lcom/example/omgupsandroidapp/data/remote/dto/spravki/ReferenceHistoryDto;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScholarship", "Lcom/example/omgupsandroidapp/data/remote/dto/scholarship/ScholarshipDto;", "getShudele", "Lcom/example/omgupsandroidapp/data/remote/dto/schedule/SheduleDto;", "getStatusSpravka", "Lcom/example/omgupsandroidapp/data/remote/dto/spravki/StatusSpravakaDto;", "getTypesSravki", "Lcom/example/omgupsandroidapp/data/remote/dto/spravki/TypeSpravkaDto;", "postSpravka", "Lcom/example/omgupsandroidapp/data/remote/dto/spravki/LoadSpravkaDto;", "post", "Lcom/example/omgupsandroidapp/data/remote/dto/spravki/LoadSpravka;", "(Lcom/example/omgupsandroidapp/data/remote/dto/spravki/LoadSpravka;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ServiceRepositoryImpl implements com.example.omgupsandroidapp.domain.repository.ServiceRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.omgupsandroidapp.data.remote.Retrofit.ServiceApi serviceApi = null;
    
    @javax.inject.Inject
    public ServiceRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.data.remote.Retrofit.ServiceApi serviceApi) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getScholarship(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object postSpravka(@org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravka post, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDto> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getOrder(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.order.OrderDto> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getTypesSravki(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.spravki.TypeSpravkaDto> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getReferenceHistory(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.spravki.ReferenceHistoryDto> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getStatusSpravka(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.spravki.StatusSpravakaDto> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getShudele(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.schedule.SheduleDto> $completion) {
        return null;
    }
}