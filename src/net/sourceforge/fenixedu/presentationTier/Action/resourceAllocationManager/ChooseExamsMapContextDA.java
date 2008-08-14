/**
 * Project sop 
 * 
 * Package presentationTier.Action.sop
 * 
 * Created on 2/Apr/2003
 *
 */
package net.sourceforge.fenixedu.presentationTier.Action.resourceAllocationManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.fenixedu.applicationTier.IUserView;
import net.sourceforge.fenixedu.dataTransferObject.InfoDegree;
import net.sourceforge.fenixedu.dataTransferObject.InfoExecutionDegree;
import net.sourceforge.fenixedu.dataTransferObject.InfoExecutionPeriod;
import net.sourceforge.fenixedu.dataTransferObject.comparators.ComparatorByNameForInfoExecutionDegree;
import net.sourceforge.fenixedu.presentationTier.Action.base.FenixContextDispatchAction;
import net.sourceforge.fenixedu.presentationTier.Action.resourceAllocationManager.utils.ServiceUtils;
import net.sourceforge.fenixedu.presentationTier.Action.resourceAllocationManager.utils.SessionConstants;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.util.LabelValueBean;

import pt.ist.fenixWebFramework.security.UserView;

/**
 * @author Luis Cruz & Sara Ribeiro
 */
public class ChooseExamsMapContextDA extends FenixContextDispatchAction {

    public ActionForward prepare(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	InfoExecutionPeriod infoExecutionPeriod = setExecutionContext(request);

	/* Criar o bean de semestres */
	List semestres = new ArrayList();
	semestres.add(new LabelValueBean("escolher", ""));
	semestres.add(new LabelValueBean("1 �", "1"));
	semestres.add(new LabelValueBean("2 �", "2"));
	request.setAttribute("semestres", semestres);

	List curricularYearsList = new ArrayList();
	curricularYearsList.add("1");
	curricularYearsList.add("2");
	curricularYearsList.add("3");
	curricularYearsList.add("4");
	curricularYearsList.add("5");
	request.setAttribute(SessionConstants.CURRICULAR_YEAR_LIST_KEY, curricularYearsList);

	/* Cria o form bean com as licenciaturas em execucao. */
	Object argsLerLicenciaturas[] = { infoExecutionPeriod.getInfoExecutionYear() };

	List executionDegreeList = (List) ServiceUtils
		.executeService("ReadExecutionDegreesByExecutionYear", argsLerLicenciaturas);

	Collections.sort(executionDegreeList, new ComparatorByNameForInfoExecutionDegree());

	List licenciaturas = new ArrayList();

	licenciaturas.add(new LabelValueBean("escolher", ""));

	Iterator iterator = executionDegreeList.iterator();

	int index = 0;
	while (iterator.hasNext()) {
	    InfoExecutionDegree infoExecutionDegree = (InfoExecutionDegree) iterator.next();
	    String name = infoExecutionDegree.getInfoDegreeCurricularPlan().getInfoDegree().getNome();

	    name = infoExecutionDegree.getInfoDegreeCurricularPlan().getInfoDegree().getTipoCurso().toString() + " de " + name;

	    name += duplicateInfoDegree(executionDegreeList, infoExecutionDegree) ? "-"
		    + infoExecutionDegree.getInfoDegreeCurricularPlan().getName() : "";

	    licenciaturas.add(new LabelValueBean(name, String.valueOf(index++)));
	}

	request.setAttribute(SessionConstants.INFO_EXECUTION_DEGREE_LIST_KEY, executionDegreeList);

	request.setAttribute(SessionConstants.DEGREES, licenciaturas);

	return mapping.findForward("chooseExamsMapContext");
    }

    public ActionForward choose(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	DynaActionForm chooseExamContextoForm = (DynaActionForm) form;

	String[] selectedCurricularYears = (String[]) chooseExamContextoForm.get("selectedCurricularYears");

	Boolean selectAllCurricularYears = (Boolean) chooseExamContextoForm.get("selectAllCurricularYears");

	if ((selectAllCurricularYears != null) && selectAllCurricularYears.booleanValue()) {
	    String[] allCurricularYears = { "1", "2", "3", "4", "5" };
	    selectedCurricularYears = allCurricularYears;
	}

	List curricularYears = new ArrayList(selectedCurricularYears.length);
	for (int i = 0; i < selectedCurricularYears.length; i++) {
	    curricularYears.add(new Integer(selectedCurricularYears[i]));
	    if (selectedCurricularYears[i].equals("1")) {
		request.setAttribute(SessionConstants.CURRICULAR_YEARS_1, "1");
	    }
	    if (selectedCurricularYears[i].equals("2")) {
		request.setAttribute(SessionConstants.CURRICULAR_YEARS_2, "2");
	    }
	    if (selectedCurricularYears[i].equals("3")) {
		request.setAttribute(SessionConstants.CURRICULAR_YEARS_3, "3");
	    }
	    if (selectedCurricularYears[i].equals("4")) {
		request.setAttribute(SessionConstants.CURRICULAR_YEARS_4, "4");
	    }
	    if (selectedCurricularYears[i].equals("5")) {
		request.setAttribute(SessionConstants.CURRICULAR_YEARS_5, "5");
	    }
	}

	request.setAttribute(SessionConstants.CURRICULAR_YEARS_LIST, curricularYears);

	int index = Integer.parseInt((String) chooseExamContextoForm.get("index"));

	// List infoExecutionDegreeList =
	// (List) request.getAttribute(
	// SessionConstants.INFO_EXECUTION_DEGREE_LIST_KEY);
	InfoExecutionPeriod infoExecutionPeriod = (InfoExecutionPeriod) request.getAttribute(SessionConstants.EXECUTION_PERIOD);
	Object argsLerLicenciaturas[] = { infoExecutionPeriod.getInfoExecutionYear() };
	List executionDegreeList = (List) ServiceUtils
		.executeService("ReadExecutionDegreesByExecutionYear", argsLerLicenciaturas);
	Collections.sort(executionDegreeList, new ComparatorByNameForInfoExecutionDegree());
	// ////////

	InfoExecutionDegree infoExecutionDegree = (InfoExecutionDegree) executionDegreeList.get(index);

	if (infoExecutionDegree != null) {
	    request.setAttribute(SessionConstants.EXECUTION_DEGREE, infoExecutionDegree);
	    request.setAttribute(SessionConstants.EXECUTION_DEGREE_OID, infoExecutionDegree.getIdInternal().toString());
	} else {
	    return mapping.findForward("Licenciatura execucao inexistente");
	}

	return mapping.findForward("showExamsMap");

    }

    /**
     * Method existencesOfInfoDegree.
     * 
     * @param executionDegreeList
     * @param infoExecutionDegree
     * @return int
     */
    private boolean duplicateInfoDegree(List executionDegreeList, InfoExecutionDegree infoExecutionDegree) {
	InfoDegree infoDegree = infoExecutionDegree.getInfoDegreeCurricularPlan().getInfoDegree();
	Iterator iterator = executionDegreeList.iterator();

	while (iterator.hasNext()) {
	    InfoExecutionDegree infoExecutionDegree2 = (InfoExecutionDegree) iterator.next();
	    if (infoDegree.equals(infoExecutionDegree2.getInfoDegreeCurricularPlan().getInfoDegree())
		    && !(infoExecutionDegree.equals(infoExecutionDegree2)))
		return true;

	}
	return false;
    }

    /**
     * Method setExecutionContext.
     * 
     * @param request
     */
    private InfoExecutionPeriod setExecutionContext(HttpServletRequest request) throws Exception {

	InfoExecutionPeriod infoExecutionPeriod = (InfoExecutionPeriod) request
		.getAttribute(SessionConstants.INFO_EXECUTION_PERIOD_KEY);
	if (infoExecutionPeriod == null) {
	    IUserView userView = UserView.getUser();
	    infoExecutionPeriod = (InfoExecutionPeriod) ServiceUtils.executeService("ReadCurrentExecutionPeriod", new Object[0]);

	    request.setAttribute(SessionConstants.INFO_EXECUTION_PERIOD_KEY, infoExecutionPeriod);
	}
	return infoExecutionPeriod;
    }

}