package com.example.omgupsandroidapp.data.repository;

import com.example.omgupsandroidapp.data.remote.Retrofit.ServiceApi;
import com.example.omgupsandroidapp.data.remote.dto.order.OrderDto;
import com.example.omgupsandroidapp.data.remote.dto.scholarship.ScholarshipDto;
import com.example.omgupsandroidapp.domain.repository.ServiceRepository;
import javax.inject.Inject;
import javax.inject.Named;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0011\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/example/omgupsandroidapp/data/repository/ServiceRepositoryImpl;", "Lcom/example/omgupsandroidapp/domain/repository/ServiceRepository;", "serviceApi", "Lcom/example/omgupsandroidapp/data/remote/Retrofit/ServiceApi;", "(Lcom/example/omgupsandroidapp/data/remote/Retrofit/ServiceApi;)V", "getOrder", "Lcom/example/omgupsandroidapp/data/remote/dto/order/OrderDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScholarship", "Lcom/example/omgupsandroidapp/data/remote/dto/scholarship/ScholarshipDto;", "app_debug"})
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
    public java.lang.Object getOrder(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.omgupsandroidapp.data.remote.dto.order.OrderDto> $completion) {
        return null;
    }
}