package com.fahimezv.githubrepositorylist.data.network.repository

import com.fahimezv.githubrepositorylist.core.entity.Event
import com.fahimezv.githubrepositorylist.data.network.model.Result
import com.fahimezv.githubrepositorylist.data.network.model.dao.EventDAO
import com.fahimezv.githubrepositorylist.data.network.service.retrofit.ReposService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.anyString
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class RepoRepositoryTest : BaseCoroutineTest() {

    private lateinit var repository: RepoRepository
    private val service: ReposService = mock()

    private val eventDao = EventDAO(id = 1, type = "type", actor = EventDAO.ActorDAO("login", "any url"))
    private val event = Event(id = 1, type = "type", actor = Event.Actor("login", "any url"))

    @Before
    fun setUp() {
        repository = RepoRepository(service)
    }

    @Test
    fun `when put username and repoName in events() should return list of Event Model `() {

        testCoroutineRule.runBlockingTest {
            whenever(
                service.events(anyString(), anyString())
            ).thenReturn(listOf(eventDao))

            val actual = repository.events("Not important", "Not important")
            assertEquals(Result.Data(listOf(event)), actual)
        }
    }

}