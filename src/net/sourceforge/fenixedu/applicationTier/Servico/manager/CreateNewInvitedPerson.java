package net.sourceforge.fenixedu.applicationTier.Servico.manager;

import net.sourceforge.fenixedu.applicationTier.Service;
import net.sourceforge.fenixedu.dataTransferObject.person.InvitedPersonBean;
import net.sourceforge.fenixedu.domain.Person;
import net.sourceforge.fenixedu.domain.organizationalStructure.Invitation;

public class CreateNewInvitedPerson extends Service {

    public Invitation run(InvitedPersonBean bean) {
	Person person = new Person(bean);
	Invitation invitation = new Invitation(person, bean.getUnit(), bean.getResponsible(), bean.getBegin(), bean.getEnd());
	person.setIstUsername();
	return invitation;
    }
}
