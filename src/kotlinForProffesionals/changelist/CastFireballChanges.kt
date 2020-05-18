package kotlinForProffesionals.changelist

fun main(args: Array<String>) {
    val name = "madrigal"
    var healthPoints = 75
    val isBlessed= true
    val isImmortal = false
    val numFireballs = 5
    val narcoLvl:Int


    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    val healthStatus = formatHeathStatus(healthPoints, isBlessed)
    pointPlayerStatus(auraColor, isBlessed, name, healthStatus)
    castFireBall(numFireballs,10)

}

private fun pointPlayerStatus(auraColor: String, isBlessed: Boolean, name: String, healthStatus: String) {
    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

private fun formatHeathStatus(healthPoints: Int, isBlessed: Boolean) = when (healthPoints) {
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

private fun castFireBall(numFireballs:Int=2, narcoLvl:Int=0)=when(narcoLvl) {
    in 1..50 -> print("A glass of Fireball springs into existence.(x$numFireballs)narcoLvl($narcoLvl)${when(narcoLvl) {
        in 1..10 -> print("you are tipsy ")
        in 11..20 -> print("you are Sloshed ")
        in 21..30 -> print("you are Soused ")
        in 31..40 -> print("you are Stewed ")
        in 41..50 -> print("you are trash ")
        else ->"error"}
    }")
    else -> println("You are ok")

}



private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}
