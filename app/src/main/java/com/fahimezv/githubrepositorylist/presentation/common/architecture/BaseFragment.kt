package com.fahimezv.githubrepositorylist.presentation.common.architecture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController


/**
 * BaseFragment, where all default view settings are applied here.
 * You should extend this fragment when you don't have a ViewModel for your fragment.
 * */
abstract class BaseFragment<V : View> : Fragment() {

    protected var rootView: V? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View{
        return onCreateRootView(inflater, container, savedInstanceState).also {
            rootView=it
        }
    }

    abstract fun onCreateRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): V

    protected fun navigate(direction: NavDirections) {
        findNavController().navigate(direction)
    }

    protected fun navigateUp() {
        findNavController().popBackStack()
    }

    protected fun navigateUpTo(destinationId: Int) {
        findNavController().popBackStack(destinationId, false)
    }

    protected open fun onDestroyRootView() {
        // Implement if needed
    }


    @CallSuper
    final override fun onDestroyView() {
        onDestroyRootView()
        rootView = null
        super.onDestroyView()
    }

}