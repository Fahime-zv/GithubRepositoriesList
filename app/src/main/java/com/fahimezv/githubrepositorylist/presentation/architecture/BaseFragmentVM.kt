
package com.fahimezv.githubrepositorylist.presentation.architecture

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.navigation.fragment.findNavController

/**
 * BaseFragmentVM, where all navigation commands get observed.
 * You should extend this fragment when you have a Fragment with a ViewModel without any operations
 * that changes the [UiState].
 * If you need to change the [UiState] you should extend the [BaseViewModelState]
 * */
abstract class BaseFragmentVM<V : View, VM : BaseViewModel> : BaseFragment<V>() {

    protected abstract val viewModel: VM

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe NavigationCommands
        viewModel.getNavigationCommandsLiveData()
            .observe(viewLifecycleOwner) { navigationCommand ->
                when (navigationCommand) {
                    is NavigationCommand.To -> navigate(navigationCommand.directions)
                    NavigationCommand.Back -> navigateUp()
                    // This Command didn't implemented in BaseViewModel due to problems it creates
                    // in writing tests for VMs
                    is NavigationCommand.BackTo -> findNavController().popBackStack(
                        navigationCommand.destinationId,
                        false
                    )
                }
            }
    }

}