package services

import mocks.PersonMocks.Companion.mockPersonWith2Attitudes
import mocks.PersonMocks.Companion.mockPersonWith3Attitudes
import mocks.PersonMocks.Companion.mockPersonWithMoreThan3Attitudes
import mocks.PersonMocks.Companion.mockPersonWithoutAttitudes
import mocks.PersonMocks.Companion.mockPersonWithoutKindAttitude
import mocks.PersonMocks.Companion.mockPersonWithoutRespectfulAttitude
import model.Person
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import services.impl.PersonFilterImplementation
import java.util.stream.Stream


class PersonFilterImplementationTest {
    private lateinit var service: PersonFilter

    @BeforeEach
    fun before() {
        service = PersonFilterImplementation()
    }

    @ParameterizedTest
    @MethodSource("personsWithDifferentAttitudes")
    fun `filterPersonByAttitudes validate different cases`(personWithValidation: Pair<Person, Boolean>) {
        val person = personWithValidation.first
        val expectedResult = personWithValidation.second

        val result = service.filterPersonByAttitudes(person)

        result shouldBeEqualTo (expectedResult)
    }

    companion object {
        @JvmStatic
        fun personsWithDifferentAttitudes(): Stream<Pair<Person, Boolean>> =
            Stream.of(
                Pair(
                    mockPersonWithoutAttitudes(),
                    false
                ),
                Pair(
                    mockPersonWith2Attitudes(),
                    false
                ),
                Pair(
                    mockPersonWith3Attitudes(),
                    true
                ),
                Pair(
                    mockPersonWithMoreThan3Attitudes(),
                    true
                ),
                Pair(
                    mockPersonWithoutKindAttitude(),
                    false
                ),
                Pair(
                    mockPersonWithoutRespectfulAttitude(),
                    false
                )
            )
    }
}