package com.fahimezv.githubrepositorylist.data.network.service

import com.fahimezv.githubrepositorylist.data.network.generator.NetworkServiceFactory
import com.fahimezv.githubrepositorylist.data.network.service.retrofit.ReposService
import com.fahimezv.githubrepositorylist.data.network.service.retrofit.UsersService

class ServiceProviderImpl(private val serviceFactory: NetworkServiceFactory) : ServiceProvider {

    override fun getUsersService(): UsersService {
        return serviceFactory.create(UsersService::class.java)
    }

    override fun getReposService(): ReposService {
        return serviceFactory.create(ReposService::class.java)
    }

}