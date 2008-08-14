package net.sourceforge.fenixedu.domain.tests.predicates;

import java.util.HashMap;

import net.sourceforge.fenixedu.domain.Person;
import net.sourceforge.fenixedu.domain.tests.NewNumericQuestion;
import net.sourceforge.fenixedu.domain.tests.NewQuestion;
import net.sourceforge.fenixedu.presentationTier.Action.teacher.tests.PredicateBean;

public class NumericLessThanOrEqualPredicate extends AtomicPredicate implements Predicate {
    private double value;

    public NumericLessThanOrEqualPredicate(double value) {
	super();

	this.value = value;
    }

    public NumericLessThanOrEqualPredicate(PredicateBean predicateBean) {
	this(predicateBean.getValue());
    }

    public boolean evaluate(NewQuestion question, Person person) {
	NewNumericQuestion numericQuestion = (NewNumericQuestion) question;

	if (!numericQuestion.isAnswered(person)) {
	    return false;
	}

	return numericQuestion.getNumericAnswer(person) <= value;
    }

    public double getValue() {
	return value;
    }

    public boolean uses(Object object) {
	return false;
    }

    public Predicate transform(HashMap<Object, Object> transformMap) {
	return new NumericLessThanOrEqualPredicate(getValue());
    }

}
