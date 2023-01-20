package design.propia.cryptoapp.data.remote.dto

import design.propia.cryptoapp.domain.models.Coin

data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = this.id,
        is_active = this.is_active,
        name = this.name,
        rank = this.rank,
        symbol = this.symbol
    )
}