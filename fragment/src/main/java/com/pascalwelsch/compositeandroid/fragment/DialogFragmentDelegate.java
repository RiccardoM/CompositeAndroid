package com.pascalwelsch.compositeandroid.fragment;

import com.pascalwelsch.compositeandroid.core.AbstractDelegate;
import com.pascalwelsch.compositeandroid.core.CallFun0;
import com.pascalwelsch.compositeandroid.core.CallFun1;
import com.pascalwelsch.compositeandroid.core.CallFun2;
import com.pascalwelsch.compositeandroid.core.CallVoid0;
import com.pascalwelsch.compositeandroid.core.CallVoid1;
import com.pascalwelsch.compositeandroid.core.CallVoid2;
import com.pascalwelsch.compositeandroid.core.Removable;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.SharedElementCallback;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ListIterator;

public class DialogFragmentDelegate
        extends AbstractDelegate<ICompositeDialogFragment, DialogFragmentPlugin> {

    private final FragmentDelegate mFragmentDelegate;

    public DialogFragmentDelegate(final ICompositeDialogFragment icompositedialogfragment) {
        super(icompositedialogfragment);
        mFragmentDelegate = new FragmentDelegate(icompositedialogfragment);
    }

    public Removable addPlugin(final FragmentPlugin plugin) {
        return mFragmentDelegate.addPlugin(plugin);
    }

    @Override
    public Removable addPlugin(final DialogFragmentPlugin plugin) {
        final Removable removable = super.addPlugin(plugin);
        final Removable superRemovable = mFragmentDelegate.addPlugin(plugin);
        return new Removable() {
            @Override
            public void remove() {
                removable.remove();
                superRemovable.remove();
            }
        };
    }

    public void dismiss() {
        if (mPlugins.isEmpty()) {
            getOriginal().super_dismiss();
            return;
        }

        final ListIterator<DialogFragmentPlugin> iterator = mPlugins.listIterator(mPlugins.size());

        final CallVoid0 superCall = new CallVoid0("dismiss()") {

            @Override
            public void call() {
                if (iterator.hasPrevious()) {
                    iterator.previous().dismiss(this);
                } else {
                    getOriginal().super_dismiss();
                }
            }
        };
        superCall.call();
    }

    public void dismissAllowingStateLoss() {
        if (mPlugins.isEmpty()) {
            getOriginal().super_dismissAllowingStateLoss();
            return;
        }

        final ListIterator<DialogFragmentPlugin> iterator = mPlugins.listIterator(mPlugins.size());

        final CallVoid0 superCall = new CallVoid0("dismissAllowingStateLoss()") {

            @Override
            public void call() {
                if (iterator.hasPrevious()) {
                    iterator.previous().dismissAllowingStateLoss(this);
                } else {
                    getOriginal().super_dismissAllowingStateLoss();
                }
            }
        };
        superCall.call();
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        mFragmentDelegate.dump(prefix, fd, writer, args);
    }

    public boolean getAllowEnterTransitionOverlap() {
        return mFragmentDelegate.getAllowEnterTransitionOverlap();
    }

    public boolean getAllowReturnTransitionOverlap() {
        return mFragmentDelegate.getAllowReturnTransitionOverlap();
    }

    public Context getContext() {
        return mFragmentDelegate.getContext();
    }

    public Dialog getDialog() {
        if (mPlugins.isEmpty()) {
            return getOriginal().super_getDialog();
        }

        final ListIterator<DialogFragmentPlugin> iterator = mPlugins.listIterator(mPlugins.size());

        final CallFun0<Dialog> superCall = new CallFun0<Dialog>("getDialog()") {

            @Override
            public Dialog call() {
                if (iterator.hasPrevious()) {
                    return iterator.previous().getDialog(this);
                } else {
                    return getOriginal().super_getDialog();
                }
            }
        };
        return superCall.call();
    }

    public Object getEnterTransition() {
        return mFragmentDelegate.getEnterTransition();
    }

    public Object getExitTransition() {
        return mFragmentDelegate.getExitTransition();
    }

    public LayoutInflater getLayoutInflater(Bundle savedInstanceState) {
        return mFragmentDelegate.getLayoutInflater(savedInstanceState);
    }

    public LoaderManager getLoaderManager() {
        return mFragmentDelegate.getLoaderManager();
    }

    public Object getReenterTransition() {
        return mFragmentDelegate.getReenterTransition();
    }

    public Object getReturnTransition() {
        return mFragmentDelegate.getReturnTransition();
    }

    public Object getSharedElementEnterTransition() {
        return mFragmentDelegate.getSharedElementEnterTransition();
    }

    public Object getSharedElementReturnTransition() {
        return mFragmentDelegate.getSharedElementReturnTransition();
    }

    public boolean getShowsDialog() {
        if (mPlugins.isEmpty()) {
            return getOriginal().super_getShowsDialog();
        }

        final ListIterator<DialogFragmentPlugin> iterator = mPlugins.listIterator(mPlugins.size());

        final CallFun0<Boolean> superCall = new CallFun0<Boolean>("getShowsDialog()") {

            @Override
            public Boolean call() {
                if (iterator.hasPrevious()) {
                    return iterator.previous().getShowsDialog(this);
                } else {
                    return getOriginal().super_getShowsDialog();
                }
            }
        };
        return superCall.call();
    }

    public int getTheme() {
        if (mPlugins.isEmpty()) {
            return getOriginal().super_getTheme();
        }

        final ListIterator<DialogFragmentPlugin> iterator = mPlugins.listIterator(mPlugins.size());

        final CallFun0<Integer> superCall = new CallFun0<Integer>("getTheme()") {

            @Override
            public Integer call() {
                if (iterator.hasPrevious()) {
                    return iterator.previous().getTheme(this);
                } else {
                    return getOriginal().super_getTheme();
                }
            }
        };
        return superCall.call();
    }

    public boolean getUserVisibleHint() {
        return mFragmentDelegate.getUserVisibleHint();
    }

    public View getView() {
        return mFragmentDelegate.getView();
    }

    public boolean isCancelable() {
        if (mPlugins.isEmpty()) {
            return getOriginal().super_isCancelable();
        }

        final ListIterator<DialogFragmentPlugin> iterator = mPlugins.listIterator(mPlugins.size());

        final CallFun0<Boolean> superCall = new CallFun0<Boolean>("isCancelable()") {

            @Override
            public Boolean call() {
                if (iterator.hasPrevious()) {
                    return iterator.previous().isCancelable(this);
                } else {
                    return getOriginal().super_isCancelable();
                }
            }
        };
        return superCall.call();
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mFragmentDelegate.onActivityCreated(savedInstanceState);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mFragmentDelegate.onActivityResult(requestCode, resultCode, data);
    }

    public void onAttach(Context context) {
        mFragmentDelegate.onAttach(context);
    }

    public void onAttach(Activity activity) {
        mFragmentDelegate.onAttach(activity);
    }

    public void onAttachFragment(Fragment childFragment) {
        mFragmentDelegate.onAttachFragment(childFragment);
    }

    public void onCancel(DialogInterface dialog) {
        if (mPlugins.isEmpty()) {
            getOriginal().super_onCancel(dialog);
            return;
        }

        final ListIterator<DialogFragmentPlugin> iterator = mPlugins.listIterator(mPlugins.size());

        final CallVoid1<DialogInterface> superCall = new CallVoid1<DialogInterface>(
                "onCancel(DialogInterface)") {

            @Override
            public void call(final DialogInterface dialog) {
                if (iterator.hasPrevious()) {
                    iterator.previous().onCancel(this, dialog);
                } else {
                    getOriginal().super_onCancel(dialog);
                }
            }
        };
        superCall.call(dialog);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        mFragmentDelegate.onConfigurationChanged(newConfig);
    }

    public boolean onContextItemSelected(MenuItem item) {
        return mFragmentDelegate.onContextItemSelected(item);
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        mFragmentDelegate.onCreate(savedInstanceState);
    }

    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return mFragmentDelegate.onCreateAnimation(transit, enter, nextAnim);
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenu.ContextMenuInfo menuInfo) {
        mFragmentDelegate.onCreateContextMenu(menu, v, menuInfo);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (mPlugins.isEmpty()) {
            return getOriginal().super_onCreateDialog(savedInstanceState);
        }

        final ListIterator<DialogFragmentPlugin> iterator = mPlugins.listIterator(mPlugins.size());

        final CallFun1<Dialog, Bundle> superCall = new CallFun1<Dialog, Bundle>(
                "onCreateDialog(Bundle)") {

            @Override
            public Dialog call(final Bundle savedInstanceState) {
                if (iterator.hasPrevious()) {
                    return iterator.previous().onCreateDialog(this, savedInstanceState);
                } else {
                    return getOriginal().super_onCreateDialog(savedInstanceState);
                }
            }
        };
        return superCall.call(savedInstanceState);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        mFragmentDelegate.onCreateOptionsMenu(menu, inflater);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return mFragmentDelegate.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        mFragmentDelegate.onDestroy();
    }

    public void onDestroyOptionsMenu() {
        mFragmentDelegate.onDestroyOptionsMenu();
    }

    public void onDestroyView() {
        mFragmentDelegate.onDestroyView();
    }

    public void onDetach() {
        mFragmentDelegate.onDetach();
    }

    public void onDismiss(DialogInterface dialog) {
        if (mPlugins.isEmpty()) {
            getOriginal().super_onDismiss(dialog);
            return;
        }

        final ListIterator<DialogFragmentPlugin> iterator = mPlugins.listIterator(mPlugins.size());

        final CallVoid1<DialogInterface> superCall = new CallVoid1<DialogInterface>(
                "onDismiss(DialogInterface)") {

            @Override
            public void call(final DialogInterface dialog) {
                if (iterator.hasPrevious()) {
                    iterator.previous().onDismiss(this, dialog);
                } else {
                    getOriginal().super_onDismiss(dialog);
                }
            }
        };
        superCall.call(dialog);
    }

    public void onHiddenChanged(boolean hidden) {
        mFragmentDelegate.onHiddenChanged(hidden);
    }

    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        mFragmentDelegate.onInflate(context, attrs, savedInstanceState);
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        mFragmentDelegate.onInflate(activity, attrs, savedInstanceState);
    }

    public void onLowMemory() {
        mFragmentDelegate.onLowMemory();
    }

    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        mFragmentDelegate.onMultiWindowModeChanged(isInMultiWindowMode);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return mFragmentDelegate.onOptionsItemSelected(item);
    }

    public void onOptionsMenuClosed(Menu menu) {
        mFragmentDelegate.onOptionsMenuClosed(menu);
    }

    public void onPause() {
        mFragmentDelegate.onPause();
    }

    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        mFragmentDelegate.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        mFragmentDelegate.onPrepareOptionsMenu(menu);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
            @NonNull int[] grantResults) {
        mFragmentDelegate.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void onResume() {
        mFragmentDelegate.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        mFragmentDelegate.onSaveInstanceState(outState);
    }

    public void onStart() {
        mFragmentDelegate.onStart();
    }

    public void onStop() {
        mFragmentDelegate.onStop();
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mFragmentDelegate.onViewCreated(view, savedInstanceState);
    }

    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        mFragmentDelegate.onViewStateRestored(savedInstanceState);
    }

    public void registerForContextMenu(View view) {
        mFragmentDelegate.registerForContextMenu(view);
    }

    public void setAllowEnterTransitionOverlap(boolean allow) {
        mFragmentDelegate.setAllowEnterTransitionOverlap(allow);
    }

    public void setAllowReturnTransitionOverlap(boolean allow) {
        mFragmentDelegate.setAllowReturnTransitionOverlap(allow);
    }

    public void setArguments(Bundle args) {
        mFragmentDelegate.setArguments(args);
    }

    public void setCancelable(boolean cancelable) {
        if (mPlugins.isEmpty()) {
            getOriginal().super_setCancelable(cancelable);
            return;
        }

        final ListIterator<DialogFragmentPlugin> iterator = mPlugins.listIterator(mPlugins.size());

        final CallVoid1<Boolean> superCall = new CallVoid1<Boolean>("setCancelable(Boolean)") {

            @Override
            public void call(final Boolean cancelable) {
                if (iterator.hasPrevious()) {
                    iterator.previous().setCancelable(this, cancelable);
                } else {
                    getOriginal().super_setCancelable(cancelable);
                }
            }
        };
        superCall.call(cancelable);
    }

    public void setEnterSharedElementCallback(SharedElementCallback callback) {
        mFragmentDelegate.setEnterSharedElementCallback(callback);
    }

    public void setEnterTransition(Object transition) {
        mFragmentDelegate.setEnterTransition(transition);
    }

    public void setExitSharedElementCallback(SharedElementCallback callback) {
        mFragmentDelegate.setExitSharedElementCallback(callback);
    }

    public void setExitTransition(Object transition) {
        mFragmentDelegate.setExitTransition(transition);
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        mFragmentDelegate.setHasOptionsMenu(hasMenu);
    }

    public void setInitialSavedState(SavedState state) {
        mFragmentDelegate.setInitialSavedState(state);
    }

    public void setMenuVisibility(boolean menuVisible) {
        mFragmentDelegate.setMenuVisibility(menuVisible);
    }

    public void setReenterTransition(Object transition) {
        mFragmentDelegate.setReenterTransition(transition);
    }

    public void setRetainInstance(boolean retain) {
        mFragmentDelegate.setRetainInstance(retain);
    }

    public void setReturnTransition(Object transition) {
        mFragmentDelegate.setReturnTransition(transition);
    }

    public void setSharedElementEnterTransition(Object transition) {
        mFragmentDelegate.setSharedElementEnterTransition(transition);
    }

    public void setSharedElementReturnTransition(Object transition) {
        mFragmentDelegate.setSharedElementReturnTransition(transition);
    }

    public void setShowsDialog(boolean showsDialog) {
        if (mPlugins.isEmpty()) {
            getOriginal().super_setShowsDialog(showsDialog);
            return;
        }

        final ListIterator<DialogFragmentPlugin> iterator = mPlugins.listIterator(mPlugins.size());

        final CallVoid1<Boolean> superCall = new CallVoid1<Boolean>("setShowsDialog(Boolean)") {

            @Override
            public void call(final Boolean showsDialog) {
                if (iterator.hasPrevious()) {
                    iterator.previous().setShowsDialog(this, showsDialog);
                } else {
                    getOriginal().super_setShowsDialog(showsDialog);
                }
            }
        };
        superCall.call(showsDialog);
    }

    public void setStyle(int style, @StyleRes int theme) {
        if (mPlugins.isEmpty()) {
            getOriginal().super_setStyle(style, theme);
            return;
        }

        final ListIterator<DialogFragmentPlugin> iterator = mPlugins.listIterator(mPlugins.size());

        final CallVoid2<Integer, Integer> superCall = new CallVoid2<Integer, Integer>(
                "setStyle(Integer, Integer)") {

            @Override
            public void call(final Integer style, final Integer theme) {
                if (iterator.hasPrevious()) {
                    iterator.previous().setStyle(this, style, theme);
                } else {
                    getOriginal().super_setStyle(style, theme);
                }
            }
        };
        superCall.call(style, theme);
    }

    public void setTargetFragment(Fragment fragment, int requestCode) {
        mFragmentDelegate.setTargetFragment(fragment, requestCode);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        mFragmentDelegate.setUserVisibleHint(isVisibleToUser);
    }

    public void setupDialog(Dialog dialog, int style) {
        if (mPlugins.isEmpty()) {
            getOriginal().super_setupDialog(dialog, style);
            return;
        }

        final ListIterator<DialogFragmentPlugin> iterator = mPlugins.listIterator(mPlugins.size());

        final CallVoid2<Dialog, Integer> superCall = new CallVoid2<Dialog, Integer>(
                "setupDialog(Dialog, Integer)") {

            @Override
            public void call(final Dialog dialog, final Integer style) {
                if (iterator.hasPrevious()) {
                    iterator.previous().setupDialog(this, dialog, style);
                } else {
                    getOriginal().super_setupDialog(dialog, style);
                }
            }
        };
        superCall.call(dialog, style);
    }

    public boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        return mFragmentDelegate.shouldShowRequestPermissionRationale(permission);
    }

    public void show(FragmentManager manager, String tag) {
        if (mPlugins.isEmpty()) {
            getOriginal().super_show(manager, tag);
            return;
        }

        final ListIterator<DialogFragmentPlugin> iterator = mPlugins.listIterator(mPlugins.size());

        final CallVoid2<FragmentManager, String> superCall = new CallVoid2<FragmentManager, String>(
                "show(FragmentManager, String)") {

            @Override
            public void call(final FragmentManager manager, final String tag) {
                if (iterator.hasPrevious()) {
                    iterator.previous().show(this, manager, tag);
                } else {
                    getOriginal().super_show(manager, tag);
                }
            }
        };
        superCall.call(manager, tag);
    }

    public int show(FragmentTransaction transaction, String tag) {
        if (mPlugins.isEmpty()) {
            return getOriginal().super_show(transaction, tag);
        }

        final ListIterator<DialogFragmentPlugin> iterator = mPlugins.listIterator(mPlugins.size());

        final CallFun2<Integer, FragmentTransaction, String> superCall
                = new CallFun2<Integer, FragmentTransaction, String>(
                "show(FragmentTransaction, String)") {

            @Override
            public Integer call(final FragmentTransaction transaction, final String tag) {
                if (iterator.hasPrevious()) {
                    return iterator.previous().show(this, transaction, tag);
                } else {
                    return getOriginal().super_show(transaction, tag);
                }
            }
        };
        return superCall.call(transaction, tag);
    }

    public void startActivity(Intent intent) {
        mFragmentDelegate.startActivity(intent);
    }

    public void startActivity(Intent intent, @Nullable Bundle options) {
        mFragmentDelegate.startActivity(intent, options);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        mFragmentDelegate.startActivityForResult(intent, requestCode);
    }

    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        mFragmentDelegate.startActivityForResult(intent, requestCode, options);
    }

    public void startIntentSenderForResult(IntentSender intent, int requestCode,
            @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags,
            Bundle options) throws IntentSender.SendIntentException {
        mFragmentDelegate.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask,
                flagsValues, extraFlags, options);
    }

    public String toString() {
        return mFragmentDelegate.toString();
    }

    public void unregisterForContextMenu(View view) {
        mFragmentDelegate.unregisterForContextMenu(view);
    }


}