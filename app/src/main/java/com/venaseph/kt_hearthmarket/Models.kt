package com.venaseph.kt_hearthmarket

/**
 * Created by cpera on 12/28/2017.
 */

//model object for feed, public as suggested GSON library vals must match JSON objects key names
class CardFeed(val Basic: List<Card>)

class Card(val name: String, val text: String, val flavor: String, val img: String)
//each subsection[] would go as a "subclass here and get referenced in class model above

/*
[
{
    "cardId": "EX1_116",
    "dbfId": "559",
    "name": "Leeroy Jenkins",
    "cardSet": "Classic",
    "type": "Minion",
    "faction": "Alliance",
    "rarity": "Legendary",
    "cost": 5,
    "attack": 6,
    "health": 2,
    "text": "<b>Charge</b>. <b>Battlecry:</b> Summon two 1/1 Whelps for your opponent.",
    "flavor": "At least he has Angry Chicken.",
    "artist": "Gabe from Penny Arcade",
    "collectible": true,
    "elite": true,
    "playerClass": "Neutral",
    "img": "http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_116.png",
    "imgGold": "http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_116_premium.gif",
    "locale": "enUS",
    "mechanics": [
    {
        "name": "Charge"
    },
    {
        "name": "Battlecry"
    }
    ]
}
]*/
