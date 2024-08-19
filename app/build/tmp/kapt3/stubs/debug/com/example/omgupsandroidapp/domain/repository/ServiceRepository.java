package com.example.omgupsandroidapp.domain.repository;

import com.example.omgupsandroidapp.data.remote.dto.order.OrderDto;
import com.example.omgupsandroidapp.data.remote.dto.schedule.SheduleDto;
import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto;
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravka;
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDto;
import com.example.omgupsandroidapp.data.remote.dto.spravki.ReferenceHistoryDto;
import com.example.omgupsandroidapp.data.remote.dto.spravki.StatusSpravakaDto;
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeStatusList;
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeSpravkaDto;
import com.example.omgupsandroidapp.domain.model.SpravkaPostModel;
import com.omgupsapp.common.Resource;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0011\u0010\n\u001a\u00020\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\f\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001a\u00020\u0011H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/example/omgupsandroidapp/domain/repository/ServiceRepository;", "", "getOrder", "Lcom/example/omgupsandroidapp/data/remote/dto/order/OrderDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReferenceHistory", "Lcom/example/omgupsandroidapp/data/remote/dto/spravki/ReferenceHistoryDto;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScholarship", "Lcom/example/omgupsandroidapp/data/remote/dto/scholarship/ScholarshipDto;", "getShudele", "Lcom/example/omgupsandroidapp/data/remote/dto/schedule/SheduleDto;", "getStatusSpravka", "Lcom/example/omgupsandroidapp/data/remote/dto/spravki/StatusSpravakaDto;", "getTypesSravki", "Lcom/example/omgupsandroidapp/data/remote/dto/spravki/TypeSpravkaDto;", "postSpravka", "Lcom/example/omgupsandroidapp/data/remote/dto/spravki/LoadSpravkaDto;", "post", "Lcom/example/omgupsandroidapp/data/remote/dto/spravki/LoadSpravka;", "(Lcom/example/omgupsandroidapp/data/remote/dto/spravki/LoadSpravka;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ServiceRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getScholarship(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object postSpravka(@org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravka post, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravkaDto> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getOrder(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.order.OrderDto> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTypesSravki(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.spravki.TypeSpravkaDto> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getReferenceHistory(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.spravki.ReferenceHistoryDto> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getStatusSpravka(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.spravki.StatusSpravakaDto> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getShudele(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.schedule.SheduleDto> $completion);
}