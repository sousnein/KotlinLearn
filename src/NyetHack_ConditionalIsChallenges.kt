fun main(args: Array<String>) {
    val name = "madrigal"
    var healthPoints = 75
    val isBlessed= true
    val isImmortal = false

    val auraVisible = isBlessed && healthPoints > 50 || isImmortal

    var auraColor = if (auraVisible) "GREEN" else "NONE"

    val healthStatus = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }

    val karma = (Math.pow(Math.random(),(110-healthPoints)/100.0)*20).toInt()
    if(isBlessed){
     auraColor=when(karma){
         in 0..5->"red"
         in 6..10->"orange"
         in 11..15->"purple"
         in 16..20->"green"

         else->"crap"
     }
    }
    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}