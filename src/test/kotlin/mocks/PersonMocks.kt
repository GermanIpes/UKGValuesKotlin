package mocks

import model.Person
import model.UKGValues.*

class PersonMocks {
    companion object {
        fun mockPersonWithoutAttitudes(): Person = Person(
            firstName = "Leona",
            lastName = "Maguire",
            emptyList()
        )

        fun mockPersonWith2Attitudes(): Person = Person(
            firstName = "Notah",
            lastName = "Begay",
            personValues = listOf(RESPECTFUL, KIND)
        )

        fun mockPersonWith3Attitudes(): Person = Person(
            firstName = "Sydney",
            lastName = "Leroux",
            personValues = listOf(RESPECTFUL, KIND, INSPIRING)
        )

        fun mockPersonWithMoreThan3Attitudes(): Person = Person(
            firstName = "Dan",
            lastName = "Cnossen",
            personValues = listOf(SKILLED, PASSIONATE, RESPECTFUL, KIND, INSPIRING)
        )

        fun mockPersonWithoutRespectfulAttitude(): Person = Person(
            firstName = "Fred",
            lastName = "Couples",
            personValues = listOf(KIND,SKILLED,INSPIRING)
        )

        fun mockPersonWithoutKindAttitude(): Person = Person(
            firstName = "Gaby",
            lastName = "Lopez",
            personValues = listOf(RESPECTFUL, INSPIRING, SKILLED)
        )
    }
}