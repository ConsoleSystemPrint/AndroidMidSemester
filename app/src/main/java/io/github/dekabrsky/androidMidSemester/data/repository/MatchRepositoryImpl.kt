package io.github.dekabrsky.androidMidSemester.data.repository

import io.github.dekabrsky.androidMidSemester.data.cache.MatchCache
import io.github.dekabrsky.androidMidSemester.domain.repository.MatchRepository
import retrofit2.Retrofit

class MatchRepositoryImpl(
    retrofit: Retrofit,
    cache: MatchCache,
    provider: MatchDataProvider = MatchDataProvider.ESPN,
) : MatchRepository by createMatchRepository(retrofit, cache, provider)
