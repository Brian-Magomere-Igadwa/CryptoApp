package design.propia.cryptoapp.data.remote

import design.propia.cryptoapp.data.remote.dto.CoinDetailDto
import design.propia.cryptoapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path


interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins():List<CoinDto>

    @GET("/v1/coin/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId:String):CoinDetailDto
}