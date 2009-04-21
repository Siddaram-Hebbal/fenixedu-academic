package net.sourceforge.fenixedu.dataTransferObject.accounting.sibsPaymentFileProcessReport;

import net.sourceforge.fenixedu.domain.GratuitySituation;
import net.sourceforge.fenixedu.domain.accounting.Event;
import net.sourceforge.fenixedu.domain.accounting.PaymentCode;
import net.sourceforge.fenixedu.domain.accounting.ResidenceEvent;
import net.sourceforge.fenixedu.domain.accounting.events.AdministrativeOfficeFeeAndInsuranceEvent;
import net.sourceforge.fenixedu.domain.accounting.events.gratuity.DfaGratuityEvent;
import net.sourceforge.fenixedu.domain.accounting.events.gratuity.GratuityEventWithPaymentPlan;
import net.sourceforge.fenixedu.domain.accounting.events.insurance.InsuranceEvent;
import net.sourceforge.fenixedu.domain.accounting.paymentCodes.AccountingEventPaymentCode;
import net.sourceforge.fenixedu.domain.accounting.paymentCodes.GratuitySituationPaymentCode;
import net.sourceforge.fenixedu.domain.accounting.paymentCodes.MasterDegreeInsurancePaymentCode;
import net.sourceforge.fenixedu.util.Money;
import net.sourceforge.fenixedu.util.sibs.incomming.SibsIncommingPaymentFile;
import net.sourceforge.fenixedu.util.sibs.incomming.SibsIncommingPaymentFileDetailLine;

import org.joda.time.YearMonthDay;

public class SibsPaymentFileProcessReportDTO {

    private String filename;

    private YearMonthDay whenProcessedBySibs;

    private Integer fileVersion;

    private Money degreeGratuityTotalAmount;

    private Money bolonhaDegreeGratuityTotalAmount;

    private Money integratedMasterDegreeGratuityTotalAmount;

    private Money integratedBolonhaMasterDegreeGratuityTotalAmount;

    private Money administrativeOfficeTaxTotalAmount;

    private Money graduationInsuranceTotalAmount;

    private Money specializationGratuityTotalAmount;

    private Money masterDegreeGratuityTotalAmount;

    private Money bolonhaMasterDegreeGratuityTotalAmount;

    private Money dfaGratuityTotalAmount;

    private Money afterGraduationInsuranceTotalAmount;

    private Money phdGratuityTotalAmout;

    private Money transactionsTotalAmount;

    private Money residenceAmount;

    private Money totalCost;

    public SibsPaymentFileProcessReportDTO() {
	super();
	this.degreeGratuityTotalAmount = Money.ZERO;
	this.bolonhaDegreeGratuityTotalAmount = Money.ZERO;
	this.integratedMasterDegreeGratuityTotalAmount = Money.ZERO;
	this.integratedBolonhaMasterDegreeGratuityTotalAmount = Money.ZERO;
	this.administrativeOfficeTaxTotalAmount = Money.ZERO;
	this.graduationInsuranceTotalAmount = Money.ZERO;
	this.specializationGratuityTotalAmount = Money.ZERO;
	this.masterDegreeGratuityTotalAmount = Money.ZERO;
	this.bolonhaMasterDegreeGratuityTotalAmount = Money.ZERO;
	this.dfaGratuityTotalAmount = Money.ZERO;
	this.afterGraduationInsuranceTotalAmount = Money.ZERO;
	this.phdGratuityTotalAmout = Money.ZERO;
	this.transactionsTotalAmount = Money.ZERO;
	this.totalCost = Money.ZERO;
	this.residenceAmount = Money.ZERO;
    }

    public SibsPaymentFileProcessReportDTO(final SibsIncommingPaymentFile sibsIncomingPaymentFile) {
	this();
	setWhenProcessedBySibs(sibsIncomingPaymentFile.getHeader().getWhenProcessedBySibs());
	setFilename(sibsIncomingPaymentFile.getFilename());
	setTransactionsTotalAmount(sibsIncomingPaymentFile.getFooter().getTransactionsTotalAmount());
	setTotalCost(sibsIncomingPaymentFile.getFooter().getTotalCost());
	setFileVersion(sibsIncomingPaymentFile.getHeader().getVersion());
    }

    private void addAdministrativeOfficeTaxAmount(final Money amount) {
	this.administrativeOfficeTaxTotalAmount = this.administrativeOfficeTaxTotalAmount.add(amount);
    }

    public Money getAdministrativeOfficeTaxTotalAmount() {
	return administrativeOfficeTaxTotalAmount;
    }

    private void addBolonhaDegreeGratuityAmount(final Money amount) {
	this.bolonhaDegreeGratuityTotalAmount = this.bolonhaDegreeGratuityTotalAmount.add(amount);
    }

    public Money getBolonhaDegreeGratuityTotalAmount() {
	return bolonhaDegreeGratuityTotalAmount;
    }

    private void addDegreeGratuityAmount(final Money amount) {
	this.degreeGratuityTotalAmount = this.degreeGratuityTotalAmount.add(amount);
    }

    public Money getDegreeGratuityTotalAmount() {
	return degreeGratuityTotalAmount;
    }

    public Money getGraduationInsuranceTotalAmount() {
	return graduationInsuranceTotalAmount;
    }

    private void addGraduationInsuranceAmount(Money amount) {
	this.graduationInsuranceTotalAmount = this.graduationInsuranceTotalAmount.add(amount);
    }

    private void addDfaGratuityAmount(final Money amount) {
	this.dfaGratuityTotalAmount = this.dfaGratuityTotalAmount.add(amount);
    }

    public Money getDfaGratuityTotalAmount() {
	return dfaGratuityTotalAmount;
    }

    public String getFilename() {
	return filename;
    }

    public void setFilename(String filename) {
	this.filename = filename;
    }

    public Integer getFileVersion() {
	return fileVersion;
    }

    public void setFileVersion(Integer fileVersion) {
	this.fileVersion = fileVersion;
    }

    private void addAfterGraduationInsuranceAmount(final Money amount) {
	this.afterGraduationInsuranceTotalAmount = this.afterGraduationInsuranceTotalAmount.add(amount);
    }

    public Money getAfterGraduationInsuranceTotalAmount() {
	return afterGraduationInsuranceTotalAmount;
    }

    private void addIntegratedBolonhaMasterDegreeGratuityAmount(final Money amount) {
	this.integratedBolonhaMasterDegreeGratuityTotalAmount = this.integratedBolonhaMasterDegreeGratuityTotalAmount.add(amount);
    }

    public Money getIntegratedBolonhaMasterDegreeGratuityTotalAmount() {
	return integratedBolonhaMasterDegreeGratuityTotalAmount;
    }

    private void addIntegratedMasterDegreeGratuityAmount(final Money amount) {
	this.integratedMasterDegreeGratuityTotalAmount = this.integratedMasterDegreeGratuityTotalAmount.add(amount);
    }

    public Money getIntegratedMasterDegreeGratuityTotalAmount() {
	return integratedMasterDegreeGratuityTotalAmount;
    }

    private void addMasterDegreeGratuityAmount(final Money amount) {
	this.masterDegreeGratuityTotalAmount = this.masterDegreeGratuityTotalAmount.add(amount);
    }

    public Money getMasterDegreeGratuityTotalAmount() {
	return masterDegreeGratuityTotalAmount;
    }

    private void addBolonhaMasterDegreGratuityTotalAmount(final Money amount) {
	this.bolonhaMasterDegreeGratuityTotalAmount = this.bolonhaMasterDegreeGratuityTotalAmount.add(amount);
    }

    public Money getBolonhaMasterDegreeGratuityTotalAmount() {
	return bolonhaMasterDegreeGratuityTotalAmount;
    }

    private void addSpecializationGratuityAmount(final Money amount) {
	this.specializationGratuityTotalAmount = this.specializationGratuityTotalAmount.add(amount);
    }

    public Money getSpecializationGratuityTotalAmount() {
	return specializationGratuityTotalAmount;
    }

    private void addPhdGratuityAmount(final Money amount) {
	this.phdGratuityTotalAmout = this.phdGratuityTotalAmout.add(amount);
    }

    public Money getPhdGratuityTotalAmout() {
	return phdGratuityTotalAmout;
    }

    public Money getTotalCost() {
	return totalCost;
    }

    public void setTotalCost(Money totalCost) {
	this.totalCost = totalCost;
    }

    public Money getTransactionsTotalAmount() {
	return transactionsTotalAmount;
    }

    public void setTransactionsTotalAmount(Money transactionsTotalAmount) {
	this.transactionsTotalAmount = transactionsTotalAmount;
    }

    public YearMonthDay getWhenProcessedBySibs() {
	return whenProcessedBySibs;
    }

    public void setWhenProcessedBySibs(YearMonthDay whenProcessedBySibs) {
	this.whenProcessedBySibs = whenProcessedBySibs;
    }

    public Money getResidenceAmount() {
	return residenceAmount;
    }

    public void addResidenceAmount(Money money) {
	this.residenceAmount = this.residenceAmount.add(money);
    }

    public void addAmount(final SibsIncommingPaymentFileDetailLine detailLine, final PaymentCode paymentCode) {
	if (paymentCode instanceof AccountingEventPaymentCode) {
	    addAmountForEvent(detailLine, paymentCode);
	} else if (paymentCode instanceof GratuitySituationPaymentCode) {
	    addAmountForGratuitySituation(detailLine, (GratuitySituationPaymentCode) paymentCode);
	} else if (paymentCode instanceof MasterDegreeInsurancePaymentCode) {
	    addAfterGraduationInsuranceAmount(detailLine.getAmount());
	} else {
	    throw new UnsupportedOperationException("Unknown payment code type");
	}
    }

    private void addAmountForEvent(final SibsIncommingPaymentFileDetailLine detailLine, final PaymentCode paymentCode) {
	final Event event = ((AccountingEventPaymentCode) paymentCode).getAccountingEvent();
	if (event instanceof GratuityEventWithPaymentPlan) {
	    addAmountForGratuityEvent(detailLine, (GratuityEventWithPaymentPlan) event);
	} else if (event instanceof AdministrativeOfficeFeeAndInsuranceEvent) {
	    addAmountForAdministrativeOfficeAndInsuranceEvent(detailLine, (AdministrativeOfficeFeeAndInsuranceEvent) event);
	} else if (event instanceof DfaGratuityEvent) {
	    addDfaGratuityAmount(detailLine.getAmount());
	} else if (event instanceof InsuranceEvent) {
	    addAfterGraduationInsuranceAmount(detailLine.getAmount());
	} else if (event instanceof ResidenceEvent) {
	    addResidenceAmount(detailLine.getAmount());
	} else {
	    throw new IllegalArgumentException("Unknown accounting event " + event.getClass().getName());
	}
    }

    private void addAmountForGratuityEvent(final SibsIncommingPaymentFileDetailLine detailLine,
	    final GratuityEventWithPaymentPlan gratuityEventWithPaymentPlan) {
	switch (gratuityEventWithPaymentPlan.getDegree().getDegreeType()) {
	case DEGREE:
	    addDegreeGratuityAmount(detailLine.getAmount());
	    break;
	case BOLONHA_DEGREE:
	    addBolonhaDegreeGratuityAmount(detailLine.getAmount());
	    break;
	case BOLONHA_INTEGRATED_MASTER_DEGREE:
	    addIntegratedBolonhaMasterDegreeGratuityAmount(detailLine.getAmount());
	    break;
	case BOLONHA_MASTER_DEGREE:
	    addBolonhaMasterDegreGratuityTotalAmount(detailLine.getAmount());
	    break;
	default:
	    throw new IllegalArgumentException("unknown degree type for gratuity event");
	}
    }

    private void addAmountForAdministrativeOfficeAndInsuranceEvent(final SibsIncommingPaymentFileDetailLine detailLine,
	    final AdministrativeOfficeFeeAndInsuranceEvent administrativeOfficeFeeAndInsuranceEvent) {
	if (detailLine.getAmount().greaterOrEqualThan(administrativeOfficeFeeAndInsuranceEvent.getAmountToPay())) {
	    addGraduationInsuranceAmount(administrativeOfficeFeeAndInsuranceEvent.getInsuranceAmount());
	    addAdministrativeOfficeTaxAmount(detailLine.getAmount().subtract(
		    administrativeOfficeFeeAndInsuranceEvent.getInsuranceAmount()));
	} else {
	    addAdministrativeOfficeTaxAmount(detailLine.getAmount());
	}
    }

    private void addAmountForGratuitySituation(final SibsIncommingPaymentFileDetailLine detailLine,
	    GratuitySituationPaymentCode paymentCode) {
	final GratuitySituation gratuitySituation = paymentCode.getGratuitySituation();
	switch (gratuitySituation.getStudentCurricularPlan().getSpecialization()) {
	case STUDENT_CURRICULAR_PLAN_MASTER_DEGREE:
	    addMasterDegreeGratuityAmount(detailLine.getAmount());
	    break;
	case STUDENT_CURRICULAR_PLAN_INTEGRATED_MASTER_DEGREE:
	    addIntegratedMasterDegreeGratuityAmount(detailLine.getAmount());
	    break;
	case STUDENT_CURRICULAR_PLAN_SPECIALIZATION:
	    addSpecializationGratuityAmount(detailLine.getAmount());
	    break;
	default:
	    throw new RuntimeException("Unknown specialization "
		    + gratuitySituation.getStudentCurricularPlan().getSpecialization().name());
	}
    }
}
