package services

import model.Person

interface PersonFilter {
    fun filterPersonByAttitudes(person: Person): Boolean
}