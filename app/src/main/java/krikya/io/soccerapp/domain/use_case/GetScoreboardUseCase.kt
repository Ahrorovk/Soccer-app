package krikya.io.soccerapp.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import krikya.io.soccerapp.core.Resource
import krikya.io.soccerapp.data.model.soccer.SoccerResponse
import krikya.io.soccerapp.domain.SoccerRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetScoreboardUseCase @Inject constructor(
    private val repository: SoccerRepository
) {
    operator fun invoke(
        leagueId: String
    ): Flow<Resource<SoccerResponse>> =
        flow {
            try {
                emit(Resource.Loading<SoccerResponse>())
                val response = repository.getScoreboard(leagueId)
                emit(Resource.Success<SoccerResponse>(response))
            } catch (e: HttpException) {
                emit(
                    Resource.Error<SoccerResponse>(
                        e.localizedMessage
                            ?: "An unexpected error has occurred"
                    )
                )
            } catch (e: IOException) {
                emit(Resource.Error<SoccerResponse>("Не удалось связаться с сервером. Проверьте подключение к Интернету."))
            } catch (e: Exception) {
                emit(
                    Resource.Error<SoccerResponse>(
                        "${e.message}"
                    )
                )
            }
        }
}