package design.propia.cryptoapp.domain.models

import design.propia.cryptoapp.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId:String,
    val name:String,
    val description:String,
    val symbol:String,
    val rank:Int,
    val is_active:Boolean,
    val tags:List<String>,
    val team:List<TeamMember>
)
