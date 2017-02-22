package com.pascalwelsch.compositeandroid.fragment;

import com.pascalwelsch.compositeandroid.core.CallFun0;
import com.pascalwelsch.compositeandroid.core.CallFun1;
import com.pascalwelsch.compositeandroid.core.CallFun2;
import com.pascalwelsch.compositeandroid.core.CallVoid0;
import com.pascalwelsch.compositeandroid.core.CallVoid1;
import com.pascalwelsch.compositeandroid.core.CallVoid2;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;


@SuppressWarnings("unused")
public class DialogFragmentPlugin extends FragmentPlugin {

    /**
     * Dismiss the fragment and its dialog.  If the fragment was added to the
     * back stack, all back stack state up to and including this entry will
     * be popped.  Otherwise, a new transaction will be committed to remove
     * the fragment.
     */
    public void dismiss() {
        verifyMethodCalledFromDelegate("dismiss()");
        ((CallVoid0) mSuperListeners.pop()).call();
    }

    /**
     * Version of {@link #dismiss()} that uses
     * {@link FragmentTransaction#commitAllowingStateLoss()
     * FragmentTransaction.commitAllowingStateLoss()}. See linked
     * documentation for further details.
     */
    public void dismissAllowingStateLoss() {
        verifyMethodCalledFromDelegate("dismissAllowingStateLoss()");
        ((CallVoid0) mSuperListeners.pop()).call();
    }

    public Dialog getDialog() {
        verifyMethodCalledFromDelegate("getDialog()");
        return ((CallFun0<Dialog>) mSuperListeners.pop()).call();
    }

    public DialogFragment getDialogFragment() {
        return (DialogFragment) getOriginal();
    }

    /**
     * @hide
     */
    public LayoutInflater getLayoutInflater(final Bundle savedInstanceState) {
        verifyMethodCalledFromDelegate("getLayoutInflater(Bundle)");
        return ((CallFun1<LayoutInflater, Bundle>) mSuperListeners.pop()).call(savedInstanceState);
    }

    /**
     * Return the current value of {@link #setShowsDialog(boolean)}.
     */
    public boolean getShowsDialog() {
        verifyMethodCalledFromDelegate("getShowsDialog()");
        return ((CallFun0<Boolean>) mSuperListeners.pop()).call();
    }

    public int getTheme() {
        verifyMethodCalledFromDelegate("getTheme()");
        return ((CallFun0<Integer>) mSuperListeners.pop()).call();
    }

    /**
     * Return the current value of {@link #setCancelable(boolean)}.
     */
    public boolean isCancelable() {
        verifyMethodCalledFromDelegate("isCancelable()");
        return ((CallFun0<Boolean>) mSuperListeners.pop()).call();
    }

    public void onActivityCreated(final Bundle savedInstanceState) {
        verifyMethodCalledFromDelegate("onActivityCreated(Bundle)");
        ((CallVoid1<Bundle>) mSuperListeners.pop()).call(savedInstanceState);
    }

    public void onAttach(final Context context) {
        verifyMethodCalledFromDelegate("onAttach(Context)");
        ((CallVoid1<Context>) mSuperListeners.pop()).call(context);
    }

    public void onCancel(final DialogInterface dialog) {
        verifyMethodCalledFromDelegate("onCancel(DialogInterface)");
        ((CallVoid1<DialogInterface>) mSuperListeners.pop()).call(dialog);
    }

    public void onCreate(@Nullable final Bundle savedInstanceState) {
        verifyMethodCalledFromDelegate("onCreate(Bundle)");
        ((CallVoid1<Bundle>) mSuperListeners.pop()).call(savedInstanceState);
    }

    /**
     * Override to build your own custom Dialog container.  This is typically
     * used to show an AlertDialog instead of a generic Dialog; when doing so,
     * {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)} does not need
     * to be implemented since the AlertDialog takes care of its own content.
     *
     * <p>This method will be called after {@link #onCreate(Bundle)} and
     * before {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.  The
     * default implementation simply instantiates and returns a {@link Dialog}
     * class.
     *
     * <p><em>Note: DialogFragment own the {@link Dialog#setOnCancelListener
     * Dialog.setOnCancelListener} and {@link Dialog#setOnDismissListener
     * Dialog.setOnDismissListener} callbacks.  You must not set them yourself.</em>
     * To find out about these events, override {@link #onCancel(DialogInterface)}
     * and {@link #onDismiss(DialogInterface)}.</p>
     *
     * @param savedInstanceState The last saved instance state of the Fragment,
     *                           or null if this is a freshly created Fragment.
     * @return Return a new Dialog instance to be displayed by the Fragment.
     */
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        verifyMethodCalledFromDelegate("onCreateDialog(Bundle)");
        return ((CallFun1<Dialog, Bundle>) mSuperListeners.pop()).call(savedInstanceState);
    }

    /**
     * Remove dialog.
     */
    public void onDestroyView() {
        verifyMethodCalledFromDelegate("onDestroyView()");
        ((CallVoid0) mSuperListeners.pop()).call();
    }

    public void onDetach() {
        verifyMethodCalledFromDelegate("onDetach()");
        ((CallVoid0) mSuperListeners.pop()).call();
    }

    public void onDismiss(final DialogInterface dialog) {
        verifyMethodCalledFromDelegate("onDismiss(DialogInterface)");
        ((CallVoid1<DialogInterface>) mSuperListeners.pop()).call(dialog);
    }

    public void onSaveInstanceState(final Bundle outState) {
        verifyMethodCalledFromDelegate("onSaveInstanceState(Bundle)");
        ((CallVoid1<Bundle>) mSuperListeners.pop()).call(outState);
    }

    public void onStart() {
        verifyMethodCalledFromDelegate("onStart()");
        ((CallVoid0) mSuperListeners.pop()).call();
    }

    public void onStop() {
        verifyMethodCalledFromDelegate("onStop()");
        ((CallVoid0) mSuperListeners.pop()).call();
    }

    /**
     * Control whether the shown Dialog is cancelable.  Use this instead of
     * directly calling {@link Dialog#setCancelable(boolean)
     * Dialog.setCancelable(boolean)}, because DialogFragment needs to change
     * its behavior based on this.
     *
     * @param cancelable If true, the dialog is cancelable.  The default
     *                   is true.
     */
    public void setCancelable(final boolean cancelable) {
        verifyMethodCalledFromDelegate("setCancelable(Boolean)");
        ((CallVoid1<Boolean>) mSuperListeners.pop()).call(cancelable);
    }

    /**
     * Controls whether this fragment should be shown in a dialog.  If not
     * set, no Dialog will be created in {@link #onActivityCreated(Bundle)},
     * and the fragment's view hierarchy will thus not be added to it.  This
     * allows you to instead use it as a normal fragment (embedded inside of
     * its activity).
     *
     * <p>This is normally set for you based on whether the fragment is
     * associated with a container view ID passed to
     * {@link FragmentTransaction#add(int, Fragment) FragmentTransaction.add(int, Fragment)}.
     * If the fragment was added with a container, setShowsDialog will be
     * initialized to false; otherwise, it will be true.
     *
     * @param showsDialog If true, the fragment will be displayed in a Dialog.
     *                    If false, no Dialog will be created and the fragment's view hierarchy
     *                    left undisturbed.
     */
    public void setShowsDialog(final boolean showsDialog) {
        verifyMethodCalledFromDelegate("setShowsDialog(Boolean)");
        ((CallVoid1<Boolean>) mSuperListeners.pop()).call(showsDialog);
    }

    /**
     * Call to customize the basic appearance and behavior of the
     * fragment's dialog.  This can be used for some common dialog behaviors,
     * taking care of selecting flags, theme, and other options for you.  The
     * same effect can be achieve by manually setting Dialog and Window
     * attributes yourself.  Calling this after the fragment's Dialog is
     * created will have no effect.
     *
     * @param style Selects a standard style: may be {@link #STYLE_NORMAL},
     *              {@link #STYLE_NO_TITLE}, {@link #STYLE_NO_FRAME}, or
     *              {@link #STYLE_NO_INPUT}.
     * @param theme Optional custom theme.  If 0, an appropriate theme (based
     */
    public void setStyle(final int style, @StyleRes final int theme) {
        verifyMethodCalledFromDelegate("setStyle(Integer, Integer)");
        ((CallVoid2<Integer, Integer>) mSuperListeners.pop()).call(style, theme);
    }

    /**
     * @hide
     */
    public void setupDialog(final Dialog dialog, final int style) {
        verifyMethodCalledFromDelegate("setupDialog(Dialog, Integer)");
        ((CallVoid2<Dialog, Integer>) mSuperListeners.pop()).call(dialog, style);
    }

    /**
     * Display the dialog, adding the fragment to the given FragmentManager.  This
     * is a convenience for explicitly creating a transaction, adding the
     * fragment to it with the given tag, and committing it.  This does
     * <em>not</em> add the transaction to the back stack.  When the fragment
     * is dismissed, a new transaction will be executed to remove it from
     * the activity.
     *
     * @param manager The FragmentManager this fragment will be added to.
     * @param tag     The tag for this fragment, as per
     *                {@link FragmentTransaction#add(Fragment, String) FragmentTransaction.add}.
     */
    public void show(final FragmentManager manager, final String tag) {
        verifyMethodCalledFromDelegate("show(FragmentManager, String)");
        ((CallVoid2<FragmentManager, String>) mSuperListeners.pop()).call(manager, tag);
    }

    /**
     * Display the dialog, adding the fragment using an existing transaction
     * and then committing the transaction.
     *
     * @param transaction An existing transaction in which to add the fragment.
     * @param tag         The tag for this fragment, as per
     *                    {@link FragmentTransaction#add(Fragment, String) FragmentTransaction.add}.
     * @return Returns the identifier of the committed transaction, as per
     * {@link FragmentTransaction#commit() FragmentTransaction.commit()}.
     */
    public int show(final FragmentTransaction transaction, final String tag) {
        verifyMethodCalledFromDelegate("show(FragmentTransaction, String)");
        return ((CallFun2<Integer, FragmentTransaction, String>) mSuperListeners.pop())
                .call(transaction, tag);
    }

    void dismiss(final CallVoid0 superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            dismiss();
        }
    }

    void dismissAllowingStateLoss(final CallVoid0 superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            dismissAllowingStateLoss();
        }
    }

    Dialog getDialog(final CallFun0<Dialog> superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return getDialog();
        }
    }

    LayoutInflater getLayoutInflater(final CallFun1<LayoutInflater, Bundle> superCall,
            final Bundle savedInstanceState) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return getLayoutInflater(savedInstanceState);
        }
    }

    boolean getShowsDialog(final CallFun0<Boolean> superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return getShowsDialog();
        }
    }

    int getTheme(final CallFun0<Integer> superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return getTheme();
        }
    }

    boolean isCancelable(final CallFun0<Boolean> superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return isCancelable();
        }
    }

    void onActivityCreated(final CallVoid1<Bundle> superCall, final Bundle savedInstanceState) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onActivityCreated(savedInstanceState);
        }
    }

    void onAttach(final CallVoid1<Context> superCall, final Context context) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onAttach(context);
        }
    }

    void onCancel(final CallVoid1<DialogInterface> superCall, final DialogInterface dialog) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onCancel(dialog);
        }
    }

    void onCreate(final CallVoid1<Bundle> superCall, @Nullable final Bundle savedInstanceState) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onCreate(savedInstanceState);
        }
    }

    Dialog onCreateDialog(final CallFun1<Dialog, Bundle> superCall,
            final Bundle savedInstanceState) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return onCreateDialog(savedInstanceState);
        }
    }

    void onDestroyView(final CallVoid0 superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onDestroyView();
        }
    }

    void onDetach(final CallVoid0 superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onDetach();
        }
    }

    void onDismiss(final CallVoid1<DialogInterface> superCall, final DialogInterface dialog) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onDismiss(dialog);
        }
    }

    void onSaveInstanceState(final CallVoid1<Bundle> superCall, final Bundle outState) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onSaveInstanceState(outState);
        }
    }

    void onStart(final CallVoid0 superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onStart();
        }
    }

    void onStop(final CallVoid0 superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onStop();
        }
    }

    void setCancelable(final CallVoid1<Boolean> superCall, final boolean cancelable) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setCancelable(cancelable);
        }
    }

    void setShowsDialog(final CallVoid1<Boolean> superCall, final boolean showsDialog) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setShowsDialog(showsDialog);
        }
    }

    void setStyle(final CallVoid2<Integer, Integer> superCall, final int style,
            @StyleRes final int theme) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setStyle(style, theme);
        }
    }

    void setupDialog(final CallVoid2<Dialog, Integer> superCall, final Dialog dialog,
            final int style) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setupDialog(dialog, style);
        }
    }

    void show(final CallVoid2<FragmentManager, String> superCall, final FragmentManager manager,
            final String tag) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            show(manager, tag);
        }
    }

    int show(final CallFun2<Integer, FragmentTransaction, String> superCall,
            final FragmentTransaction transaction, final String tag) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return show(transaction, tag);
        }
    }


}