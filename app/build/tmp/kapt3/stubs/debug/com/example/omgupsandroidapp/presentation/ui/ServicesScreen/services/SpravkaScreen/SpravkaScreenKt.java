package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.style.TextAlign;
import androidx.navigation.NavController;
import com.example.omgupsandroidapp.R;
import com.example.omgupsandroidapp.data.remote.dto.spravki.LoadSpravka;
import com.example.omgupsandroidapp.data.remote.dto.spravki.TypeStatusList;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0007\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0007\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0007\u001a@\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007\u001a$\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007\u00a8\u0006\u001f"}, d2 = {"ExpandableOrderTable", "", "orderStatus", "", "Lcom/example/omgupsandroidapp/data/remote/dto/spravki/TypeStatusList;", "hystoryType", "", "OrderStatusBar", "currentStage", "", "OrderTable", "OrderTableOne", "SpravkaScreen", "navController", "Landroidx/navigation/NavController;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "spravkiViewModel", "Lcom/example/omgupsandroidapp/presentation/ui/ServicesScreen/services/SpravkaScreen/SpravkiViewModel;", "referenceHistoryViewModel", "Lcom/example/omgupsandroidapp/presentation/ui/ServicesScreen/services/SpravkaScreen/ReferenceHistoryViewModel;", "spravkaViewModul", "Lcom/example/omgupsandroidapp/presentation/ui/ServicesScreen/services/SpravkaScreen/StatusSpravkaViewModul;", "orderSpravkaViewModel", "Lcom/example/omgupsandroidapp/presentation/ui/ServicesScreen/services/SpravkaScreen/OrderSpravkaViewModel;", "TextInLazyColumns", "columnName", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "app_debug"})
public final class SpravkaScreenKt {
    
    @android.annotation.SuppressLint(value = {"StateFlowValueCalledInComposition", "CoroutineCreationDuringComposition"})
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.compose.runtime.Composable
    public static final void SpravkaScreen(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull
    androidx.compose.foundation.layout.PaddingValues paddingValues, @org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen.SpravkiViewModel spravkiViewModel, @org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen.ReferenceHistoryViewModel referenceHistoryViewModel, @org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen.StatusSpravkaViewModul spravkaViewModul, @org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SpravkaScreen.OrderSpravkaViewModel orderSpravkaViewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void OrderStatusBar(int currentStage) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void OrderTable(@org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.data.remote.dto.spravki.TypeStatusList orderStatus) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.compose.runtime.Composable
    public static final void OrderTableOne() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ExpandableOrderTable(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.omgupsandroidapp.data.remote.dto.spravki.TypeStatusList> orderStatus, @org.jetbrains.annotations.NotNull
    java.lang.String hystoryType) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void TextInLazyColumns(@org.jetbrains.annotations.NotNull
    java.lang.String columnName, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.text.TextStyle style) {
    }
}