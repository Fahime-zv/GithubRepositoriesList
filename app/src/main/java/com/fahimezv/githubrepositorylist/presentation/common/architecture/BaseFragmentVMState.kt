
package com.fahimezv.githubrepositorylist.presentation.common.architecture

import android.os.Bundle
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import android.view.View
import androidx.annotation.CallSuper

/**
 * BaseFragmentVMState, where all [UiState] get observed.
 * You should extend this fragment whenever you have a Fragment with a ViewModel that may change the
 * [UiState].
 * */
abstract class BaseFragmentVMState<V : View, VM : BaseViewModelState> : BaseFragmentVM<V, VM>() {

    abstract override val viewModel: VM

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (view is ViewState) {
            viewModel.getUiStateLiveData().observe(viewLifecycleOwner) {
                Log.d(TAG, "UiState: $it")
                when (it) {
                    UiState.Loading -> view.onLoading()
                    UiState.Empty -> view.onEmpty()
                    UiState.Data -> view.onData()
                    UiState.NetworkError -> view.onNetworkError()
                    is UiState.ApiError -> view.onApiError(
                        it.msg ?: "An Error Occurred"
                    )
                }
            }
        } else {
            throw RuntimeException("Your view must implement ViewState interface!")
        }

    }

}