public class FragmentShortCut {

    private final static String TAG = "FragmentUtils";

    //FragmentManager to be used in case the class has been instantiated.
    private final FragmentManager mFragmentManager;

    /**
     * Constructor
     *
     * @param fragmentManager FragmentManager to be used in case the developer
     *                        instantiates this class
     */
    public FragmentShortCut(@NonNull FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }

    /**
     * Adds a fragment into the desired container.
     *
     * @param containerId Id of the container
     * @param fragment    Fragment to be added
     * @param tag         Fragment tag
     */
    public void addFragment(int containerId, Fragment fragment, String tag) {
        addFragment(mFragmentManager, containerId, fragment, tag);
    }

    /**
     * Replaces the container content with the desired fragment.
     *
     * @param containerId Id of the container
     * @param fragment    Fragment that will replace the current content
     * @param tag         Fragment tag
     */
    public void replaceFragment(int containerId, Fragment fragment, String tag) {
        replaceFragment(mFragmentManager, containerId, fragment, tag);
    }

    /**
     * Removes a fragment by tag
     * =
     *
     * @param tag Fragment tag
     */
    public void removeFragment(String tag) {
        removeFragment(mFragmentManager, tag);
    }

    /**
     * Returns a fragment of the specified type if found in the fragment manager and is instance of the desired type.
     * =
     *
     * @param fragmentClass Fragment type
     * @param tag           Fragment tag
     * @param <T>           Fragment type
     * @return Fragment of T type
     */
    public <T> T getFragmentByTag(Class<T> fragmentClass, String tag) {
        return getFragmentByTag(mFragmentManager, fragmentClass, tag);
    }

    /**
     * Adds a fragment into the desired container.
     *
     * @param manager     Fragment Manager
     * @param containerId Id of the container
     * @param fragment    Fragment to be added
     * @param tag         Fragment tag
     */
    public static void addFragment(FragmentManager manager, int containerId, Fragment fragment, String tag) {
        if (!manager.isStateSaved()) {
            manager.beginTransaction().add(containerId, fragment, tag).commit();
        }
    }

    /**
     * Replaces the container content with the desired fragment.
     *
     * @param manager     Fragment Manager
     * @param containerId Id of the container
     * @param fragment    Fragment that will replace the current content
     * @param tag         Fragment tag
     */
    public static void replaceFragment(FragmentManager manager, int containerId, Fragment fragment, String tag) {
        if (!manager.isStateSaved()) {
            manager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).setCustomAnimations(
                    R.anim.slide_in,  // enter
                    R.anim.fade_out,  // exit
                    R.anim.fade_in,   // popEnter
                    R.anim.slide_out  // popExit
            ).replace(containerId, fragment, tag).addToBackStack(null).commit();
        }
    }

    public void replaceFragment(FragmentManager manager,Fragment fragment,String tag, boolean isAddToBackStack) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter// popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.relativeLayoutFragmentMainContainer, fragment);
        if (isAddToBackStack) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }

    public void addFragment(FragmentManager manager,Fragment fragment,String tag, boolean isAddToBackStack) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.relativeLayoutFragmentMainContainer, fragment);
        if (isAddToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    /**
     * Removes a fragment by tag
     *
     * @param manager Fragment Manager
     * @param tag     Fragment tag
     */
    public static void removeFragment(FragmentManager manager, String tag) {
        Fragment fragment = manager.findFragmentByTag(tag);
        if (!manager.isStateSaved() && fragment != null) {
            manager.beginTransaction().remove(fragment).commit();
        }
    }

    /**
     * Returns a fragment of the specified type if found in the fragment manager and is instance of the desired type.
     *
     * @param manager       Fragment Manager
     * @param fragmentClass Fragment type
     * @param tag           Fragment tag
     * @param <T>           Fragment type
     * @return Fragment of T type
     */
    public static <T> T getFragmentByTag(FragmentManager manager, Class<T> fragmentClass, String tag) {
        Fragment fragment = manager.findFragmentByTag(tag);

        if (fragment != null) {
            if (fragment.getClass().isAssignableFrom(fragmentClass)) {
                return fragmentClass.cast(fragment);
            } else if (fragment.getClass().getSuperclass().isAssignableFrom(fragmentClass)) {
                return (T) fragment;
            }
        }

        return null;
    }
    public static void replaceFragmentBackStack(FragmentManager fragmentManager,Fragment fragment,String tag, boolean isAddToBackStack) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(R.id.relativeLayoutFragmentMainContainer, fragment);
        if (isAddToBackStack) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }
    public static void replaceFragmentBackStack(FragmentManager fragmentManager,int container,Fragment fragment,String tag, boolean isAddToBackStack) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter
                R.anim.fade_out,  // exit
                R.anim.fade_in,   // popEnter
                R.anim.slide_out  // popExit
        ).replace(container, fragment);
        if (isAddToBackStack) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }

    public static void addFragmentBackStack(FragmentManager fragmentManager, Fragment fragment,String tag, boolean isAddToBackStack) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter// popEnter
                R.anim.slide_out  // popExit
        ).add(R.id.relativeLayoutFragmentMainContainer, fragment);
        if (isAddToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    public static void addFragmentBackStack(FragmentManager fragmentManager, int containerID,Fragment fragment,String tag, boolean isAddToBackStack){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in,  // enter// popEnter
                R.anim.slide_out  // popExit
        ).add(containerID, fragment);
        if (isAddToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }




}
