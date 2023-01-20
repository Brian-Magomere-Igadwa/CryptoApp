package design.propia.cryptoapp.domain.use_case.get_coins

import design.propia.cryptoapp.common.Resource
import design.propia.cryptoapp.data.remote.dto.toCoin
import design.propia.cryptoapp.domain.models.Coin
import design.propia.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    //A use case should have one public function
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {

            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}