package com.fahimezv.githubrepositorylist.data.network.service

import com.fahimezv.githubrepositorylist.data.network.service.retrofit.ReposService
import com.fahimezv.githubrepositorylist.data.network.service.retrofit.UsersService

interface ServiceProvider {
    fun  getUsersService():UsersService
    fun  getReposService():ReposService
}