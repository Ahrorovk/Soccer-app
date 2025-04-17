package krikya.io.soccerapp.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import krikya.io.soccerapp.core.Resource
import krikya.io.soccerapp.data.model.league.LeaguesResponse
import krikya.io.soccerapp.domain.SoccerRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetLeaguesUseCase @Inject constructor(
    private val repository: SoccerRepository
) {
    operator fun invoke(): Flow<Resource<LeaguesResponse>> =
        flow {
            try {
                emit(Resource.Loading<LeaguesResponse>())
                val response = repository.getLeagues()
                emit(Resource.Success<LeaguesResponse>(response))
            } catch (e: HttpException) {
                emit(
                    Resource.Error<LeaguesResponse>(
                        e.localizedMessage
                            ?: "An unexpected error has occurred"
                    )
                )
            } catch (e: IOException) {
                emit(Resource.Error<LeaguesResponse>("Не удалось связаться с сервером. Проверьте подключение к Интернету."))
            } catch (e: Exception) {
                emit(
                    Resource.Error<LeaguesResponse>(
                        "${e.message}"
                    )
                )
            }
        }
}