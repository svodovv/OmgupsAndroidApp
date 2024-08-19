package com.omgupsapp.presentation.ui.SheduleScreen;

import android.annotation.SuppressLint;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.navigation.NavController;
import com.example.omgupsandroidapp.domain.model.service.SheduleModel;
import com.example.omgupsandroidapp.presentation.ui.SheduleScreen.SheduleViewModul;
import java.util.Calendar;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\"\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007\u001a$\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u001e\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a\u0006\u0010\u0016\u001a\u00020\u0003\u00a8\u0006\u0017"}, d2 = {"OneDayShedule", "", "day_of_week", "", "modifier", "Landroidx/compose/ui/Modifier;", "ScheduleScreen", "navController", "Landroidx/navigation/NavController;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "sheduleViewModul", "Lcom/example/omgupsandroidapp/presentation/ui/SheduleScreen/SheduleViewModul;", "TextInLazyColumns", "columnName", "style", "Landroidx/compose/ui/text/TextStyle;", "createDayBox", "dayOfWeek", "schedule", "", "Lcom/example/omgupsandroidapp/domain/model/service/SheduleModel;", "getCurrentDate", "app_debug"})
public final class ScheduleScreenKt {
    
    @android.annotation.SuppressLint(value = {"CoroutineCreationDuringComposition"})
    @androidx.compose.runtime.Composable
    public static final void ScheduleScreen(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull
    androidx.compose.foundation.layout.PaddingValues paddingValues, @org.jetbrains.annotations.NotNull
    com.example.omgupsandroidapp.presentation.ui.SheduleScreen.SheduleViewModul sheduleViewModul) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void createDayBox(@org.jetbrains.annotations.NotNull
    java.lang.String dayOfWeek, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.omgupsandroidapp.domain.model.service.SheduleModel> schedule) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void TextInLazyColumns(@org.jetbrains.annotations.NotNull
    java.lang.String columnName, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.text.TextStyle style) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void OneDayShedule(@org.jetbrains.annotations.NotNull
    java.lang.String day_of_week, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getCurrentDate() {
        return null;
    }
}