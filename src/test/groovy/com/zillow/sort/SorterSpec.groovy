package com.zillow.sort

import spock.lang.Specification
import spock.lang.Unroll

class SorterSpec extends Specification {

    private static final Person ARYA = Person.builder()
                                             .ssn("1234")
                                             .dateOfBirth(new Date(2004, 4, 2))
                                             .firstName("arya")
                                             .lastName("stark")
                                             .heightIn(60)
                                             .weightLb(100)
                                             .build();

    private static final Person DANY = Person.builder()
                                             .ssn("1235")
                                             .dateOfBirth(new Date(2000, 12, 12))
                                             .firstName("daenerys")
                                             .lastName("targaryen")
                                             .heightIn(64)
                                             .weightLb(110)
                                             .build();

    private static final Person CERCIE = Person.builder()
                                               .ssn("666")
                                               .dateOfBirth(new Date(1975, 11, 2))
                                               .firstName("cercie")
                                               .lastName("lannister")
                                               .heightIn(72)
                                               .weightLb(130)
                                               .build();

    private static final Person JON = Person.builder()
                                            .ssn("2356")
                                            .dateOfBirth(new Date(2001, 11, 2))
                                            .firstName("jon")
                                            .lastName("snow")
                                            .heightIn(80)
                                            .weightLb(150)
                                            .build();

    private static final Person IMP = Person.builder()
                                            .ssn("420")
                                            .dateOfBirth(new Date(1981, 5, 1))
                                            .firstName("tyrion")
                                            .lastName("lannister")
                                            .heightIn(42)
                                            .weightLb(70)
                                            .build();


    @Unroll
    def 'sort person list of size #people.size() on #sortField in #order order'() {
        expect:
            Sorter.sort(people, sortField, order == "ascending" ? "true" : "false") == expected

        where:
            people                         | sortField     | order        | expected
            []                             | "dateOfBirth" | "ascending"  | []
            [ARYA, DANY, CERCIE, JON, IMP] | "dateOfBirth" | "ascending"  | [CERCIE, IMP, DANY, JON, ARYA]
            [ARYA, DANY, CERCIE, JON, IMP] | "dateOfBirth" | "descending" | [ARYA, JON, DANY, IMP, CERCIE]
            [ARYA, DANY, CERCIE, JON, IMP] | "firstName"   | "ascending"  | [ARYA, CERCIE, DANY, JON, IMP]
            [ARYA, DANY, CERCIE, JON, IMP] | "firstName"   | "descending" | [IMP, JON, DANY, CERCIE, ARYA]
            [ARYA, DANY, CERCIE, JON, IMP] | "heightIn"    | "ascending"  | [IMP, ARYA, DANY, CERCIE, JON]
            [ARYA, DANY, CERCIE, JON, IMP] | "heightIn"    | "descendign" | [JON, CERCIE, DANY, ARYA, IMP]
    }

    def 'throw exception when sort on an illegal field'() {

        when:
            Sorter.sort([ARYA, JON], 'DFKJSJKF', 'ascending')

        then:
            thrown(IllegalArgumentException)

    }
}
