/*
 * Created on 17/Set/2003
 *
 */
package net.sourceforge.fenixedu.applicationTier.Servico.coordinator;

import net.sourceforge.fenixedu.applicationTier.IUserView;
import net.sourceforge.fenixedu.applicationTier.Service;
import net.sourceforge.fenixedu.applicationTier.Servico.exceptions.FenixServiceException;
import net.sourceforge.fenixedu.domain.Coordinator;
import net.sourceforge.fenixedu.domain.ExecutionDegree;
import net.sourceforge.fenixedu.domain.Teacher;
import net.sourceforge.fenixedu.persistenceTier.ExcepcaoPersistencia;

/**
 * @author Jo�o Mota 17/Set/2003
 * 
 */
public class ReadCoordinationResponsibility extends Service {

    public Boolean run(Integer executionDegreeId, IUserView userView) throws FenixServiceException,
            ExcepcaoPersistencia {
        Teacher teacher = Teacher.readTeacherByUsername(userView.getUtilizador());
        if (teacher == null) {
            throw new FenixServiceException("error.teacher.not.found");
        }
        ExecutionDegree executionDegree = rootDomainObject.readExecutionDegreeByOID(executionDegreeId);
        Coordinator coordinator = executionDegree.getCoordinatorByTeacher(teacher);
        
        if (coordinator == null || !coordinator.getResponsible().booleanValue()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}