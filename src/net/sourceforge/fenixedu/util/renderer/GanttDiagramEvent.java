package net.sourceforge.fenixedu.util.renderer;

import java.util.List;

import pt.utl.ist.fenix.tools.util.i18n.MultiLanguageString;

import org.joda.time.Interval;

public interface GanttDiagramEvent {

    public List<Interval> getGanttDiagramEventSortedIntervals();

    public MultiLanguageString getGanttDiagramEventName();

    public int getGanttDiagramEventOffset();

    public String getGanttDiagramEventPeriod();

    public String getGanttDiagramEventObservations();

    public String getGanttDiagramEventIdentifier();

}
