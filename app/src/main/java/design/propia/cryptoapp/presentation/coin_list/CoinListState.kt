package design.propia.cryptoapp.presentation.coin_list

import design.propia.cryptoapp.domain.models.Coin

data class CoinListState(
    val isLoading:Boolean=false,
    val coins:List<Coin>,
    val error: String=""
    )
