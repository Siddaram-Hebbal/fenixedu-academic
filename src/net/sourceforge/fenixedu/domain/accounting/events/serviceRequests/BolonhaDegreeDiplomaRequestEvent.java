package net.sourceforge.fenixedu.domain.accounting.events.serviceRequests;

import net.sourceforge.fenixedu.domain.Person;
import net.sourceforge.fenixedu.domain.accounting.EventType;
import net.sourceforge.fenixedu.domain.administrativeOffice.AdministrativeOffice;
import net.sourceforge.fenixedu.domain.serviceRequests.documentRequests.DiplomaRequest;

public class BolonhaDegreeDiplomaRequestEvent extends BolonhaDegreeDiplomaRequestEvent_Base {

    protected BolonhaDegreeDiplomaRequestEvent() {
	super();
    }

    public BolonhaDegreeDiplomaRequestEvent(final AdministrativeOffice administrativeOffice, final EventType eventType,
	    final Person person, final DiplomaRequest diplomaRequest) {
	this();
	super.init(administrativeOffice, eventType, person, diplomaRequest);
    }

}
