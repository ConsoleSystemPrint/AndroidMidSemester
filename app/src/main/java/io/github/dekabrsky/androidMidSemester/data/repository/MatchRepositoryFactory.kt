package io.github.dekabrsky.androidMidSemester.data.repository

import io.github.dekabrsky.androidMidSemester.data.api.EspnApi
import io.github.dekabrsky.androidMidSemester.data.api.SStatsApi
import io.github.dekabrsky.androidMidSemester.data.cache.MatchCache
import io.github.dekabrsky.androidMidSemester.domain.repository.MatchRepository
import retrofit2.Retrofit

enum class MatchDataProvider { ESPN, SSTATS }

fun createMatchRepository(
    retrofit: Retrofit,
    cache: MatchCache,
    provider: MatchDataProvider,
): MatchRepository = when (provider) {
    MatchDataProvider.ESPN -> EspnMatchRepositoryImpl(
        api = retrofit.newBuilder()
            .baseUrl("https://site.api.espn.com/")
            .build()
            .create(EspnApi::class.java),
        cache = cache,
    )
    MatchDataProvider.SSTATS -> SStatsMatchRepositoryImpl(
        api = retrofit.newBuilder()
            .baseUrl("https://api.sstats.net/")
            .build()
            .create(SStatsApi::class.java),
        cache = cache,
    )
}
