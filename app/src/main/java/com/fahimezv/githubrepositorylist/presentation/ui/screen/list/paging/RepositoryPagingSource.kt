package com.fahimezv.githubrepositorylist.presentation.ui.screen.list.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fahimezv.githubrepositorylist.data.network.model.Result
import com.fahimezv.githubrepositorylist.data.network.model.dao.RepoDAO
import com.fahimezv.githubrepositorylist.data.network.repository.UsersRepository

private const val STARTING_PAGE_INDEX = 1
private const val NETWORK_PAGE_SIZE = 30


class RepositoryPagingSource(
    private val userName: String,
    private val usersRepository: UsersRepository,
) : PagingSource<Int, RepoDAO>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RepoDAO> {
        with(usersRepository.repos(userName = userName, pageIndex = params.key ?: 1, pageSize = NETWORK_PAGE_SIZE)) {
            return when (this) {
                is Result.Data -> {
                    LoadResult.Page(
                        data = this.model,
                        prevKey = null,
                        nextKey = if (this.model.size == NETWORK_PAGE_SIZE) params.key?.plus(1) else null
                    )
                }
                is Result.NetworkError -> {
                    LoadResult.Error(Throwable())
                }
            }


        }
    }

    /**
     * The refresh key is used for subsequent calls to PagingSource.Load after the initial load.
     */
    override fun getRefreshKey(state: PagingState<Int, RepoDAO>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index.
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}