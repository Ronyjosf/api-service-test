package utils.listeners;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;

/**
 * Should be implemented for all reporters
 */
public interface IReporter extends TestExecutionListener {
    @Override void testPlanExecutionStarted(TestPlan testPlan);
    @Override void executionStarted(TestIdentifier testIdentifier);
    @Override void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult);
    @Override void reportingEntryPublished(TestIdentifier testIdentifier, ReportEntry entry);

    void publishCodeBlock(TestIdentifier testIdentifier, String code);

    void publishScreenshot(TestIdentifier testIdentifier, String path);
}