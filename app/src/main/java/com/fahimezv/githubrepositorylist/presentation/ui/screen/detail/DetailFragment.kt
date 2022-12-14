package com.fahimezv.githubrepositorylist.presentation.ui.screen.detail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.fahimezv.githubrepositorylist.presentation.common.architecture.BaseFragmentVMState
import com.fahimezv.githubrepositorylist.presentation.provider.ColorProvider
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailFragment : BaseFragmentVMState<DetailView, DetailViewModel>() {

    //ViewModel
    override val viewModel: DetailViewModel by viewModel {
        parametersOf(args.repoModel,args.userName)
    }

    //args
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateRootView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): DetailView {
        return DetailView(
            context = requireContext(),
            userName =args.userName,
            repo = args.repoModel
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setBackgroundColor(Color.parseColor(ColorProvider.grayLight))
        //observer
        viewModel.getEventLiveData().observe(viewLifecycleOwner){lastEvent->
            rootView?.bind(lastEvent)
        }

    }
}
