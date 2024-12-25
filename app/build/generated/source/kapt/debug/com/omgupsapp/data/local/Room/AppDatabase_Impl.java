package com.omgupsapp.data.local.Room;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.omgupsandroidapp.data.local.Room.Cache.DataScheduleDao;
import com.example.omgupsandroidapp.data.local.Room.Cache.DataScheduleDao_Impl;
import com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao;
import com.example.omgupsandroidapp.data.local.Room.Cookie.CookieDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile CookieDao _cookieDao;

  private volatile DataScheduleDao _dataScheduleDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `cookies` (`host` TEXT NOT NULL, `name` TEXT NOT NULL, `value` TEXT NOT NULL, `expiresAt` INTEGER NOT NULL, PRIMARY KEY(`name`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `schedule` (`day_of_week` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sgroup` TEXT NOT NULL, `subj` TEXT NOT NULL, `time` INTEGER NOT NULL, `type_of_week` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '68684130a4cd2a7943a52fdfda00bad4')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `cookies`");
        db.execSQL("DROP TABLE IF EXISTS `schedule`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsCookies = new HashMap<String, TableInfo.Column>(4);
        _columnsCookies.put("host", new TableInfo.Column("host", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCookies.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCookies.put("value", new TableInfo.Column("value", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCookies.put("expiresAt", new TableInfo.Column("expiresAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCookies = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCookies = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCookies = new TableInfo("cookies", _columnsCookies, _foreignKeysCookies, _indicesCookies);
        final TableInfo _existingCookies = TableInfo.read(db, "cookies");
        if (!_infoCookies.equals(_existingCookies)) {
          return new RoomOpenHelper.ValidationResult(false, "cookies(com.example.omgupsandroidapp.data.local.Room.Cookie.CookieEntity).\n"
                  + " Expected:\n" + _infoCookies + "\n"
                  + " Found:\n" + _existingCookies);
        }
        final HashMap<String, TableInfo.Column> _columnsSchedule = new HashMap<String, TableInfo.Column>(6);
        _columnsSchedule.put("day_of_week", new TableInfo.Column("day_of_week", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSchedule.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSchedule.put("sgroup", new TableInfo.Column("sgroup", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSchedule.put("subj", new TableInfo.Column("subj", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSchedule.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSchedule.put("type_of_week", new TableInfo.Column("type_of_week", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSchedule = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSchedule = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSchedule = new TableInfo("schedule", _columnsSchedule, _foreignKeysSchedule, _indicesSchedule);
        final TableInfo _existingSchedule = TableInfo.read(db, "schedule");
        if (!_infoSchedule.equals(_existingSchedule)) {
          return new RoomOpenHelper.ValidationResult(false, "schedule(com.example.omgupsandroidapp.data.local.Room.Cache.ScheduleEntity).\n"
                  + " Expected:\n" + _infoSchedule + "\n"
                  + " Found:\n" + _existingSchedule);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "68684130a4cd2a7943a52fdfda00bad4", "10e771f23097283b04101457612db791");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "cookies","schedule");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `cookies`");
      _db.execSQL("DELETE FROM `schedule`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CookieDao.class, CookieDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(DataScheduleDao.class, DataScheduleDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public CookieDao cookieDao() {
    if (_cookieDao != null) {
      return _cookieDao;
    } else {
      synchronized(this) {
        if(_cookieDao == null) {
          _cookieDao = new CookieDao_Impl(this);
        }
        return _cookieDao;
      }
    }
  }

  @Override
  public DataScheduleDao dataScheduleDao() {
    if (_dataScheduleDao != null) {
      return _dataScheduleDao;
    } else {
      synchronized(this) {
        if(_dataScheduleDao == null) {
          _dataScheduleDao = new DataScheduleDao_Impl(this);
        }
        return _dataScheduleDao;
      }
    }
  }
}
