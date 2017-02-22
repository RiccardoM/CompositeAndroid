package com.pascalwelsch.compositeandroid.fragment;

import com.pascalwelsch.compositeandroid.core.AbstractPlugin;
import com.pascalwelsch.compositeandroid.core.CallFun0;
import com.pascalwelsch.compositeandroid.core.CallFun1;
import com.pascalwelsch.compositeandroid.core.CallFun3;
import com.pascalwelsch.compositeandroid.core.CallVoid0;
import com.pascalwelsch.compositeandroid.core.CallVoid1;
import com.pascalwelsch.compositeandroid.core.CallVoid2;
import com.pascalwelsch.compositeandroid.core.CallVoid3;
import com.pascalwelsch.compositeandroid.core.CallVoid4;
import com.pascalwelsch.compositeandroid.core.CallVoid7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.SharedElementCallback;
import android.transition.ChangeBounds;
import android.transition.Visibility;
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

@SuppressWarnings("unused")
public class FragmentPlugin extends AbstractPlugin<Fragment, FragmentDelegate> {

    /**
     * Print the Fragments's state into the given stream.
     *
     * @param prefix Text to print at the front of each line.
     * @param fd     The raw file descriptor that the dump is being sent to.
     * @param writer The PrintWriter to which you should dump your state.  This will be
     *               closed for you after you return.
     * @param args   additional arguments to the dump request.
     */
    public void dump(final String prefix, final FileDescriptor fd, final PrintWriter writer,
            final String[] args) {
        verifyMethodCalledFromDelegate("dump(String, FileDescriptor, PrintWriter, String[])");
        ((CallVoid4<String, FileDescriptor, PrintWriter, String[]>) mSuperListeners.pop())
                .call(prefix, fd, writer, args);
    }

    /**
     * Returns whether the the exit transition and enter transition overlap or not.
     * When true, the enter transition will start as soon as possible. When false, the
     * enter transition will wait until the exit transition completes before starting.
     *
     * @return true when the enter transition should start as soon as possible or false to
     * when it should wait until the exiting transition completes.
     */
    public boolean getAllowEnterTransitionOverlap() {
        verifyMethodCalledFromDelegate("getAllowEnterTransitionOverlap()");
        return ((CallFun0<Boolean>) mSuperListeners.pop()).call();
    }

    /**
     * Returns whether the the return transition and reenter transition overlap or not.
     * When true, the reenter transition will start as soon as possible. When false, the
     * reenter transition will wait until the return transition completes before starting.
     *
     * @return true to start the reenter transition when possible or false to wait until the
     * return transition completes.
     */
    public boolean getAllowReturnTransitionOverlap() {
        verifyMethodCalledFromDelegate("getAllowReturnTransitionOverlap()");
        return ((CallFun0<Boolean>) mSuperListeners.pop()).call();
    }

    /**
     * Return the {@link Context} this fragment is currently associated with.
     */
    public Context getContext() {
        verifyMethodCalledFromDelegate("getContext()");
        return ((CallFun0<Context>) mSuperListeners.pop()).call();
    }

    /**
     * Returns the Transition that will be used to move Views into the initial scene. The entering
     * Views will be those that are regular Views or ViewGroups that have
     * {@link ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
     * {@link Visibility} as entering is governed by changing visibility from
     * {@link View#INVISIBLE} to {@link View#VISIBLE}.
     *
     * @return the Transition to use to move Views into the initial Scene.
     */
    public Object getEnterTransition() {
        verifyMethodCalledFromDelegate("getEnterTransition()");
        return ((CallFun0<Object>) mSuperListeners.pop()).call();
    }

    /**
     * Returns the Transition that will be used to move Views out of the scene when the
     * fragment is removed, hidden, or detached when not popping the back stack.
     * The exiting Views will be those that are regular Views or ViewGroups that
     * have {@link ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
     * {@link Visibility} as exiting is governed by changing visibility
     * from {@link View#VISIBLE} to {@link View#INVISIBLE}. If transition is null, the views will
     * remain unaffected.
     *
     * @return the Transition to use to move Views out of the Scene when the Fragment
     * is being closed not due to popping the back stack.
     */
    public Object getExitTransition() {
        verifyMethodCalledFromDelegate("getExitTransition()");
        return ((CallFun0<Object>) mSuperListeners.pop()).call();
    }

    public Fragment getFragment() {
        return (Fragment) getOriginal();
    }

    /**
     * Hack so that DialogFragment can make its Dialog before creating
     * its views, and the view construction can use the dialog's context for
     * inflation.  Maybe this should become a public API. Note sure.
     *
     * @hide
     */
    public LayoutInflater getLayoutInflater(final Bundle savedInstanceState) {
        verifyMethodCalledFromDelegate("getLayoutInflater(Bundle)");
        return ((CallFun1<LayoutInflater, Bundle>) mSuperListeners.pop()).call(savedInstanceState);
    }

    /**
     * Return the LoaderManager for this fragment, creating it if needed.
     */
    public LoaderManager getLoaderManager() {
        verifyMethodCalledFromDelegate("getLoaderManager()");
        return ((CallFun0<LoaderManager>) mSuperListeners.pop()).call();
    }

    /**
     * Returns the Transition that will be used to move Views in to the scene when returning due
     * to popping a back stack. The entering Views will be those that are regular Views
     * or ViewGroups that have {@link ViewGroup#isTransitionGroup} return true. Typical Transitions
     * will extend {@link Visibility} as exiting is governed by changing
     * visibility from {@link View#VISIBLE} to {@link View#INVISIBLE}. If transition is null,
     * the views will remain unaffected. If nothing is set, the default will be to use the same
     * transition as {@link #setExitTransition(Object)}.
     *
     * @return the Transition to use to move Views into the scene when reentering from a
     * previously-started Activity.
     */
    public Object getReenterTransition() {
        verifyMethodCalledFromDelegate("getReenterTransition()");
        return ((CallFun0<Object>) mSuperListeners.pop()).call();
    }

    /**
     * Returns the Transition that will be used to move Views out of the scene when the Fragment is
     * preparing to be removed, hidden, or detached because of popping the back stack. The exiting
     * Views will be those that are regular Views or ViewGroups that have
     * {@link ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
     * {@link Visibility} as entering is governed by changing visibility from
     * {@link View#VISIBLE} to {@link View#INVISIBLE}. If <code>transition</code> is null,
     * entering Views will remain unaffected.
     *
     * @return the Transition to use to move Views out of the Scene when the Fragment
     * is preparing to close.
     */
    public Object getReturnTransition() {
        verifyMethodCalledFromDelegate("getReturnTransition()");
        return ((CallFun0<Object>) mSuperListeners.pop()).call();
    }

    /**
     * Returns the Transition that will be used for shared elements transferred into the content
     * Scene. Typical Transitions will affect size and location, such as
     * {@link ChangeBounds}. A null
     * value will cause transferred shared elements to blink to the final position.
     *
     * @return The Transition to use for shared elements transferred into the content
     * Scene.
     */
    public Object getSharedElementEnterTransition() {
        verifyMethodCalledFromDelegate("getSharedElementEnterTransition()");
        return ((CallFun0<Object>) mSuperListeners.pop()).call();
    }

    /**
     * Return the Transition that will be used for shared elements transferred back during a
     * pop of the back stack. This Transition acts in the leaving Fragment.
     * Typical Transitions will affect size and location, such as
     * {@link ChangeBounds}. A null
     * value will cause transferred shared elements to blink to the final position.
     * If no value is set, the default will be to use the same value as
     * {@link #setSharedElementEnterTransition(Object)}.
     *
     * @return The Transition to use for shared elements transferred out of the content
     * Scene.
     */
    public Object getSharedElementReturnTransition() {
        verifyMethodCalledFromDelegate("getSharedElementReturnTransition()");
        return ((CallFun0<Object>) mSuperListeners.pop()).call();
    }

    /**
     * @return The current value of the user-visible hint on this fragment.
     * @see #setUserVisibleHint(boolean)
     */
    public boolean getUserVisibleHint() {
        verifyMethodCalledFromDelegate("getUserVisibleHint()");
        return ((CallFun0<Boolean>) mSuperListeners.pop()).call();
    }

    /**
     * Get the root view for the fragment's layout (the one returned by {@link #onCreateView}),
     * if provided.
     *
     * @return The fragment's root view, or null if it has no layout.
     */
    public View getView() {
        verifyMethodCalledFromDelegate("getView()");
        return ((CallFun0<View>) mSuperListeners.pop()).call();
    }

    /**
     * Called when the fragment's activity has been created and this
     * fragment's view hierarchy instantiated.  It can be used to do final
     * initialization once these pieces are in place, such as retrieving
     * views or restoring state.  It is also useful for fragments that use
     * {@link #setRetainInstance(boolean)} to retain their instance,
     * as this callback tells the fragment when it is fully associated with
     * the new activity instance.  This is called after {@link #onCreateView}
     * and before {@link #onViewStateRestored(Bundle)}.
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
     */
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        verifyMethodCalledFromDelegate("onActivityCreated(Bundle)");
        ((CallVoid1<Bundle>) mSuperListeners.pop()).call(savedInstanceState);
    }

    /**
     * Receive the result from a previous call to
     * {@link #startActivityForResult(Intent, int)}.  This follows the
     * related Activity API as described there in
     * {@link Activity#onActivityResult(int, int, Intent)}.
     *
     * @param requestCode The integer request code originally supplied to
     *                    startActivityForResult(), allowing you to identify who this
     *                    result came from.
     * @param resultCode  The integer result code returned by the child activity
     *                    through its setResult().
     * @param data        An Intent, which can return result data to the caller
     */
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        verifyMethodCalledFromDelegate("onActivityResult(Integer, Integer, Intent)");
        ((CallVoid3<Integer, Integer, Intent>) mSuperListeners.pop())
                .call(requestCode, resultCode, data);
    }

    /**
     * Called when a fragment is first attached to its context.
     * {@link #onCreate(Bundle)} will be called after this.
     */
    public void onAttach(final Context context) {
        verifyMethodCalledFromDelegate("onAttach(Context)");
        ((CallVoid1<Context>) mSuperListeners.pop()).call(context);
    }

    /**
     * Called when a fragment is first attached to its activity.
     * {@link #onCreate(Bundle)} will be called after this.
     *
     * @deprecated See {@link #onAttach(Context)}.
     */
    public void onAttach(final Activity activity) {
        verifyMethodCalledFromDelegate("onAttach(Activity)");
        ((CallVoid1<Activity>) mSuperListeners.pop()).call(activity);
    }

    /**
     * Called when a fragment is attached as a child of this fragment.
     *
     * <p>This is called after the attached fragment's <code>onAttach</code> and before
     * the attached fragment's <code>onCreate</code> if the fragment has not yet had a previous
     * call to <code>onCreate</code>.</p>
     *
     * @param childFragment child fragment being attached
     */
    public void onAttachFragment(final Fragment childFragment) {
        verifyMethodCalledFromDelegate("onAttachFragment(Fragment)");
        ((CallVoid1<Fragment>) mSuperListeners.pop()).call(childFragment);
    }

    public void onConfigurationChanged(final Configuration newConfig) {
        verifyMethodCalledFromDelegate("onConfigurationChanged(Configuration)");
        ((CallVoid1<Configuration>) mSuperListeners.pop()).call(newConfig);
    }

    /**
     * This hook is called whenever an item in a context menu is selected. The
     * default implementation simply returns false to have the normal processing
     * happen (calling the item's Runnable or sending a message to its Handler
     * as appropriate). You can use this method for any items for which you
     * would like to do processing without those other facilities.
     * <p>
     * Use {@link MenuItem#getMenuInfo()} to get extra information set by the
     * View that added this menu item.
     * <p>
     * Derived classes should call through to the base class for it to perform
     * the default menu handling.
     *
     * @param item The context menu item that was selected.
     * @return boolean Return false to allow normal context menu processing to
     * proceed, true to consume it here.
     */
    public boolean onContextItemSelected(final MenuItem item) {
        verifyMethodCalledFromDelegate("onContextItemSelected(MenuItem)");
        return ((CallFun1<Boolean, MenuItem>) mSuperListeners.pop()).call(item);
    }

    /**
     * Called to do initial creation of a fragment.  This is called after
     * {@link #onAttach(Activity)} and before
     * {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     *
     * <p>Note that this can be called while the fragment's activity is
     * still in the process of being created.  As such, you can not rely
     * on things like the activity's content view hierarchy being initialized
     * at this point.  If you want to do work once the activity itself is
     * created, see {@link #onActivityCreated(Bundle)}.
     *
     * <p>Any restored child fragments will be created before the base
     * <code>Fragment.onCreate</code> method returns.</p>
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
     */
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        verifyMethodCalledFromDelegate("onCreate(Bundle)");
        ((CallVoid1<Bundle>) mSuperListeners.pop()).call(savedInstanceState);
    }

    /**
     * Called when a fragment loads an animation.
     */
    public Animation onCreateAnimation(final int transit, final boolean enter, final int nextAnim) {
        verifyMethodCalledFromDelegate("onCreateAnimation(Integer, Boolean, Integer)");
        return ((CallFun3<Animation, Integer, Boolean, Integer>) mSuperListeners.pop())
                .call(transit, enter, nextAnim);
    }

    /**
     * Called when a context menu for the {@code view} is about to be shown.
     * Unlike {@link #onCreateOptionsMenu}, this will be called every
     * time the context menu is about to be shown and should be populated for
     * the view (or item inside the view for {@link AdapterView} subclasses,
     * this can be found in the {@code menuInfo})).
     * <p>
     * Use {@link #onContextItemSelected(MenuItem)} to know when an
     * item has been selected.
     * <p>
     * The default implementation calls up to
     * {@link Activity#onCreateContextMenu Activity.onCreateContextMenu}, though
     * you can not call this implementation if you don't want that behavior.
     * <p>
     * It is not safe to hold onto the context menu after this method returns.
     * {@inheritDoc}
     */
    public void onCreateContextMenu(final ContextMenu menu, final View v,
            final ContextMenu.ContextMenuInfo menuInfo) {
        verifyMethodCalledFromDelegate(
                "onCreateContextMenu(ContextMenu, View, ContextMenu.ContextMenuInfo)");
        ((CallVoid3<ContextMenu, View, ContextMenu.ContextMenuInfo>) mSuperListeners.pop())
                .call(menu, v, menuInfo);
    }

    /**
     * Initialize the contents of the Fragment host's standard options menu.  You
     * should place your menu items in to <var>menu</var>.  For this method
     * to be called, you must have first called {@link #setHasOptionsMenu}.  See
     * {@link Activity#onCreateOptionsMenu(Menu) Activity.onCreateOptionsMenu}
     * for more information.
     *
     * @param menu The options menu in which you place your items.
     * @see #setHasOptionsMenu
     * @see #onPrepareOptionsMenu
     * @see #onOptionsItemSelected
     */
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater inflater) {
        verifyMethodCalledFromDelegate("onCreateOptionsMenu(Menu, MenuInflater)");
        ((CallVoid2<Menu, MenuInflater>) mSuperListeners.pop()).call(menu, inflater);
    }

    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null (which
     * is the default implementation).  This will be called between
     * {@link #onCreate(Bundle)} and {@link #onActivityCreated(Bundle)}.
     *
     * <p>If you return a View from here, you will later be called in
     * {@link #onDestroyView} when the view is being released.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.  The fragment should not add the view
     *                           itself,
     *                           but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        verifyMethodCalledFromDelegate("onCreateView(LayoutInflater, ViewGroup, Bundle)");
        return ((CallFun3<View, LayoutInflater, ViewGroup, Bundle>) mSuperListeners.pop())
                .call(inflater, container, savedInstanceState);
    }

    /**
     * Called when the fragment is no longer in use.  This is called
     * after {@link #onStop()} and before {@link #onDetach()}.
     */
    public void onDestroy() {
        verifyMethodCalledFromDelegate("onDestroy()");
        ((CallVoid0) mSuperListeners.pop()).call();
    }

    /**
     * Called when this fragment's option menu items are no longer being
     * included in the overall options menu.  Receiving this call means that
     * the menu needed to be rebuilt, but this fragment's items were not
     * included in the newly built menu (its {@link #onCreateOptionsMenu(Menu, MenuInflater)}
     * was not called).
     */
    public void onDestroyOptionsMenu() {
        verifyMethodCalledFromDelegate("onDestroyOptionsMenu()");
        ((CallVoid0) mSuperListeners.pop()).call();
    }

    /**
     * Called when the view previously created by {@link #onCreateView} has
     * been detached from the fragment.  The next time the fragment needs
     * to be displayed, a new view will be created.  This is called
     * after {@link #onStop()} and before {@link #onDestroy()}.  It is called
     * <em>regardless</em> of whether {@link #onCreateView} returned a
     * non-null view.  Internally it is called after the view's state has
     * been saved but before it has been removed from its parent.
     */
    public void onDestroyView() {
        verifyMethodCalledFromDelegate("onDestroyView()");
        ((CallVoid0) mSuperListeners.pop()).call();
    }

    /**
     * Called when the fragment is no longer attached to its activity.  This
     * is called after {@link #onDestroy()}.
     */
    public void onDetach() {
        verifyMethodCalledFromDelegate("onDetach()");
        ((CallVoid0) mSuperListeners.pop()).call();
    }

    /**
     * Called when the hidden state (as returned by {@link #isHidden()} of
     * the fragment has changed.  Fragments start out not hidden; this will
     * be called whenever the fragment changes state from that.
     *
     * @param hidden True if the fragment is now hidden, false otherwise.
     */
    public void onHiddenChanged(final boolean hidden) {
        verifyMethodCalledFromDelegate("onHiddenChanged(Boolean)");
        ((CallVoid1<Boolean>) mSuperListeners.pop()).call(hidden);
    }

    /**
     * Called when a fragment is being created as part of a view layout
     * inflation, typically from setting the content view of an activity.  This
     * may be called immediately after the fragment is created from a <fragment>
     * tag in a layout file.  Note this is <em>before</em> the fragment's
     * {@link #onAttach(Activity)} has been called; all you should do here is
     * parse the attributes and save them away.
     *
     * <p>This is called every time the fragment is inflated, even if it is
     * being inflated into a new instance with saved state.  It typically makes
     * sense to re-parse the parameters each time, to allow them to change with
     * different configurations.</p>
     *
     * <p>Here is a typical implementation of a fragment that can take parameters
     * both through attributes supplied here as well from {@link #getArguments()}:</p>
     *
     * {@sample frameworks/support/samples/Support4Demos/src/com/example/android/supportv4/app/FragmentArgumentsSupport.java
     * fragment}
     *
     * <p>Note that parsing the XML attributes uses a "styleable" resource.  The
     * declaration for the styleable used here is:</p>
     *
     * {@sample frameworks/support/samples/Support4Demos/res/values/attrs.xml fragment_arguments}
     *
     * <p>The fragment can then be declared within its activity's content layout
     * through a tag like this:</p>
     *
     * {@sample frameworks/support/samples/Support4Demos/res/layout/fragment_arguments_support.xml
     * from_attributes}
     *
     * <p>This fragment can also be created dynamically from arguments given
     * at runtime in the arguments Bundle; here is an example of doing so at
     * creation of the containing activity:</p>
     *
     * {@sample frameworks/support/samples/Support4Demos/src/com/example/android/supportv4/app/FragmentArgumentsSupport.java
     * create}
     *
     * @param context            The Activity that is inflating this fragment.
     * @param attrs              The attributes at the tag where the fragment is
     *                           being created.
     * @param savedInstanceState If the fragment is being re-created from
     */
    public void onInflate(final Context context, final AttributeSet attrs,
            final Bundle savedInstanceState) {
        verifyMethodCalledFromDelegate("onInflate(Context, AttributeSet, Bundle)");
        ((CallVoid3<Context, AttributeSet, Bundle>) mSuperListeners.pop())
                .call(context, attrs, savedInstanceState);
    }

    /**
     * Called when a fragment is being created as part of a view layout
     * inflation, typically from setting the content view of an activity.
     *
     * @deprecated See {@link #onInflate(Context, AttributeSet, Bundle)}.
     */
    public void onInflate(final Activity activity, final AttributeSet attrs,
            final Bundle savedInstanceState) {
        verifyMethodCalledFromDelegate("onInflate(Activity, AttributeSet, Bundle)");
        ((CallVoid3<Activity, AttributeSet, Bundle>) mSuperListeners.pop())
                .call(activity, attrs, savedInstanceState);
    }

    public void onLowMemory() {
        verifyMethodCalledFromDelegate("onLowMemory()");
        ((CallVoid0) mSuperListeners.pop()).call();
    }

    /**
     * Called when the Fragment's activity changes from fullscreen mode to multi-window mode and
     * visa-versa. This is generally tied to {@link Activity#onMultiWindowModeChanged} of the
     * containing Activity.
     *
     * @param isInMultiWindowMode True if the activity is in multi-window mode.
     */
    public void onMultiWindowModeChanged(final boolean isInMultiWindowMode) {
        verifyMethodCalledFromDelegate("onMultiWindowModeChanged(Boolean)");
        ((CallVoid1<Boolean>) mSuperListeners.pop()).call(isInMultiWindowMode);
    }

    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     *
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     * @see #onCreateOptionsMenu
     */
    public boolean onOptionsItemSelected(final MenuItem item) {
        verifyMethodCalledFromDelegate("onOptionsItemSelected(MenuItem)");
        return ((CallFun1<Boolean, MenuItem>) mSuperListeners.pop()).call(item);
    }

    /**
     * This hook is called whenever the options menu is being closed (either by the user canceling
     * the menu with the back/menu button, or when an item is selected).
     *
     * @param menu The options menu as last shown or first initialized by
     *             onCreateOptionsMenu().
     */
    public void onOptionsMenuClosed(final Menu menu) {
        verifyMethodCalledFromDelegate("onOptionsMenuClosed(Menu)");
        ((CallVoid1<Menu>) mSuperListeners.pop()).call(menu);
    }

    /**
     * Called when the Fragment is no longer resumed.  This is generally
     * tied to {@link Activity#onPause() Activity.onPause} of the containing
     * Activity's lifecycle.
     */
    public void onPause() {
        verifyMethodCalledFromDelegate("onPause()");
        ((CallVoid0) mSuperListeners.pop()).call();
    }

    /**
     * Called by the system when the activity changes to and from picture-in-picture mode. This is
     * generally tied to {@link Activity#onPictureInPictureModeChanged} of the containing Activity.
     *
     * @param isInPictureInPictureMode True if the activity is in picture-in-picture mode.
     */
    public void onPictureInPictureModeChanged(final boolean isInPictureInPictureMode) {
        verifyMethodCalledFromDelegate("onPictureInPictureModeChanged(Boolean)");
        ((CallVoid1<Boolean>) mSuperListeners.pop()).call(isInPictureInPictureMode);
    }

    /**
     * Prepare the Fragment host's standard options menu to be displayed.  This is
     * called right before the menu is shown, every time it is shown.  You can
     * use this method to efficiently enable/disable items or otherwise
     * dynamically modify the contents.  See
     * {@link Activity#onPrepareOptionsMenu(Menu) Activity.onPrepareOptionsMenu}
     * for more information.
     *
     * @param menu The options menu as last shown or first initialized by
     *             onCreateOptionsMenu().
     * @see #setHasOptionsMenu
     * @see #onCreateOptionsMenu
     */
    public void onPrepareOptionsMenu(final Menu menu) {
        verifyMethodCalledFromDelegate("onPrepareOptionsMenu(Menu)");
        ((CallVoid1<Menu>) mSuperListeners.pop()).call(menu);
    }

    /**
     * Callback for the result from requesting permissions. This method
     * is invoked for every call on {@link #requestPermissions(String[], int)}.
     * <p>
     * <strong>Note:</strong> It is possible that the permissions request interaction
     * with the user is interrupted. In this case you will receive empty permissions
     * and results arrays which should be treated as a cancellation.
     * </p>
     *
     * @param requestCode  The request code passed in {@link #requestPermissions(String[], int)}.
     * @param permissions  The requested permissions. Never null.
     * @param grantResults The grant results for the corresponding permissions
     *                     which is either {@link PackageManager#PERMISSION_GRANTED}
     *                     or {@link PackageManager#PERMISSION_DENIED}. Never null.
     * @see #requestPermissions(String[], int)
     */
    public void onRequestPermissionsResult(final int requestCode,
            @NonNull final String[] permissions, @NonNull final int[] grantResults) {
        verifyMethodCalledFromDelegate("onRequestPermissionsResult(Integer, String[], int[])");
        ((CallVoid3<Integer, String[], int[]>) mSuperListeners.pop())
                .call(requestCode, permissions, grantResults);
    }

    /**
     * Called when the fragment is visible to the user and actively running.
     * This is generally
     * tied to {@link Activity#onResume() Activity.onResume} of the containing
     * Activity's lifecycle.
     */
    public void onResume() {
        verifyMethodCalledFromDelegate("onResume()");
        ((CallVoid0) mSuperListeners.pop()).call();
    }

    /**
     * Called to ask the fragment to save its current dynamic state, so it
     * can later be reconstructed in a new instance of its process is
     * restarted.  If a new instance of the fragment later needs to be
     * created, the data you place in the Bundle here will be available
     * in the Bundle given to {@link #onCreate(Bundle)},
     * {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}, and
     * {@link #onActivityCreated(Bundle)}.
     *
     * <p>This corresponds to {@link Activity#onSaveInstanceState(Bundle)
     * Activity.onSaveInstanceState(Bundle)} and most of the discussion there
     * applies here as well.  Note however: <em>this method may be called
     * at any time before {@link #onDestroy()}</em>.  There are many situations
     * where a fragment may be mostly torn down (such as when placed on the
     * back stack with no UI showing), but its state will not be saved until
     * its owning activity actually needs to save its state.
     *
     * @param outState Bundle in which to place your saved state.
     */
    public void onSaveInstanceState(final Bundle outState) {
        verifyMethodCalledFromDelegate("onSaveInstanceState(Bundle)");
        ((CallVoid1<Bundle>) mSuperListeners.pop()).call(outState);
    }

    /**
     * Called when the Fragment is visible to the user.  This is generally
     * tied to {@link Activity#onStart() Activity.onStart} of the containing
     * Activity's lifecycle.
     */
    public void onStart() {
        verifyMethodCalledFromDelegate("onStart()");
        ((CallVoid0) mSuperListeners.pop()).call();
    }

    /**
     * Called when the Fragment is no longer started.  This is generally
     * tied to {@link Activity#onStop() Activity.onStop} of the containing
     * Activity's lifecycle.
     */
    public void onStop() {
        verifyMethodCalledFromDelegate("onStop()");
        ((CallVoid0) mSuperListeners.pop()).call();
    }

    /**
     * Called immediately after {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     * has returned, but before any saved state has been restored in to the view.
     * This gives subclasses a chance to initialize themselves once
     * they know their view hierarchy has been completely created.  The fragment's
     * view hierarchy is not however attached to its parent at this point.
     *
     * @param view               The View returned by {@link #onCreateView(LayoutInflater,
     *                           ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     */
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        verifyMethodCalledFromDelegate("onViewCreated(View, Bundle)");
        ((CallVoid2<View, Bundle>) mSuperListeners.pop()).call(view, savedInstanceState);
    }

    /**
     * Called when all saved state has been restored into the view hierarchy
     * of the fragment.  This can be used to do initialization based on saved
     * state that you are letting the view hierarchy track itself, such as
     * whether check box widgets are currently checked.  This is called
     * after {@link #onActivityCreated(Bundle)} and before
     * {@link #onStart()}.
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
     */
    public void onViewStateRestored(@Nullable final Bundle savedInstanceState) {
        verifyMethodCalledFromDelegate("onViewStateRestored(Bundle)");
        ((CallVoid1<Bundle>) mSuperListeners.pop()).call(savedInstanceState);
    }

    /**
     * Postpone the entering Fragment transition until {@link #startPostponedEnterTransition()}
     * or {@link FragmentManager#executePendingTransactions()} has been called.
     * <p>
     * This method gives the Fragment the ability to delay Fragment animations
     * until all data is loaded. Until then, the added, shown, and
     * attached Fragments will be INVISIBLE and removed, hidden, and detached Fragments won't
     * be have their Views removed. The transaction runs when all postponed added Fragments in the
     * transaction have called {@link #startPostponedEnterTransition()}.
     * <p>
     * This method should be called before being added to the FragmentTransaction or
     * in {@link #onCreate(Bundle), {@link #onAttach(Context)}, or
     * {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}}.
     * {@link #startPostponedEnterTransition()} must be called to allow the Fragment to
     * start the transitions.
     * <p>
     * When a FragmentTransaction is started that may affect a postponed FragmentTransaction,
     * based on which containers are in their operations, the postponed FragmentTransaction
     * will have its start triggered. The early triggering may result in faulty or nonexistent
     * animations in the postponed transaction. FragmentTransactions that operate only on
     * independent containers will not interfere with each other's postponement.
     * <p>
     * Calling postponeEnterTransition on Fragments with a null View will not postpone the
     * transition. Likewise, postponement only works if FragmentTransaction optimizations are
     * enabled.
     *
     * @see Activity#postponeEnterTransition()
     * @see FragmentTransaction#setAllowOptimization(boolean)
     */
    public void postponeEnterTransition() {
        verifyMethodCalledFromDelegate("postponeEnterTransition()");
        ((CallVoid0) mSuperListeners.pop()).call();
    }

    /**
     * Registers a context menu to be shown for the given view (multiple views
     * can show the context menu). This method will set the
     * {@link OnCreateContextMenuListener} on the view to this fragment, so
     * {@link #onCreateContextMenu(ContextMenu, View, ContextMenuInfo)} will be
     * called when it is time to show the context menu.
     *
     * @param view The view that should show a context menu.
     * @see #unregisterForContextMenu(View)
     */
    public void registerForContextMenu(final View view) {
        verifyMethodCalledFromDelegate("registerForContextMenu(View)");
        ((CallVoid1<View>) mSuperListeners.pop()).call(view);
    }

    /**
     * Sets whether the the exit transition and enter transition overlap or not.
     * When true, the enter transition will start as soon as possible. When false, the
     * enter transition will wait until the exit transition completes before starting.
     *
     * @param allow true to start the enter transition when possible or false to
     *              wait until the exiting transition completes.
     */
    public void setAllowEnterTransitionOverlap(final boolean allow) {
        verifyMethodCalledFromDelegate("setAllowEnterTransitionOverlap(Boolean)");
        ((CallVoid1<Boolean>) mSuperListeners.pop()).call(allow);
    }

    /**
     * Sets whether the the return transition and reenter transition overlap or not.
     * When true, the reenter transition will start as soon as possible. When false, the
     * reenter transition will wait until the return transition completes before starting.
     *
     * @param allow true to start the reenter transition when possible or false to wait until the
     *              return transition completes.
     */
    public void setAllowReturnTransitionOverlap(final boolean allow) {
        verifyMethodCalledFromDelegate("setAllowReturnTransitionOverlap(Boolean)");
        ((CallVoid1<Boolean>) mSuperListeners.pop()).call(allow);
    }

    /**
     * Supply the construction arguments for this fragment.  This can only
     * be called before the fragment has been attached to its activity; that
     * is, you should call it immediately after constructing the fragment.  The
     * arguments supplied here will be retained across fragment destroy and
     * creation.
     */
    public void setArguments(final Bundle args) {
        verifyMethodCalledFromDelegate("setArguments(Bundle)");
        ((CallVoid1<Bundle>) mSuperListeners.pop()).call(args);
    }

    /**
     * When custom transitions are used with Fragments, the enter transition callback
     * is called when this Fragment is attached or detached when not popping the back stack.
     *
     * @param callback Used to manipulate the shared element transitions on this Fragment
     *                 when added not as a pop from the back stack.
     */
    public void setEnterSharedElementCallback(final SharedElementCallback callback) {
        verifyMethodCalledFromDelegate("setEnterSharedElementCallback(SharedElementCallback)");
        ((CallVoid1<SharedElementCallback>) mSuperListeners.pop()).call(callback);
    }

    /**
     * Sets the Transition that will be used to move Views into the initial scene. The entering
     * Views will be those that are regular Views or ViewGroups that have
     * {@link ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
     * {@link Visibility} as entering is governed by changing visibility from
     * {@link View#INVISIBLE} to {@link View#VISIBLE}. If <code>transition</code> is null,
     * entering Views will remain unaffected.
     *
     * @param transition The Transition to use to move Views into the initial Scene.
     */
    public void setEnterTransition(final Object transition) {
        verifyMethodCalledFromDelegate("setEnterTransition(Object)");
        ((CallVoid1<Object>) mSuperListeners.pop()).call(transition);
    }

    /**
     * When custom transitions are used with Fragments, the exit transition callback
     * is called when this Fragment is attached or detached when popping the back stack.
     *
     * @param callback Used to manipulate the shared element transitions on this Fragment
     *                 when added as a pop from the back stack.
     */
    public void setExitSharedElementCallback(final SharedElementCallback callback) {
        verifyMethodCalledFromDelegate("setExitSharedElementCallback(SharedElementCallback)");
        ((CallVoid1<SharedElementCallback>) mSuperListeners.pop()).call(callback);
    }

    /**
     * Sets the Transition that will be used to move Views out of the scene when the
     * fragment is removed, hidden, or detached when not popping the back stack.
     * The exiting Views will be those that are regular Views or ViewGroups that
     * have {@link ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
     * {@link Visibility} as exiting is governed by changing visibility
     * from {@link View#VISIBLE} to {@link View#INVISIBLE}. If transition is null, the views will
     * remain unaffected.
     *
     * @param transition The Transition to use to move Views out of the Scene when the Fragment
     *                   is being closed not due to popping the back stack. <code>transition</code>
     *                   must be an android.transition.Transition.
     */
    public void setExitTransition(final Object transition) {
        verifyMethodCalledFromDelegate("setExitTransition(Object)");
        ((CallVoid1<Object>) mSuperListeners.pop()).call(transition);
    }

    /**
     * Report that this fragment would like to participate in populating
     * the options menu by receiving a call to {@link #onCreateOptionsMenu}
     * and related methods.
     *
     * @param hasMenu If true, the fragment has menu items to contribute.
     */
    public void setHasOptionsMenu(final boolean hasMenu) {
        verifyMethodCalledFromDelegate("setHasOptionsMenu(Boolean)");
        ((CallVoid1<Boolean>) mSuperListeners.pop()).call(hasMenu);
    }

    /**
     * Set the initial saved state that this Fragment should restore itself
     * from when first being constructed, as returned by
     * {@link FragmentManager#saveFragmentInstanceState(Fragment)
     * FragmentManager.saveFragmentInstanceState}.
     *
     * @param state The state the fragment should be restored from.
     */
    public void setInitialSavedState(final Fragment.SavedState state) {
        verifyMethodCalledFromDelegate("setInitialSavedState(Fragment.SavedState)");
        ((CallVoid1<Fragment.SavedState>) mSuperListeners.pop()).call(state);
    }

    /**
     * Set a hint for whether this fragment's menu should be visible.  This
     * is useful if you know that a fragment has been placed in your view
     * hierarchy so that the user can not currently seen it, so any menu items
     * it has should also not be shown.
     *
     * @param menuVisible The default is true, meaning the fragment's menu will
     *                    be shown as usual.  If false, the user will not see the menu.
     */
    public void setMenuVisibility(final boolean menuVisible) {
        verifyMethodCalledFromDelegate("setMenuVisibility(Boolean)");
        ((CallVoid1<Boolean>) mSuperListeners.pop()).call(menuVisible);
    }

    /**
     * Sets the Transition that will be used to move Views in to the scene when returning due
     * to popping a back stack. The entering Views will be those that are regular Views
     * or ViewGroups that have {@link ViewGroup#isTransitionGroup} return true. Typical Transitions
     * will extend {@link Visibility} as exiting is governed by changing
     * visibility from {@link View#VISIBLE} to {@link View#INVISIBLE}. If transition is null,
     * the views will remain unaffected. If nothing is set, the default will be to use the same
     * transition as {@link #setExitTransition(Object)}.
     *
     * @param transition The Transition to use to move Views into the scene when reentering from a
     *                   previously-started Activity. <code>transition</code>
     *                   must be an android.transition.Transition.
     */
    public void setReenterTransition(final Object transition) {
        verifyMethodCalledFromDelegate("setReenterTransition(Object)");
        ((CallVoid1<Object>) mSuperListeners.pop()).call(transition);
    }

    /**
     * Control whether a fragment instance is retained across Activity
     * re-creation (such as from a configuration change).  This can only
     * be used with fragments not in the back stack.  If set, the fragment
     * lifecycle will be slightly different when an activity is recreated:
     * <ul>
     * <li> {@link #onDestroy()} will not be called (but {@link #onDetach()} still
     * will be, because the fragment is being detached from its current activity).
     * <li> {@link #onCreate(Bundle)} will not be called since the fragment
     * is not being re-created.
     * <li> {@link #onAttach(Activity)} and {@link #onActivityCreated(Bundle)} <b>will</b>
     * still be called.
     * </ul>
     */
    public void setRetainInstance(final boolean retain) {
        verifyMethodCalledFromDelegate("setRetainInstance(Boolean)");
        ((CallVoid1<Boolean>) mSuperListeners.pop()).call(retain);
    }

    /**
     * Sets the Transition that will be used to move Views out of the scene when the Fragment is
     * preparing to be removed, hidden, or detached because of popping the back stack. The exiting
     * Views will be those that are regular Views or ViewGroups that have
     * {@link ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
     * {@link Visibility} as entering is governed by changing visibility from
     * {@link View#VISIBLE} to {@link View#INVISIBLE}. If <code>transition</code> is null,
     * entering Views will remain unaffected. If nothing is set, the default will be to
     * use the same value as set in {@link #setEnterTransition(Object)}.
     *
     * @param transition The Transition to use to move Views out of the Scene when the Fragment
     *                   is preparing to close. <code>transition</code> must be an
     *                   android.transition.Transition.
     */
    public void setReturnTransition(final Object transition) {
        verifyMethodCalledFromDelegate("setReturnTransition(Object)");
        ((CallVoid1<Object>) mSuperListeners.pop()).call(transition);
    }

    /**
     * Sets the Transition that will be used for shared elements transferred into the content
     * Scene. Typical Transitions will affect size and location, such as
     * {@link ChangeBounds}. A null
     * value will cause transferred shared elements to blink to the final position.
     *
     * @param transition The Transition to use for shared elements transferred into the content
     *                   Scene.  <code>transition</code> must be an android.transition.Transition.
     */
    public void setSharedElementEnterTransition(final Object transition) {
        verifyMethodCalledFromDelegate("setSharedElementEnterTransition(Object)");
        ((CallVoid1<Object>) mSuperListeners.pop()).call(transition);
    }

    /**
     * Sets the Transition that will be used for shared elements transferred back during a
     * pop of the back stack. This Transition acts in the leaving Fragment.
     * Typical Transitions will affect size and location, such as
     * {@link ChangeBounds}. A null
     * value will cause transferred shared elements to blink to the final position.
     * If no value is set, the default will be to use the same value as
     * {@link #setSharedElementEnterTransition(Object)}.
     *
     * @param transition The Transition to use for shared elements transferred out of the content
     *                   Scene. <code>transition</code> must be an android.transition.Transition.
     */
    public void setSharedElementReturnTransition(final Object transition) {
        verifyMethodCalledFromDelegate("setSharedElementReturnTransition(Object)");
        ((CallVoid1<Object>) mSuperListeners.pop()).call(transition);
    }

    /**
     * Optional target for this fragment.  This may be used, for example,
     * if this fragment is being started by another, and when done wants to
     * give a result back to the first.  The target set here is retained
     * across instances via {@link FragmentManager#putFragment
     * FragmentManager.putFragment()}.
     *
     * @param fragment    The fragment that is the target of this one.
     * @param requestCode Optional request code, for convenience if you
     *                    are going to call back with {@link #onActivityResult(int, int, Intent)}.
     */
    public void setTargetFragment(final Fragment fragment, final int requestCode) {
        verifyMethodCalledFromDelegate("setTargetFragment(Fragment, Integer)");
        ((CallVoid2<Fragment, Integer>) mSuperListeners.pop()).call(fragment, requestCode);
    }

    /**
     * Set a hint to the system about whether this fragment's UI is currently visible
     * to the user. This hint defaults to true and is persistent across fragment instance
     * state save and restore.
     *
     * <p>An app may set this to false to indicate that the fragment's UI is
     * scrolled out of visibility or is otherwise not directly visible to the user.
     * This may be used by the system to prioritize operations such as fragment lifecycle updates
     * or loader ordering behavior.</p>
     *
     * <p><strong>Note:</strong> This method may be called outside of the fragment lifecycle.
     * and thus has no ordering guarantees with regard to fragment lifecycle method calls.</p>
     *
     * @param isVisibleToUser true if this fragment's UI is currently visible to the user
     *                        (default),
     *                        false if it is not.
     */
    public void setUserVisibleHint(final boolean isVisibleToUser) {
        verifyMethodCalledFromDelegate("setUserVisibleHint(Boolean)");
        ((CallVoid1<Boolean>) mSuperListeners.pop()).call(isVisibleToUser);
    }

    /**
     * Gets whether you should show UI with rationale for requesting a permission.
     * You should do this only if you do not have the permission and the context in
     * which the permission is requested does not clearly communicate to the user
     * what would be the benefit from granting this permission.
     * <p>
     * For example, if you write a camera app, requesting the camera permission
     * would be expected by the user and no rationale for why it is requested is
     * needed. If however, the app needs location for tagging photos then a non-tech
     * savvy user may wonder how location is related to taking photos. In this case
     * you may choose to show UI with rationale of requesting this permission.
     * </p>
     *
     * @param permission A permission your app wants to request.
     * @return Whether you can show permission rationale UI.
     * @see Context#checkSelfPermission(String)
     * @see #requestPermissions(String[], int)
     * @see #onRequestPermissionsResult(int, String[], int[])
     */
    public boolean shouldShowRequestPermissionRationale(@NonNull final String permission) {
        verifyMethodCalledFromDelegate("shouldShowRequestPermissionRationale(String)");
        return ((CallFun1<Boolean, String>) mSuperListeners.pop()).call(permission);
    }

    /**
     * Call {@link Activity#startActivity(Intent)} from the fragment's
     * containing Activity.
     */
    public void startActivity(final Intent intent) {
        verifyMethodCalledFromDelegate("startActivity(Intent)");
        ((CallVoid1<Intent>) mSuperListeners.pop()).call(intent);
    }

    /**
     * Call {@link Activity#startActivity(Intent, Bundle)} from the fragment's
     * containing Activity.
     */
    public void startActivity(final Intent intent, @Nullable final Bundle options) {
        verifyMethodCalledFromDelegate("startActivity(Intent, Bundle)");
        ((CallVoid2<Intent, Bundle>) mSuperListeners.pop()).call(intent, options);
    }

    /**
     * Call {@link Activity#startActivityForResult(Intent, int)} from the fragment's
     * containing Activity.
     */
    public void startActivityForResult(final Intent intent, final int requestCode) {
        verifyMethodCalledFromDelegate("startActivityForResult(Intent, Integer)");
        ((CallVoid2<Intent, Integer>) mSuperListeners.pop()).call(intent, requestCode);
    }

    /**
     * Call {@link Activity#startActivityForResult(Intent, int, Bundle)} from the fragment's
     * containing Activity.
     */
    public void startActivityForResult(final Intent intent, final int requestCode,
            @Nullable final Bundle options) {
        verifyMethodCalledFromDelegate("startActivityForResult(Intent, Integer, Bundle)");
        ((CallVoid3<Intent, Integer, Bundle>) mSuperListeners.pop())
                .call(intent, requestCode, options);
    }

    /**
     * Call {@link Activity#startIntentSenderForResult(IntentSender, int, Intent, int, int, int,
     * Bundle)} from the fragment's containing Activity.
     */
    public void startIntentSenderForResult(final IntentSender intent, final int requestCode,
            @Nullable final Intent fillInIntent, final int flagsMask, final int flagsValues,
            final int extraFlags, final Bundle options) throws IntentSender.SendIntentException {
        verifyMethodCalledFromDelegate(
                "startIntentSenderForResult(IntentSender, Integer, Intent, Integer, Integer, Integer, Bundle)");
        ((CallVoid7<IntentSender, Integer, Intent, Integer, Integer, Integer, Bundle>) mSuperListeners
                .pop()).call(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags,
                options);
    }

    /**
     * Begin postponed transitions after {@link #postponeEnterTransition()} was called.
     * If postponeEnterTransition() was called, you must call startPostponedEnterTransition()
     * or {@link FragmentManager#executePendingTransactions()} to complete the FragmentTransaction.
     * If postponement was interrupted with {@link FragmentManager#executePendingTransactions()},
     * before {@code startPostponedEnterTransition()}, animations may not run or may execute
     * improperly.
     *
     * @see Activity#startPostponedEnterTransition()
     */
    public void startPostponedEnterTransition() {
        verifyMethodCalledFromDelegate("startPostponedEnterTransition()");
        ((CallVoid0) mSuperListeners.pop()).call();
    }

    public String toString() {
        verifyMethodCalledFromDelegate("toString()");
        return ((CallFun0<String>) mSuperListeners.pop()).call();
    }

    /**
     * Prevents a context menu to be shown for the given view. This method will
     * remove the {@link OnCreateContextMenuListener} on the view.
     *
     * @param view The view that should stop showing a context menu.
     * @see #registerForContextMenu(View)
     */
    public void unregisterForContextMenu(final View view) {
        verifyMethodCalledFromDelegate("unregisterForContextMenu(View)");
        ((CallVoid1<View>) mSuperListeners.pop()).call(view);
    }

    void dump(final CallVoid4<String, FileDescriptor, PrintWriter, String[]> superCall,
            final String prefix, final FileDescriptor fd, final PrintWriter writer,
            final String[] args) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            dump(prefix, fd, writer, args);
        }
    }

    boolean getAllowEnterTransitionOverlap(final CallFun0<Boolean> superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return getAllowEnterTransitionOverlap();
        }
    }

    boolean getAllowReturnTransitionOverlap(final CallFun0<Boolean> superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return getAllowReturnTransitionOverlap();
        }
    }

    Context getContext(final CallFun0<Context> superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return getContext();
        }
    }

    Object getEnterTransition(final CallFun0<Object> superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return getEnterTransition();
        }
    }

    Object getExitTransition(final CallFun0<Object> superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return getExitTransition();
        }
    }

    LayoutInflater getLayoutInflater(final CallFun1<LayoutInflater, Bundle> superCall,
            final Bundle savedInstanceState) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return getLayoutInflater(savedInstanceState);
        }
    }

    LoaderManager getLoaderManager(final CallFun0<LoaderManager> superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return getLoaderManager();
        }
    }

    Object getReenterTransition(final CallFun0<Object> superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return getReenterTransition();
        }
    }

    Object getReturnTransition(final CallFun0<Object> superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return getReturnTransition();
        }
    }

    Object getSharedElementEnterTransition(final CallFun0<Object> superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return getSharedElementEnterTransition();
        }
    }

    Object getSharedElementReturnTransition(final CallFun0<Object> superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return getSharedElementReturnTransition();
        }
    }

    boolean getUserVisibleHint(final CallFun0<Boolean> superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return getUserVisibleHint();
        }
    }

    View getView(final CallFun0<View> superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return getView();
        }
    }

    void onActivityCreated(final CallVoid1<Bundle> superCall,
            @Nullable final Bundle savedInstanceState) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onActivityCreated(savedInstanceState);
        }
    }

    void onActivityResult(final CallVoid3<Integer, Integer, Intent> superCall,
            final int requestCode, final int resultCode, final Intent data) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onActivityResult(requestCode, resultCode, data);
        }
    }

    void onAttach(final CallVoid1<Context> superCall, final Context context) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onAttach(context);
        }
    }

    void onAttach(final CallVoid1<Activity> superCall, final Activity activity) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onAttach(activity);
        }
    }

    void onAttachFragment(final CallVoid1<Fragment> superCall, final Fragment childFragment) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onAttachFragment(childFragment);
        }
    }

    void onConfigurationChanged(final CallVoid1<Configuration> superCall,
            final Configuration newConfig) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onConfigurationChanged(newConfig);
        }
    }

    boolean onContextItemSelected(final CallFun1<Boolean, MenuItem> superCall,
            final MenuItem item) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return onContextItemSelected(item);
        }
    }

    void onCreate(final CallVoid1<Bundle> superCall, @Nullable final Bundle savedInstanceState) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onCreate(savedInstanceState);
        }
    }

    Animation onCreateAnimation(final CallFun3<Animation, Integer, Boolean, Integer> superCall,
            final int transit, final boolean enter, final int nextAnim) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return onCreateAnimation(transit, enter, nextAnim);
        }
    }

    void onCreateContextMenu(
            final CallVoid3<ContextMenu, View, ContextMenu.ContextMenuInfo> superCall,
            final ContextMenu menu, final View v, final ContextMenu.ContextMenuInfo menuInfo) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onCreateContextMenu(menu, v, menuInfo);
        }
    }

    void onCreateOptionsMenu(final CallVoid2<Menu, MenuInflater> superCall, final Menu menu,
            final MenuInflater inflater) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onCreateOptionsMenu(menu, inflater);
        }
    }

    View onCreateView(final CallFun3<View, LayoutInflater, ViewGroup, Bundle> superCall,
            final LayoutInflater inflater, @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return onCreateView(inflater, container, savedInstanceState);
        }
    }

    void onDestroy(final CallVoid0 superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onDestroy();
        }
    }

    void onDestroyOptionsMenu(final CallVoid0 superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onDestroyOptionsMenu();
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

    void onHiddenChanged(final CallVoid1<Boolean> superCall, final boolean hidden) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onHiddenChanged(hidden);
        }
    }

    void onInflate(final CallVoid3<Context, AttributeSet, Bundle> superCall, final Context context,
            final AttributeSet attrs, final Bundle savedInstanceState) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onInflate(context, attrs, savedInstanceState);
        }
    }

    void onInflate(final CallVoid3<Activity, AttributeSet, Bundle> superCall,
            final Activity activity, final AttributeSet attrs, final Bundle savedInstanceState) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onInflate(activity, attrs, savedInstanceState);
        }
    }

    void onLowMemory(final CallVoid0 superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onLowMemory();
        }
    }

    void onMultiWindowModeChanged(final CallVoid1<Boolean> superCall,
            final boolean isInMultiWindowMode) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onMultiWindowModeChanged(isInMultiWindowMode);
        }
    }

    boolean onOptionsItemSelected(final CallFun1<Boolean, MenuItem> superCall,
            final MenuItem item) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return onOptionsItemSelected(item);
        }
    }

    void onOptionsMenuClosed(final CallVoid1<Menu> superCall, final Menu menu) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onOptionsMenuClosed(menu);
        }
    }

    void onPause(final CallVoid0 superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onPause();
        }
    }

    void onPictureInPictureModeChanged(final CallVoid1<Boolean> superCall,
            final boolean isInPictureInPictureMode) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onPictureInPictureModeChanged(isInPictureInPictureMode);
        }
    }

    void onPrepareOptionsMenu(final CallVoid1<Menu> superCall, final Menu menu) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onPrepareOptionsMenu(menu);
        }
    }

    void onRequestPermissionsResult(final CallVoid3<Integer, String[], int[]> superCall,
            final int requestCode, @NonNull final String[] permissions,
            @NonNull final int[] grantResults) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    void onResume(final CallVoid0 superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onResume();
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

    void onViewCreated(final CallVoid2<View, Bundle> superCall, final View view,
            @Nullable final Bundle savedInstanceState) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onViewCreated(view, savedInstanceState);
        }
    }

    void onViewStateRestored(final CallVoid1<Bundle> superCall,
            @Nullable final Bundle savedInstanceState) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            onViewStateRestored(savedInstanceState);
        }
    }

    void postponeEnterTransition(final CallVoid0 superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            postponeEnterTransition();
        }
    }

    void registerForContextMenu(final CallVoid1<View> superCall, final View view) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            registerForContextMenu(view);
        }
    }

    void setAllowEnterTransitionOverlap(final CallVoid1<Boolean> superCall, final boolean allow) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setAllowEnterTransitionOverlap(allow);
        }
    }

    void setAllowReturnTransitionOverlap(final CallVoid1<Boolean> superCall, final boolean allow) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setAllowReturnTransitionOverlap(allow);
        }
    }

    void setArguments(final CallVoid1<Bundle> superCall, final Bundle args) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setArguments(args);
        }
    }

    void setEnterSharedElementCallback(final CallVoid1<SharedElementCallback> superCall,
            final SharedElementCallback callback) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setEnterSharedElementCallback(callback);
        }
    }

    void setEnterTransition(final CallVoid1<Object> superCall, final Object transition) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setEnterTransition(transition);
        }
    }

    void setExitSharedElementCallback(final CallVoid1<SharedElementCallback> superCall,
            final SharedElementCallback callback) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setExitSharedElementCallback(callback);
        }
    }

    void setExitTransition(final CallVoid1<Object> superCall, final Object transition) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setExitTransition(transition);
        }
    }

    void setHasOptionsMenu(final CallVoid1<Boolean> superCall, final boolean hasMenu) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setHasOptionsMenu(hasMenu);
        }
    }

    void setInitialSavedState(final CallVoid1<Fragment.SavedState> superCall,
            final Fragment.SavedState state) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setInitialSavedState(state);
        }
    }

    void setMenuVisibility(final CallVoid1<Boolean> superCall, final boolean menuVisible) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setMenuVisibility(menuVisible);
        }
    }

    void setReenterTransition(final CallVoid1<Object> superCall, final Object transition) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setReenterTransition(transition);
        }
    }

    void setRetainInstance(final CallVoid1<Boolean> superCall, final boolean retain) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setRetainInstance(retain);
        }
    }

    void setReturnTransition(final CallVoid1<Object> superCall, final Object transition) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setReturnTransition(transition);
        }
    }

    void setSharedElementEnterTransition(final CallVoid1<Object> superCall,
            final Object transition) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setSharedElementEnterTransition(transition);
        }
    }

    void setSharedElementReturnTransition(final CallVoid1<Object> superCall,
            final Object transition) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setSharedElementReturnTransition(transition);
        }
    }

    void setTargetFragment(final CallVoid2<Fragment, Integer> superCall, final Fragment fragment,
            final int requestCode) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setTargetFragment(fragment, requestCode);
        }
    }

    void setUserVisibleHint(final CallVoid1<Boolean> superCall, final boolean isVisibleToUser) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            setUserVisibleHint(isVisibleToUser);
        }
    }

    boolean shouldShowRequestPermissionRationale(final CallFun1<Boolean, String> superCall,
            @NonNull final String permission) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return shouldShowRequestPermissionRationale(permission);
        }
    }

    void startActivity(final CallVoid1<Intent> superCall, final Intent intent) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            startActivity(intent);
        }
    }

    void startActivity(final CallVoid2<Intent, Bundle> superCall, final Intent intent,
            @Nullable final Bundle options) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            startActivity(intent, options);
        }
    }

    void startActivityForResult(final CallVoid2<Intent, Integer> superCall, final Intent intent,
            final int requestCode) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            startActivityForResult(intent, requestCode);
        }
    }

    void startActivityForResult(final CallVoid3<Intent, Integer, Bundle> superCall,
            final Intent intent, final int requestCode, @Nullable final Bundle options) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            startActivityForResult(intent, requestCode, options);
        }
    }

    void startIntentSenderForResult(
            final CallVoid7<IntentSender, Integer, Intent, Integer, Integer, Integer, Bundle> superCall,
            final IntentSender intent, final int requestCode, @Nullable final Intent fillInIntent,
            final int flagsMask, final int flagsValues, final int extraFlags, final Bundle options)
            throws IntentSender.SendIntentException {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues,
                    extraFlags, options);
        }
    }

    void startPostponedEnterTransition(final CallVoid0 superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            startPostponedEnterTransition();
        }
    }

    String toString(final CallFun0<String> superCall) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            return toString();
        }
    }

    void unregisterForContextMenu(final CallVoid1<View> superCall, final View view) {
        synchronized (mSuperListeners) {
            mSuperListeners.push(superCall);
            unregisterForContextMenu(view);
        }
    }


}