package net.sourceforge.fenixedu.presentationTier.Action.masterDegree.administrativeOffice.thesis;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.fenixedu.applicationTier.Filtro.exception.FenixFilterException;
import net.sourceforge.fenixedu.presentationTier.Action.exceptions.FenixActionException;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 
 * @author : - Shezad Anavarali (sana@mega.ist.utl.pt) - Nadir Tarmahomed
 *         (naat@mega.ist.utl.pt)
 * 
 */

public class CreateMasterDegreeThesisLookupDispatchAction extends CreateOrEditMasterDegreeThesisLookupDispatchAction {

    protected Map getKeyMethodMap() {
	Map map = super.getKeyMethodMap();
	map.put("button.submit.masterDegree.thesis.createThesis", "createMasterDegreeThesis");
	map.put("button.cancel", "cancelCreateMasterDegreeThesis");
	return map;
    }

    public ActionForward cancelCreateMasterDegreeThesis(ActionMapping mapping, ActionForm form, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
	return super.cancelMasterDegreeThesis(mapping, form, request, response);
    }

    public ActionForward createMasterDegreeThesis(ActionMapping mapping, ActionForm form, HttpServletRequest request,
	    HttpServletResponse response) throws FenixActionException, FenixFilterException {
	return super.createOrEditMasterDegreeThesis(mapping, form, request, response, "CreateMasterDegreeThesis");
    }

}