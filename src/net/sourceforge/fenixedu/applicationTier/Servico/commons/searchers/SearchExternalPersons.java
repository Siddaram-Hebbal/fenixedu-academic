package net.sourceforge.fenixedu.applicationTier.Servico.commons.searchers;

import java.util.Collection;

import net.sourceforge.fenixedu.domain.person.PersonName;

public class SearchExternalPersons extends SearchParties {

    @Override
    protected Collection search(String value, int size) {
	return PersonName.findExternalPerson(value, size);
    }

}
