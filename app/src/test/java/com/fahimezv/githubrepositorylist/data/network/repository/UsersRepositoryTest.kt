package com.fahimezv.githubrepositorylist.data.network.repository

import com.fahimezv.githubrepositorylist.core.entity.Repo
import com.fahimezv.githubrepositorylist.data.network.model.Result
import com.fahimezv.githubrepositorylist.data.network.model.dao.RepoDAO
import com.fahimezv.githubrepositorylist.data.network.service.retrofit.UsersService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class UsersRepositoryTest : BaseCoroutineTest() {

    private lateinit var repository: UsersRepository
    private val service: UsersService = mock()

    private val repoDao = RepoDAO(id = 1, name = "name", url = "any url", owner = RepoDAO.OwnerDAO("login", "any url"))
    private val repo = Repo(id = 1, name = "name", url = "any url", owner = Repo.Owner("login", "any url"))

    @Before
    fun setUp() {
        repository = UsersRepository(service)
    }

    @Test
    fun `when put username  in repos() should return list of Repo Model `() {

        testCoroutineRule.runBlockingTest {
            whenever(
                service.repos(anyString(), anyString(), anyString(), anyInt(), anyInt())
            ).thenReturn(listOf(repoDao))

            val actual = repository.repos("Not important", 1, 20)
            assertEquals(Result.Data(listOf(repo)), actual)
        }
    }

}