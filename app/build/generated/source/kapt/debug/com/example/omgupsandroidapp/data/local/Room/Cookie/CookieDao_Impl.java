package com.example.omgupsandroidapp.data.local.Room.Cookie;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.EntityUpsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CookieDao_Impl implements CookieDao {
  private final RoomDatabase __db;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllCookies;

  private final SharedSQLiteStatement __preparedStmtOfDeleteExpiredCookies;

  private final EntityUpsertionAdapter<CookieEntity> __upsertionAdapterOfCookieEntity;

  public CookieDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__preparedStmtOfDeleteAllCookies = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM cookies";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteExpiredCookies = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM cookies WHERE expiresAt < ?";
        return _query;
      }
    };
    this.__upsertionAdapterOfCookieEntity = new EntityUpsertionAdapter<CookieEntity>(new EntityInsertionAdapter<CookieEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `cookies` (`id`,`host`,`name`,`value`,`expiresAt`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CookieEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getHost() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getHost());
        }
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        if (entity.getValue() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getValue());
        }
        statement.bindLong(5, entity.getExpiresAt());
      }
    }, new EntityDeletionOrUpdateAdapter<CookieEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `cookies` SET `id` = ?,`host` = ?,`name` = ?,`value` = ?,`expiresAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CookieEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getHost() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getHost());
        }
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        if (entity.getValue() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getValue());
        }
        statement.bindLong(5, entity.getExpiresAt());
        statement.bindLong(6, entity.getId());
      }
    });
  }

  @Override
  public Object deleteAllCookies(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllCookies.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllCookies.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteExpiredCookies(final long currentTime,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteExpiredCookies.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, currentTime);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteExpiredCookies.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object insertCookie(final CookieEntity cookie,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __upsertionAdapterOfCookieEntity.upsert(cookie);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public List<CookieEntity> getCookiesForHost(final String host) {
    final String _sql = "SELECT * FROM cookies WHERE host = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (host == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, host);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfHost = CursorUtil.getColumnIndexOrThrow(_cursor, "host");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
      final int _cursorIndexOfExpiresAt = CursorUtil.getColumnIndexOrThrow(_cursor, "expiresAt");
      final List<CookieEntity> _result = new ArrayList<CookieEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final CookieEntity _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpHost;
        if (_cursor.isNull(_cursorIndexOfHost)) {
          _tmpHost = null;
        } else {
          _tmpHost = _cursor.getString(_cursorIndexOfHost);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpValue;
        if (_cursor.isNull(_cursorIndexOfValue)) {
          _tmpValue = null;
        } else {
          _tmpValue = _cursor.getString(_cursorIndexOfValue);
        }
        final long _tmpExpiresAt;
        _tmpExpiresAt = _cursor.getLong(_cursorIndexOfExpiresAt);
        _item = new CookieEntity(_tmpId,_tmpHost,_tmpName,_tmpValue,_tmpExpiresAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
