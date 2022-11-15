package com.fahimezv.githubrepositorylist.data.network.model.dao

import com.fahimezv.githubrepositorylist.core.entity.NetworkReceivedModel

interface MappableDAO<M : NetworkReceivedModel> {
    fun map(): M
}