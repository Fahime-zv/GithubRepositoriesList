package com.fahimezv.githubrepositorylist.data.network.model.dao

import com.fahimezv.githubrepositorylist.core.entity.Event
import com.google.gson.annotations.SerializedName

data class EventDAO(
    @SerializedName("id") val id: Long,
    @SerializedName("type") val type: String,
    @SerializedName("actor") val actor: ActorDAO,
) : MappableDAO<Event> {

    override fun map(): Event {
        return Event(id = id, type, actor.map())
    }

    data class ActorDAO(
        @SerializedName("display_login") val display_login: String,
        @SerializedName("url") val url: String,
    ) : MappableDAO<Event.Actor> {

        override fun map(): Event.Actor {
            return Event.Actor(display_login, url)
        }
    }


}

