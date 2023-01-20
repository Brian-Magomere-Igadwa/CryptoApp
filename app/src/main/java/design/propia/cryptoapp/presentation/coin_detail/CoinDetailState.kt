package design.propia.cryptoapp.presentation.coin_detail

import design.propia.cryptoapp.domain.models.Coin
import design.propia.cryptoapp.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
