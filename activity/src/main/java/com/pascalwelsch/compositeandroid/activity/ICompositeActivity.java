package com.pascalwelsch.compositeandroid.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.SharedElementCallback;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Display;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toolbar;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

public interface ICompositeActivity
        extends LayoutInflater.Factory2, Window.Callback, KeyEvent.Callback,
        View.OnCreateContextMenuListener, ComponentCallbacks2,
        ActivityCompat.OnRequestPermissionsResultCallback, AppCompatCallback,
        ActionBarDrawerToggle.DelegateProvider {


    void addContentView(final View view, final ViewGroup.LayoutParams params);

    void applyOverrideConfiguration(final Configuration overrideConfiguration);

    void attachBaseContext(final Context newBase);

    boolean bindService(final Intent service, final ServiceConnection conn, final int flags);

    int checkCallingOrSelfPermission(final String permission);

    int checkCallingOrSelfUriPermission(final Uri uri, final int modeFlags);

    int checkCallingPermission(final String permission);

    int checkCallingUriPermission(final Uri uri, final int modeFlags);

    int checkPermission(final String permission, final int pid, final int uid);

    int checkSelfPermission(final String permission);

    int checkUriPermission(final Uri uri, final int pid, final int uid, final int modeFlags);

    int checkUriPermission(final Uri uri, final String readPermission, final String writePermission,
            final int pid, final int uid, final int modeFlags);

    void clearWallpaper() throws IOException;

    void closeContextMenu();

    void closeOptionsMenu();

    Context createConfigurationContext(final Configuration overrideConfiguration);

    Context createDeviceProtectedStorageContext();

    Context createDisplayContext(final Display display);

    Context createPackageContext(final String packageName, final int flags)
            throws PackageManager.NameNotFoundException;

    PendingIntent createPendingResult(final int requestCode, final Intent data, final int flags);

    String[] databaseList();

    boolean deleteDatabase(final String name);

    boolean deleteFile(final String name);

    boolean deleteSharedPreferences(final String name);

    boolean dispatchGenericMotionEvent(final MotionEvent ev);

    boolean dispatchKeyEvent(final KeyEvent event);

    boolean dispatchKeyShortcutEvent(final KeyEvent event);

    boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent event);

    boolean dispatchTouchEvent(final MotionEvent ev);

    boolean dispatchTrackballEvent(final MotionEvent ev);

    void dump(final String prefix, final FileDescriptor fd, final PrintWriter writer,
            final String[] args);

    void enforceCallingOrSelfPermission(final String permission, final String message);

    void enforceCallingOrSelfUriPermission(final Uri uri, final int modeFlags,
            final String message);

    void enforceCallingPermission(final String permission, final String message);

    void enforceCallingUriPermission(final Uri uri, final int modeFlags, final String message);

    void enforcePermission(final String permission, final int pid, final int uid,
            final String message);

    void enforceUriPermission(final Uri uri, final int pid, final int uid, final int modeFlags,
            final String message);

    void enforceUriPermission(final Uri uri, final String readPermission,
            final String writePermission, final int pid, final int uid, final int modeFlags,
            final String message);

    void enterPictureInPictureMode();

    String[] fileList();

    View findViewById(@IdRes final int id);

    void finish();

    void finishActivity(final int requestCode);

    void finishActivityFromChild(final Activity child, final int requestCode);

    void finishAffinity();

    void finishAfterTransition();

    void finishAndRemoveTask();

    void finishFromChild(final Activity child);

    android.app.ActionBar getActionBar();

    Context getApplicationContext();

    ApplicationInfo getApplicationInfo();

    AssetManager getAssets();

    Context getBaseContext();

    File getCacheDir();

    ComponentName getCallingActivity();

    String getCallingPackage();

    int getChangingConfigurations();

    ClassLoader getClassLoader();

    File getCodeCacheDir();

    ComponentName getComponentName();

    ContentResolver getContentResolver();

    Scene getContentScene();

    TransitionManager getContentTransitionManager();

    View getCurrentFocus();

    File getDataDir();

    File getDatabasePath(final String name);

    AppCompatDelegate getDelegate();

    File getDir(final String name, final int mode);

    ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

    File getExternalCacheDir();

    File[] getExternalCacheDirs();

    File getExternalFilesDir(final String type);

    File[] getExternalFilesDirs(final String type);

    File[] getExternalMediaDirs();

    File getFileStreamPath(final String name);

    File getFilesDir();

    android.app.FragmentManager getFragmentManager();

    Intent getIntent();

    Object getLastCompositeCustomNonConfigurationInstance();

    Object getLastCustomNonConfigurationInstance();

    Object getLastNonConfigurationInstance();

    LayoutInflater getLayoutInflater();

    android.app.LoaderManager getLoaderManager();

    String getLocalClassName();

    Looper getMainLooper();

    MenuInflater getMenuInflater();

    File getNoBackupFilesDir();

    File getObbDir();

    File[] getObbDirs();

    String getPackageCodePath();

    PackageManager getPackageManager();

    String getPackageName();

    String getPackageResourcePath();

    Intent getParentActivityIntent();

    SharedPreferences getPreferences(final int mode);

    Uri getReferrer();

    int getRequestedOrientation();

    Resources getResources();

    SharedPreferences getSharedPreferences(final String name, final int mode);

    ActionBar getSupportActionBar();

    FragmentManager getSupportFragmentManager();

    LoaderManager getSupportLoaderManager();

    Intent getSupportParentActivityIntent();

    Object getSystemService(final String name);

    String getSystemServiceName(final Class<?> serviceClass);

    int getTaskId();

    Resources.Theme getTheme();

    VoiceInteractor getVoiceInteractor();

    Drawable getWallpaper();

    int getWallpaperDesiredMinimumHeight();

    int getWallpaperDesiredMinimumWidth();

    Window getWindow();

    WindowManager getWindowManager();

    void grantUriPermission(final String toPackage, final Uri uri, final int modeFlags);

    boolean hasWindowFocus();

    void invalidateOptionsMenu();

    boolean isChangingConfigurations();

    boolean isDestroyed();

    boolean isDeviceProtectedStorage();

    boolean isFinishing();

    boolean isImmersive();

    boolean isInMultiWindowMode();

    boolean isInPictureInPictureMode();

    boolean isLocalVoiceInteractionSupported();

    boolean isRestricted();

    boolean isTaskRoot();

    boolean isVoiceInteraction();

    boolean isVoiceInteractionRoot();

    boolean moveDatabaseFrom(final Context sourceContext, final String name);

    boolean moveSharedPreferencesFrom(final Context sourceContext, final String name);

    boolean moveTaskToBack(final boolean nonRoot);

    boolean navigateUpTo(final Intent upIntent);

    boolean navigateUpToFromChild(final Activity child, final Intent upIntent);

    void onActionModeFinished(final android.view.ActionMode mode);

    void onActionModeStarted(final android.view.ActionMode mode);

    void onActivityReenter(final int resultCode, final Intent data);

    void onActivityResult(final int requestCode, final int resultCode, final Intent data);

    void onApplyThemeResource(final Resources.Theme theme, final int resid, final boolean first);

    void onAttachFragment(final android.app.Fragment fragment);

    void onAttachFragment(final Fragment fragment);

    void onAttachedToWindow();

    void onBackPressed();

    void onChildTitleChanged(final Activity childActivity, final CharSequence title);

    void onConfigurationChanged(final Configuration newConfig);

    void onContentChanged();

    boolean onContextItemSelected(final MenuItem item);

    void onContextMenuClosed(final Menu menu);

    void onCreate(final Bundle savedInstanceState, final PersistableBundle persistentState);

    void onCreate(@Nullable final Bundle savedInstanceState);

    void onCreateContextMenu(final ContextMenu menu, final View v,
            final ContextMenu.ContextMenuInfo menuInfo);

    CharSequence onCreateDescription();

    Dialog onCreateDialog(final int id);

    Dialog onCreateDialog(final int id, final Bundle args);

    void onCreateNavigateUpTaskStack(final TaskStackBuilder builder);

    boolean onCreateOptionsMenu(final Menu menu);

    boolean onCreatePanelMenu(final int featureId, final Menu menu);

    View onCreatePanelView(final int featureId);

    void onCreateSupportNavigateUpTaskStack(
            @NonNull final android.support.v4.app.TaskStackBuilder builder);

    boolean onCreateThumbnail(final Bitmap outBitmap, final Canvas canvas);

    View onCreateView(final View parent, final String name, final Context context,
            final AttributeSet attrs);

    View onCreateView(final String name, final Context context, final AttributeSet attrs);

    void onDestroy();

    void onDetachedFromWindow();

    void onEnterAnimationComplete();

    boolean onGenericMotionEvent(final MotionEvent event);

    boolean onKeyDown(final int keyCode, final KeyEvent event);

    boolean onKeyLongPress(final int keyCode, final KeyEvent event);

    boolean onKeyMultiple(final int keyCode, final int repeatCount, final KeyEvent event);

    boolean onKeyShortcut(final int keyCode, final KeyEvent event);

    boolean onKeyUp(final int keyCode, final KeyEvent event);

    void onLocalVoiceInteractionStarted();

    void onLocalVoiceInteractionStopped();

    void onLowMemory();

    boolean onMenuOpened(final int featureId, final Menu menu);

    void onMultiWindowModeChanged(final boolean isInMultiWindowMode);

    boolean onNavigateUp();

    boolean onNavigateUpFromChild(final Activity child);

    void onNewIntent(final Intent intent);

    boolean onOptionsItemSelected(final MenuItem item);

    void onOptionsMenuClosed(final Menu menu);

    void onPanelClosed(final int featureId, final Menu menu);

    void onPause();

    void onPictureInPictureModeChanged(final boolean isInPictureInPictureMode);

    void onPostCreate(final Bundle savedInstanceState, final PersistableBundle persistentState);

    void onPostCreate(@Nullable final Bundle savedInstanceState);

    void onPostResume();

    void onPrepareDialog(final int id, final Dialog dialog);

    void onPrepareDialog(final int id, final Dialog dialog, final Bundle args);

    void onPrepareNavigateUpTaskStack(final TaskStackBuilder builder);

    boolean onPrepareOptionsMenu(final Menu menu);

    boolean onPrepareOptionsPanel(final View view, final Menu menu);

    boolean onPreparePanel(final int featureId, final View view, final Menu menu);

    void onPrepareSupportNavigateUpTaskStack(
            @NonNull final android.support.v4.app.TaskStackBuilder builder);

    void onProvideAssistContent(final AssistContent outContent);

    void onProvideAssistData(final Bundle data);

    void onProvideKeyboardShortcuts(final List<KeyboardShortcutGroup> data, final Menu menu,
            final int deviceId);

    Uri onProvideReferrer();

    void onRequestPermissionsResult(final int requestCode, @NonNull final String[] permissions,
            @NonNull final int[] grantResults);

    void onRestart();

    void onRestoreInstanceState(final Bundle savedInstanceState,
            final PersistableBundle persistentState);

    void onRestoreInstanceState(final Bundle savedInstanceState);

    void onResume();

    void onResumeFragments();

    Object onRetainCompositeCustomNonConfigurationInstance();

    Object onRetainCustomNonConfigurationInstance();

    void onSaveInstanceState(final Bundle outState, final PersistableBundle outPersistentState);

    void onSaveInstanceState(final Bundle outState);

    boolean onSearchRequested(final SearchEvent searchEvent);

    boolean onSearchRequested();

    void onStart();

    void onStateNotSaved();

    void onStop();

    void onSupportActionModeFinished(@NonNull final ActionMode mode);

    void onSupportActionModeStarted(@NonNull final ActionMode mode);

    void onSupportContentChanged();

    boolean onSupportNavigateUp();

    void onTitleChanged(final CharSequence title, final int color);

    boolean onTouchEvent(final MotionEvent event);

    boolean onTrackballEvent(final MotionEvent event);

    void onTrimMemory(final int level);

    void onUserInteraction();

    void onUserLeaveHint();

    void onVisibleBehindCanceled();

    void onWindowAttributesChanged(final WindowManager.LayoutParams params);

    void onWindowFocusChanged(final boolean hasFocus);

    android.view.ActionMode onWindowStartingActionMode(
            final android.view.ActionMode.Callback callback);

    android.view.ActionMode onWindowStartingActionMode(
            final android.view.ActionMode.Callback callback, final int type);

    ActionMode onWindowStartingSupportActionMode(@NonNull final ActionMode.Callback callback);

    void openContextMenu(final View view);

    FileInputStream openFileInput(final String name) throws FileNotFoundException;

    FileOutputStream openFileOutput(final String name, final int mode) throws FileNotFoundException;

    void openOptionsMenu();

    SQLiteDatabase openOrCreateDatabase(final String name, final int mode,
            final SQLiteDatabase.CursorFactory factory);

    SQLiteDatabase openOrCreateDatabase(final String name, final int mode,
            final SQLiteDatabase.CursorFactory factory, final DatabaseErrorHandler errorHandler);

    void overridePendingTransition(final int enterAnim, final int exitAnim);

    Drawable peekWallpaper();

    void postponeEnterTransition();

    void recreate();

    void registerComponentCallbacks(final ComponentCallbacks callback);

    void registerForContextMenu(final View view);

    Intent registerReceiver(final BroadcastReceiver receiver, final IntentFilter filter);

    Intent registerReceiver(final BroadcastReceiver receiver, final IntentFilter filter,
            final String broadcastPermission, final Handler scheduler);

    boolean releaseInstance();

    void removeStickyBroadcast(final Intent intent);

    void removeStickyBroadcastAsUser(final Intent intent, final UserHandle user);

    void reportFullyDrawn();

    DragAndDropPermissions requestDragAndDropPermissions(final DragEvent event);

    boolean requestVisibleBehind(final boolean visible);

    void revokeUriPermission(final Uri uri, final int modeFlags);

    void sendBroadcast(final Intent intent);

    void sendBroadcast(final Intent intent, final String receiverPermission);

    void sendBroadcastAsUser(final Intent intent, final UserHandle user);

    void sendBroadcastAsUser(final Intent intent, final UserHandle user,
            final String receiverPermission);

    void sendOrderedBroadcast(final Intent intent, final String receiverPermission);

    void sendOrderedBroadcast(final Intent intent, final String receiverPermission,
            final BroadcastReceiver resultReceiver, final Handler scheduler, final int initialCode,
            final String initialData, final Bundle initialExtras);

    void sendOrderedBroadcastAsUser(final Intent intent, final UserHandle user,
            final String receiverPermission, final BroadcastReceiver resultReceiver,
            final Handler scheduler, final int initialCode, final String initialData,
            final Bundle initialExtras);

    void sendStickyBroadcast(final Intent intent);

    void sendStickyBroadcastAsUser(final Intent intent, final UserHandle user);

    void sendStickyOrderedBroadcast(final Intent intent, final BroadcastReceiver resultReceiver,
            final Handler scheduler, final int initialCode, final String initialData,
            final Bundle initialExtras);

    void sendStickyOrderedBroadcastAsUser(final Intent intent, final UserHandle user,
            final BroadcastReceiver resultReceiver, final Handler scheduler, final int initialCode,
            final String initialData, final Bundle initialExtras);

    void setActionBar(final Toolbar toolbar);

    void setContentTransitionManager(final TransitionManager tm);

    void setContentView(@LayoutRes final int layoutResID);

    void setContentView(final View view);

    void setContentView(final View view, final ViewGroup.LayoutParams params);

    void setEnterSharedElementCallback(final SharedElementCallback callback);

    void setEnterSharedElementCallback(final android.app.SharedElementCallback callback);

    void setExitSharedElementCallback(final SharedElementCallback listener);

    void setExitSharedElementCallback(final android.app.SharedElementCallback callback);

    void setFinishOnTouchOutside(final boolean finish);

    void setImmersive(final boolean i);

    void setIntent(final Intent newIntent);

    void setRequestedOrientation(final int requestedOrientation);

    void setSupportActionBar(@Nullable final android.support.v7.widget.Toolbar toolbar);

    void setSupportProgress(final int progress);

    void setSupportProgressBarIndeterminate(final boolean indeterminate);

    void setSupportProgressBarIndeterminateVisibility(final boolean visible);

    void setSupportProgressBarVisibility(final boolean visible);

    void setTaskDescription(final ActivityManager.TaskDescription taskDescription);

    void setTheme(@StyleRes final int resid);

    void setTitle(final CharSequence title);

    void setTitle(final int titleId);

    void setTitleColor(final int textColor);

    void setVisible(final boolean visible);

    void setVrModeEnabled(final boolean enabled, final ComponentName requestedComponent)
            throws PackageManager.NameNotFoundException;

    void setWallpaper(final Bitmap bitmap) throws IOException;

    void setWallpaper(final InputStream data) throws IOException;

    boolean shouldShowRequestPermissionRationale(final String permission);

    boolean shouldUpRecreateTask(final Intent targetIntent);

    boolean showAssist(final Bundle args);

    void showLockTaskEscapeMessage();

    android.view.ActionMode startActionMode(final android.view.ActionMode.Callback callback);

    android.view.ActionMode startActionMode(final android.view.ActionMode.Callback callback,
            final int type);

    void startActivities(final Intent[] intents);

    void startActivities(final Intent[] intents, final Bundle options);

    void startActivity(final Intent intent);

    void startActivity(final Intent intent, final Bundle options);

    void startActivityForResult(final Intent intent, final int requestCode,
            @Nullable final Bundle options);

    void startActivityForResult(final Intent intent, final int requestCode);

    void startActivityFromChild(final Activity child, final Intent intent, final int requestCode);

    void startActivityFromChild(final Activity child, final Intent intent, final int requestCode,
            final Bundle options);

    void startActivityFromFragment(final android.app.Fragment fragment, final Intent intent,
            final int requestCode);

    void startActivityFromFragment(final android.app.Fragment fragment, final Intent intent,
            final int requestCode, final Bundle options);

    void startActivityFromFragment(final Fragment fragment, final Intent intent,
            final int requestCode);

    void startActivityFromFragment(final Fragment fragment, final Intent intent,
            final int requestCode, @Nullable final Bundle options);

    boolean startActivityIfNeeded(final Intent intent, final int requestCode);

    boolean startActivityIfNeeded(final Intent intent, final int requestCode, final Bundle options);

    boolean startInstrumentation(final ComponentName className, final String profileFile,
            final Bundle arguments);

    void startIntentSender(final IntentSender intent, final Intent fillInIntent,
            final int flagsMask, final int flagsValues, final int extraFlags)
            throws IntentSender.SendIntentException;

    void startIntentSender(final IntentSender intent, final Intent fillInIntent,
            final int flagsMask, final int flagsValues, final int extraFlags, final Bundle options)
            throws IntentSender.SendIntentException;

    void startIntentSenderForResult(final IntentSender intent, final int requestCode,
            @Nullable final Intent fillInIntent, final int flagsMask, final int flagsValues,
            final int extraFlags, final Bundle options) throws IntentSender.SendIntentException;

    void startIntentSenderForResult(final IntentSender intent, final int requestCode,
            @Nullable final Intent fillInIntent, final int flagsMask, final int flagsValues,
            final int extraFlags) throws IntentSender.SendIntentException;

    void startIntentSenderFromChild(final Activity child, final IntentSender intent,
            final int requestCode, final Intent fillInIntent, final int flagsMask,
            final int flagsValues, final int extraFlags) throws IntentSender.SendIntentException;

    void startIntentSenderFromChild(final Activity child, final IntentSender intent,
            final int requestCode, final Intent fillInIntent, final int flagsMask,
            final int flagsValues, final int extraFlags, final Bundle options)
            throws IntentSender.SendIntentException;

    void startIntentSenderFromFragment(final Fragment fragment, final IntentSender intent,
            final int requestCode, @Nullable final Intent fillInIntent, final int flagsMask,
            final int flagsValues, final int extraFlags, final Bundle options)
            throws IntentSender.SendIntentException;

    void startLocalVoiceInteraction(final Bundle privateOptions);

    void startLockTask();

    void startManagingCursor(final Cursor c);

    boolean startNextMatchingActivity(final Intent intent);

    boolean startNextMatchingActivity(final Intent intent, final Bundle options);

    void startPostponedEnterTransition();

    void startSearch(final String initialQuery, final boolean selectInitialQuery,
            final Bundle appSearchData, final boolean globalSearch);

    ComponentName startService(final Intent service);

    ActionMode startSupportActionMode(@NonNull final ActionMode.Callback callback);

    void stopLocalVoiceInteraction();

    void stopLockTask();

    void stopManagingCursor(final Cursor c);

    boolean stopService(final Intent name);

    void super_addContentView(final View view, final ViewGroup.LayoutParams params);

    void super_applyOverrideConfiguration(final Configuration overrideConfiguration);

    void super_attachBaseContext(final Context newBase);

    boolean super_bindService(final Intent service, final ServiceConnection conn, final int flags);

    int super_checkCallingOrSelfPermission(final String permission);

    int super_checkCallingOrSelfUriPermission(final Uri uri, final int modeFlags);

    int super_checkCallingPermission(final String permission);

    int super_checkCallingUriPermission(final Uri uri, final int modeFlags);

    int super_checkPermission(final String permission, final int pid, final int uid);

    int super_checkSelfPermission(final String permission);

    int super_checkUriPermission(final Uri uri, final int pid, final int uid, final int modeFlags);

    int super_checkUriPermission(final Uri uri, final String readPermission,
            final String writePermission, final int pid, final int uid, final int modeFlags);

    void super_clearWallpaper() throws IOException;

    void super_closeContextMenu();

    void super_closeOptionsMenu();

    Context super_createConfigurationContext(final Configuration overrideConfiguration);

    Context super_createDeviceProtectedStorageContext();

    Context super_createDisplayContext(final Display display);

    Context super_createPackageContext(final String packageName, final int flags)
            throws PackageManager.NameNotFoundException;

    PendingIntent super_createPendingResult(final int requestCode, final Intent data,
            final int flags);

    String[] super_databaseList();

    boolean super_deleteDatabase(final String name);

    boolean super_deleteFile(final String name);

    boolean super_deleteSharedPreferences(final String name);

    boolean super_dispatchGenericMotionEvent(final MotionEvent ev);

    boolean super_dispatchKeyEvent(final KeyEvent event);

    boolean super_dispatchKeyShortcutEvent(final KeyEvent event);

    boolean super_dispatchPopulateAccessibilityEvent(final AccessibilityEvent event);

    boolean super_dispatchTouchEvent(final MotionEvent ev);

    boolean super_dispatchTrackballEvent(final MotionEvent ev);

    void super_dump(final String prefix, final FileDescriptor fd, final PrintWriter writer,
            final String[] args);

    void super_enforceCallingOrSelfPermission(final String permission, final String message);

    void super_enforceCallingOrSelfUriPermission(final Uri uri, final int modeFlags,
            final String message);

    void super_enforceCallingPermission(final String permission, final String message);

    void super_enforceCallingUriPermission(final Uri uri, final int modeFlags,
            final String message);

    void super_enforcePermission(final String permission, final int pid, final int uid,
            final String message);

    void super_enforceUriPermission(final Uri uri, final int pid, final int uid,
            final int modeFlags, final String message);

    void super_enforceUriPermission(final Uri uri, final String readPermission,
            final String writePermission, final int pid, final int uid, final int modeFlags,
            final String message);

    void super_enterPictureInPictureMode();

    String[] super_fileList();

    View super_findViewById(@IdRes final int id);

    void super_finish();

    void super_finishActivity(final int requestCode);

    void super_finishActivityFromChild(final Activity child, final int requestCode);

    void super_finishAffinity();

    void super_finishAfterTransition();

    void super_finishAndRemoveTask();

    void super_finishFromChild(final Activity child);

    android.app.ActionBar super_getActionBar();

    Context super_getApplicationContext();

    ApplicationInfo super_getApplicationInfo();

    AssetManager super_getAssets();

    Context super_getBaseContext();

    File super_getCacheDir();

    ComponentName super_getCallingActivity();

    String super_getCallingPackage();

    int super_getChangingConfigurations();

    ClassLoader super_getClassLoader();

    File super_getCodeCacheDir();

    ComponentName super_getComponentName();

    ContentResolver super_getContentResolver();

    Scene super_getContentScene();

    TransitionManager super_getContentTransitionManager();

    View super_getCurrentFocus();

    File super_getDataDir();

    File super_getDatabasePath(final String name);

    AppCompatDelegate super_getDelegate();

    File super_getDir(final String name, final int mode);

    ActionBarDrawerToggle.Delegate super_getDrawerToggleDelegate();

    File super_getExternalCacheDir();

    File[] super_getExternalCacheDirs();

    File super_getExternalFilesDir(final String type);

    File[] super_getExternalFilesDirs(final String type);

    File[] super_getExternalMediaDirs();

    File super_getFileStreamPath(final String name);

    File super_getFilesDir();

    android.app.FragmentManager super_getFragmentManager();

    Intent super_getIntent();

    LayoutInflater super_getLayoutInflater();

    android.app.LoaderManager super_getLoaderManager();

    String super_getLocalClassName();

    Looper super_getMainLooper();

    MenuInflater super_getMenuInflater();

    File super_getNoBackupFilesDir();

    File super_getObbDir();

    File[] super_getObbDirs();

    String super_getPackageCodePath();

    PackageManager super_getPackageManager();

    String super_getPackageName();

    String super_getPackageResourcePath();

    Intent super_getParentActivityIntent();

    SharedPreferences super_getPreferences(final int mode);

    Uri super_getReferrer();

    int super_getRequestedOrientation();

    Resources super_getResources();

    SharedPreferences super_getSharedPreferences(final String name, final int mode);

    ActionBar super_getSupportActionBar();

    FragmentManager super_getSupportFragmentManager();

    LoaderManager super_getSupportLoaderManager();

    Intent super_getSupportParentActivityIntent();

    Object super_getSystemService(final String name);

    String super_getSystemServiceName(final Class<?> serviceClass);

    int super_getTaskId();

    Resources.Theme super_getTheme();

    VoiceInteractor super_getVoiceInteractor();

    Drawable super_getWallpaper();

    int super_getWallpaperDesiredMinimumHeight();

    int super_getWallpaperDesiredMinimumWidth();

    Window super_getWindow();

    WindowManager super_getWindowManager();

    void super_grantUriPermission(final String toPackage, final Uri uri, final int modeFlags);

    boolean super_hasWindowFocus();

    void super_invalidateOptionsMenu();

    boolean super_isChangingConfigurations();

    boolean super_isDestroyed();

    boolean super_isDeviceProtectedStorage();

    boolean super_isFinishing();

    boolean super_isImmersive();

    boolean super_isInMultiWindowMode();

    boolean super_isInPictureInPictureMode();

    boolean super_isLocalVoiceInteractionSupported();

    boolean super_isRestricted();

    boolean super_isTaskRoot();

    boolean super_isVoiceInteraction();

    boolean super_isVoiceInteractionRoot();

    boolean super_moveDatabaseFrom(final Context sourceContext, final String name);

    boolean super_moveSharedPreferencesFrom(final Context sourceContext, final String name);

    boolean super_moveTaskToBack(final boolean nonRoot);

    boolean super_navigateUpTo(final Intent upIntent);

    boolean super_navigateUpToFromChild(final Activity child, final Intent upIntent);

    void super_onActionModeFinished(final android.view.ActionMode mode);

    void super_onActionModeStarted(final android.view.ActionMode mode);

    void super_onActivityReenter(final int resultCode, final Intent data);

    void super_onActivityResult(final int requestCode, final int resultCode, final Intent data);

    void super_onApplyThemeResource(final Resources.Theme theme, final int resid,
            final boolean first);

    void super_onAttachFragment(final android.app.Fragment fragment);

    void super_onAttachFragment(final Fragment fragment);

    void super_onAttachedToWindow();

    void super_onBackPressed();

    void super_onChildTitleChanged(final Activity childActivity, final CharSequence title);

    void super_onConfigurationChanged(final Configuration newConfig);

    void super_onContentChanged();

    boolean super_onContextItemSelected(final MenuItem item);

    void super_onContextMenuClosed(final Menu menu);

    void super_onCreate(final Bundle savedInstanceState, final PersistableBundle persistentState);

    void super_onCreate(@Nullable final Bundle savedInstanceState);

    void super_onCreateContextMenu(final ContextMenu menu, final View v,
            final ContextMenu.ContextMenuInfo menuInfo);

    CharSequence super_onCreateDescription();

    Dialog super_onCreateDialog(final int id);

    Dialog super_onCreateDialog(final int id, final Bundle args);

    void super_onCreateNavigateUpTaskStack(final TaskStackBuilder builder);

    boolean super_onCreateOptionsMenu(final Menu menu);

    boolean super_onCreatePanelMenu(final int featureId, final Menu menu);

    View super_onCreatePanelView(final int featureId);

    void super_onCreateSupportNavigateUpTaskStack(
            @NonNull final android.support.v4.app.TaskStackBuilder builder);

    boolean super_onCreateThumbnail(final Bitmap outBitmap, final Canvas canvas);

    View super_onCreateView(final View parent, final String name, final Context context,
            final AttributeSet attrs);

    View super_onCreateView(final String name, final Context context, final AttributeSet attrs);

    void super_onDestroy();

    void super_onDetachedFromWindow();

    void super_onEnterAnimationComplete();

    boolean super_onGenericMotionEvent(final MotionEvent event);

    boolean super_onKeyDown(final int keyCode, final KeyEvent event);

    boolean super_onKeyLongPress(final int keyCode, final KeyEvent event);

    boolean super_onKeyMultiple(final int keyCode, final int repeatCount, final KeyEvent event);

    boolean super_onKeyShortcut(final int keyCode, final KeyEvent event);

    boolean super_onKeyUp(final int keyCode, final KeyEvent event);

    void super_onLocalVoiceInteractionStarted();

    void super_onLocalVoiceInteractionStopped();

    void super_onLowMemory();

    boolean super_onMenuOpened(final int featureId, final Menu menu);

    void super_onMultiWindowModeChanged(final boolean isInMultiWindowMode);

    boolean super_onNavigateUp();

    boolean super_onNavigateUpFromChild(final Activity child);

    void super_onNewIntent(final Intent intent);

    boolean super_onOptionsItemSelected(final MenuItem item);

    void super_onOptionsMenuClosed(final Menu menu);

    void super_onPanelClosed(final int featureId, final Menu menu);

    void super_onPause();

    void super_onPictureInPictureModeChanged(final boolean isInPictureInPictureMode);

    void super_onPostCreate(final Bundle savedInstanceState,
            final PersistableBundle persistentState);

    void super_onPostCreate(@Nullable final Bundle savedInstanceState);

    void super_onPostResume();

    void super_onPrepareDialog(final int id, final Dialog dialog);

    void super_onPrepareDialog(final int id, final Dialog dialog, final Bundle args);

    void super_onPrepareNavigateUpTaskStack(final TaskStackBuilder builder);

    boolean super_onPrepareOptionsMenu(final Menu menu);

    boolean super_onPrepareOptionsPanel(final View view, final Menu menu);

    boolean super_onPreparePanel(final int featureId, final View view, final Menu menu);

    void super_onPrepareSupportNavigateUpTaskStack(
            @NonNull final android.support.v4.app.TaskStackBuilder builder);

    void super_onProvideAssistContent(final AssistContent outContent);

    void super_onProvideAssistData(final Bundle data);

    void super_onProvideKeyboardShortcuts(final List<KeyboardShortcutGroup> data, final Menu menu,
            final int deviceId);

    Uri super_onProvideReferrer();

    void super_onRequestPermissionsResult(final int requestCode,
            @NonNull final String[] permissions, @NonNull final int[] grantResults);

    void super_onRestart();

    void super_onRestoreInstanceState(final Bundle savedInstanceState,
            final PersistableBundle persistentState);

    void super_onRestoreInstanceState(final Bundle savedInstanceState);

    void super_onResume();

    void super_onResumeFragments();

    void super_onSaveInstanceState(final Bundle outState,
            final PersistableBundle outPersistentState);

    void super_onSaveInstanceState(final Bundle outState);

    boolean super_onSearchRequested(final SearchEvent searchEvent);

    boolean super_onSearchRequested();

    void super_onStart();

    void super_onStateNotSaved();

    void super_onStop();

    void super_onSupportActionModeFinished(@NonNull final ActionMode mode);

    void super_onSupportActionModeStarted(@NonNull final ActionMode mode);

    void super_onSupportContentChanged();

    boolean super_onSupportNavigateUp();

    void super_onTitleChanged(final CharSequence title, final int color);

    boolean super_onTouchEvent(final MotionEvent event);

    boolean super_onTrackballEvent(final MotionEvent event);

    void super_onTrimMemory(final int level);

    void super_onUserInteraction();

    void super_onUserLeaveHint();

    void super_onVisibleBehindCanceled();

    void super_onWindowAttributesChanged(final WindowManager.LayoutParams params);

    void super_onWindowFocusChanged(final boolean hasFocus);

    android.view.ActionMode super_onWindowStartingActionMode(
            final android.view.ActionMode.Callback callback);

    android.view.ActionMode super_onWindowStartingActionMode(
            final android.view.ActionMode.Callback callback, final int type);

    ActionMode super_onWindowStartingSupportActionMode(@NonNull final ActionMode.Callback callback);

    void super_openContextMenu(final View view);

    FileInputStream super_openFileInput(final String name) throws FileNotFoundException;

    FileOutputStream super_openFileOutput(final String name, final int mode)
            throws FileNotFoundException;

    void super_openOptionsMenu();

    SQLiteDatabase super_openOrCreateDatabase(final String name, final int mode,
            final SQLiteDatabase.CursorFactory factory);

    SQLiteDatabase super_openOrCreateDatabase(final String name, final int mode,
            final SQLiteDatabase.CursorFactory factory, final DatabaseErrorHandler errorHandler);

    void super_overridePendingTransition(final int enterAnim, final int exitAnim);

    Drawable super_peekWallpaper();

    void super_postponeEnterTransition();

    void super_recreate();

    void super_registerComponentCallbacks(final ComponentCallbacks callback);

    void super_registerForContextMenu(final View view);

    Intent super_registerReceiver(final BroadcastReceiver receiver, final IntentFilter filter);

    Intent super_registerReceiver(final BroadcastReceiver receiver, final IntentFilter filter,
            final String broadcastPermission, final Handler scheduler);

    boolean super_releaseInstance();

    void super_removeStickyBroadcast(final Intent intent);

    void super_removeStickyBroadcastAsUser(final Intent intent, final UserHandle user);

    void super_reportFullyDrawn();

    DragAndDropPermissions super_requestDragAndDropPermissions(final DragEvent event);

    boolean super_requestVisibleBehind(final boolean visible);

    void super_revokeUriPermission(final Uri uri, final int modeFlags);

    void super_sendBroadcast(final Intent intent);

    void super_sendBroadcast(final Intent intent, final String receiverPermission);

    void super_sendBroadcastAsUser(final Intent intent, final UserHandle user);

    void super_sendBroadcastAsUser(final Intent intent, final UserHandle user,
            final String receiverPermission);

    void super_sendOrderedBroadcast(final Intent intent, final String receiverPermission);

    void super_sendOrderedBroadcast(final Intent intent, final String receiverPermission,
            final BroadcastReceiver resultReceiver, final Handler scheduler, final int initialCode,
            final String initialData, final Bundle initialExtras);

    void super_sendOrderedBroadcastAsUser(final Intent intent, final UserHandle user,
            final String receiverPermission, final BroadcastReceiver resultReceiver,
            final Handler scheduler, final int initialCode, final String initialData,
            final Bundle initialExtras);

    void super_sendStickyBroadcast(final Intent intent);

    void super_sendStickyBroadcastAsUser(final Intent intent, final UserHandle user);

    void super_sendStickyOrderedBroadcast(final Intent intent,
            final BroadcastReceiver resultReceiver, final Handler scheduler, final int initialCode,
            final String initialData, final Bundle initialExtras);

    void super_sendStickyOrderedBroadcastAsUser(final Intent intent, final UserHandle user,
            final BroadcastReceiver resultReceiver, final Handler scheduler, final int initialCode,
            final String initialData, final Bundle initialExtras);

    void super_setActionBar(final Toolbar toolbar);

    void super_setContentTransitionManager(final TransitionManager tm);

    void super_setContentView(@LayoutRes final int layoutResID);

    void super_setContentView(final View view);

    void super_setContentView(final View view, final ViewGroup.LayoutParams params);

    void super_setEnterSharedElementCallback(final SharedElementCallback callback);

    void super_setEnterSharedElementCallback(final android.app.SharedElementCallback callback);

    void super_setExitSharedElementCallback(final SharedElementCallback listener);

    void super_setExitSharedElementCallback(final android.app.SharedElementCallback callback);

    void super_setFinishOnTouchOutside(final boolean finish);

    void super_setImmersive(final boolean i);

    void super_setIntent(final Intent newIntent);

    void super_setRequestedOrientation(final int requestedOrientation);

    void super_setSupportActionBar(@Nullable final android.support.v7.widget.Toolbar toolbar);

    void super_setSupportProgress(final int progress);

    void super_setSupportProgressBarIndeterminate(final boolean indeterminate);

    void super_setSupportProgressBarIndeterminateVisibility(final boolean visible);

    void super_setSupportProgressBarVisibility(final boolean visible);

    void super_setTaskDescription(final ActivityManager.TaskDescription taskDescription);

    void super_setTheme(@StyleRes final int resid);

    void super_setTitle(final CharSequence title);

    void super_setTitle(final int titleId);

    void super_setTitleColor(final int textColor);

    void super_setVisible(final boolean visible);

    void super_setVrModeEnabled(final boolean enabled, final ComponentName requestedComponent)
            throws PackageManager.NameNotFoundException;

    void super_setWallpaper(final Bitmap bitmap) throws IOException;

    void super_setWallpaper(final InputStream data) throws IOException;

    boolean super_shouldShowRequestPermissionRationale(final String permission);

    boolean super_shouldUpRecreateTask(final Intent targetIntent);

    boolean super_showAssist(final Bundle args);

    void super_showLockTaskEscapeMessage();

    android.view.ActionMode super_startActionMode(final android.view.ActionMode.Callback callback);

    android.view.ActionMode super_startActionMode(final android.view.ActionMode.Callback callback,
            final int type);

    void super_startActivities(final Intent[] intents);

    void super_startActivities(final Intent[] intents, final Bundle options);

    void super_startActivity(final Intent intent);

    void super_startActivity(final Intent intent, final Bundle options);

    void super_startActivityForResult(final Intent intent, final int requestCode,
            @Nullable final Bundle options);

    void super_startActivityForResult(final Intent intent, final int requestCode);

    void super_startActivityFromChild(final Activity child, final Intent intent,
            final int requestCode);

    void super_startActivityFromChild(final Activity child, final Intent intent,
            final int requestCode, final Bundle options);

    void super_startActivityFromFragment(final android.app.Fragment fragment, final Intent intent,
            final int requestCode);

    void super_startActivityFromFragment(final android.app.Fragment fragment, final Intent intent,
            final int requestCode, final Bundle options);

    void super_startActivityFromFragment(final Fragment fragment, final Intent intent,
            final int requestCode);

    void super_startActivityFromFragment(final Fragment fragment, final Intent intent,
            final int requestCode, @Nullable final Bundle options);

    boolean super_startActivityIfNeeded(final Intent intent, final int requestCode);

    boolean super_startActivityIfNeeded(final Intent intent, final int requestCode,
            final Bundle options);

    boolean super_startInstrumentation(final ComponentName className, final String profileFile,
            final Bundle arguments);

    void super_startIntentSender(final IntentSender intent, final Intent fillInIntent,
            final int flagsMask, final int flagsValues, final int extraFlags)
            throws IntentSender.SendIntentException;

    void super_startIntentSender(final IntentSender intent, final Intent fillInIntent,
            final int flagsMask, final int flagsValues, final int extraFlags, final Bundle options)
            throws IntentSender.SendIntentException;

    void super_startIntentSenderForResult(final IntentSender intent, final int requestCode,
            @Nullable final Intent fillInIntent, final int flagsMask, final int flagsValues,
            final int extraFlags, final Bundle options) throws IntentSender.SendIntentException;

    void super_startIntentSenderForResult(final IntentSender intent, final int requestCode,
            @Nullable final Intent fillInIntent, final int flagsMask, final int flagsValues,
            final int extraFlags) throws IntentSender.SendIntentException;

    void super_startIntentSenderFromChild(final Activity child, final IntentSender intent,
            final int requestCode, final Intent fillInIntent, final int flagsMask,
            final int flagsValues, final int extraFlags) throws IntentSender.SendIntentException;

    void super_startIntentSenderFromChild(final Activity child, final IntentSender intent,
            final int requestCode, final Intent fillInIntent, final int flagsMask,
            final int flagsValues, final int extraFlags, final Bundle options)
            throws IntentSender.SendIntentException;

    void super_startIntentSenderFromFragment(final Fragment fragment, final IntentSender intent,
            final int requestCode, @Nullable final Intent fillInIntent, final int flagsMask,
            final int flagsValues, final int extraFlags, final Bundle options)
            throws IntentSender.SendIntentException;

    void super_startLocalVoiceInteraction(final Bundle privateOptions);

    void super_startLockTask();

    void super_startManagingCursor(final Cursor c);

    boolean super_startNextMatchingActivity(final Intent intent);

    boolean super_startNextMatchingActivity(final Intent intent, final Bundle options);

    void super_startPostponedEnterTransition();

    void super_startSearch(final String initialQuery, final boolean selectInitialQuery,
            final Bundle appSearchData, final boolean globalSearch);

    ComponentName super_startService(final Intent service);

    ActionMode super_startSupportActionMode(@NonNull final ActionMode.Callback callback);

    void super_stopLocalVoiceInteraction();

    void super_stopLockTask();

    void super_stopManagingCursor(final Cursor c);

    boolean super_stopService(final Intent name);

    void super_supportFinishAfterTransition();

    void super_supportInvalidateOptionsMenu();

    void super_supportNavigateUpTo(@NonNull final Intent upIntent);

    void super_supportPostponeEnterTransition();

    boolean super_supportRequestWindowFeature(final int featureId);

    boolean super_supportShouldUpRecreateTask(@NonNull final Intent targetIntent);

    void super_supportStartPostponedEnterTransition();

    void super_takeKeyEvents(final boolean get);

    void super_triggerSearch(final String query, final Bundle appSearchData);

    void super_unbindService(final ServiceConnection conn);

    void super_unregisterComponentCallbacks(final ComponentCallbacks callback);

    void super_unregisterForContextMenu(final View view);

    void super_unregisterReceiver(final BroadcastReceiver receiver);

    void supportFinishAfterTransition();

    void supportInvalidateOptionsMenu();

    void supportNavigateUpTo(@NonNull final Intent upIntent);

    void supportPostponeEnterTransition();

    boolean supportRequestWindowFeature(final int featureId);

    boolean supportShouldUpRecreateTask(@NonNull final Intent targetIntent);

    void supportStartPostponedEnterTransition();

    void takeKeyEvents(final boolean get);

    void triggerSearch(final String query, final Bundle appSearchData);

    void unbindService(final ServiceConnection conn);

    void unregisterComponentCallbacks(final ComponentCallbacks callback);

    void unregisterForContextMenu(final View view);

    void unregisterReceiver(final BroadcastReceiver receiver);
}
