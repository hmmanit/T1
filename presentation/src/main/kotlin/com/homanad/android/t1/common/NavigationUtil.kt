package com.homanad.android.t1.common

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController

fun Fragment.safeNavigate(@IdRes currentId: Int, directions: NavDirections) {
    if (findNavController().currentDestination?.id == currentId)
        findNavController().navigate(directions.actionId, directions.arguments);
}

fun Fragment.safeNavigate(@IdRes currentId: Int, directions: NavDirections, navOptions: NavOptions?) {
    if (findNavController().currentDestination?.id == currentId)
        findNavController().navigate(directions.actionId, directions.arguments, navOptions)
}

fun Fragment.safeNavigate(@IdRes currentId: Int, directions: NavDirections, navigatorExtras: Navigator.Extras) {
    if (findNavController().currentDestination?.id == currentId)
        findNavController().navigate(directions.actionId, directions.arguments, null, navigatorExtras)
}