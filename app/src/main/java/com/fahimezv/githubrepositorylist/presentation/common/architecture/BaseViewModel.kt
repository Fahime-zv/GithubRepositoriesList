package com.fahimezv.githubrepositorylist.presentation.common.architecture

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections

abstract class BaseViewModel : ViewModel() {

    /**
     * Some convenience functions to have the navigation ability in viewModels directly.
     *
     * Examples:
     *
     * + Go to another fragment:
     *
     * navigate(ChooseLanguageFragmentDirections.actionChooseLanguageFragmentToHomeFragment())
     *
     * + Go to previous fragment:
     *
     * navigateUp()
     */

    private val navigationCommandsLiveData = SingleEventLiveData<NavigationCommand>()

    fun getNavigationCommandsLiveData(): SingleEventLiveData<NavigationCommand> =
        navigationCommandsLiveData

    protected fun navigate(directions: NavDirections) {
        navigationCommandsLiveData.postValue(NavigationCommand.To(directions))
    }

    protected fun navigateUp() {
        navigationCommandsLiveData.postValue(NavigationCommand.Back)
    }

    protected fun navigateUpTo(destinationId: Int) {
        navigationCommandsLiveData.postValue(NavigationCommand.BackTo(destinationId))
    }


}