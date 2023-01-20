package design.propia.cryptoapp.domain.use_case.get_coin

import design.propia.cryptoapp.common.Resource
import design.propia.cryptoapp.data.remote.dto.toCoin
import design.propia.cryptoapp.data.remote.dto.toCoinDetail
import design.propia.cryptoapp.domain.models.Coin
import design.propia.cryptoapp.domain.models.CoinDetail
import design.propia.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    //A use case should have one public function
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {

            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}