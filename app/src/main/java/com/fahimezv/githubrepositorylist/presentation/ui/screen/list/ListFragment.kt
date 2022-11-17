package com.fahimezv.githubrepositorylist.presentation.ui.screen.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.paging.LoadState
import com.fahimezv.githubrepositorylist.presentation.common.architecture.BaseFragmentVMState
import com.fahimezv.githubrepositorylist.presentation.common.paging.PagingExceptions
import com.fahimezv.githubrepositorylist.presentation.extentions.TAG
import com.fahimezv.githubrepositorylist.presentation.provider.StringProvider
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ListFragment : BaseFragmentVMState<ListView, ListViewModel>() {

    //View Model
    override val viewModel: ListViewModel by viewModel {
        parametersOf(args.userName)
    }
    private val args: ListFragmentArgs by navArgs()

    override fun onCreateRootView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): ListView {
        return ListView(
            context = requireContext(),
            onRepositoryClickListener = { repoModel ->
                navigate(ListFragmentDirections.actionListFragmentToDetailFragment(repoModel))
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Observer
        viewModel.repoLiveData.observe(viewLifecycleOwner) { pagingData ->
            viewLifecycleOwner.lifecycleScope.launch {
                rootView?.bind(pagingData)
            }
        }

        // Observe Pagination State
        rootView?.repositoryAdapter?.apply {
            addLoadStateListener { loadState ->
                Log.d(TAG, loadState.toString())
                if (loadState.refresh is LoadState.NotLoading && itemCount == 0) { // show empty list
                    rootView?.onEmpty()
                } else if (loadState.source.refresh is LoadState.Loading) { // Show loading spinner during initial load or refresh.
                    rootView?.onLoading()
                } else if (loadState.source.refresh is LoadState.NotLoading) { // Only show the list if refresh succeeds.
                    rootView?.onData()
                } else if (loadState.source.refresh is LoadState.Error) { // Show the retry state if initial load or refresh fails.
                    val errorState = loadState.source.append as? LoadState.Error
                        ?: loadState.source.prepend as? LoadState.Error
                    if (errorState?.error is PagingExceptions.ApiErrorException) {
                        rootView?.onApiError(
                            (errorState.error as PagingExceptions.ApiErrorException).msg
                                ?: StringProvider.somethingHappened
                        )
                    } else {
                        rootView?.onNetworkError()
                    }
                }
            }
        }
    }
}


