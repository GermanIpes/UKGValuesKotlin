package services.impl

import extensions.enumContains
import model.Person
import model.UKGValues
import services.PersonFilter

class PersonFilterImplementation: PersonFilter {

    //Welcome to our Code challenge level: Easy
    //In this exercise you have to implement the filterPersonByAttitudes to validate if a person is Kind, Respectful and
    //in total have at least 3 attitudes (Kind and respectful attitudes count too)

    //Tip #1: You can inspect the model of the object Person and the UKG values in the model folder
    //Tip #2: You could use the function enumContains which is on EnumExtensions in the extensions folder
    //Tip #3: In services/exceptions you should find the EmptyPersonAttitudesException
    //        and PersonWithoutFundamentalAttitudeException class

    override fun filterPersonByAttitudes(person: Person):Boolean {
        return when{
            person.personValues.isEmpty() -> false
            person.personValues.find { it == UKGValues.KIND } == null -> false
            person.personValues.find { it == UKGValues.RESPECTFUL } == null -> false
            else -> {
                var attitudesCount = 0
                person.personValues.forEach { attitude ->
                    if(enumContains<UKGValues>(attitude.toString())) attitudesCount++
                }
                attitudesCount >= 3
            }
        }
    }

    fun functionToImplement(person: Person):Boolean {
        TODO()
    }
}