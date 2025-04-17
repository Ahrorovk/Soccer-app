package krikya.io.soccerapp.domain.use_case

import krikya.io.soccerapp.domain.SoccerRepository
import javax.inject.Inject

class GetGameByIdFromDBUseCase @Inject constructor(
    private val repository: SoccerRepository
) {
    suspend operator fun invoke(id: Int): SoccerEntity? {
        return repository.getGameByIdFromDB(id)
    }
}