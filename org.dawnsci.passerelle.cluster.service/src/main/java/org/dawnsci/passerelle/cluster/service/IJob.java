package org.dawnsci.passerelle.cluster.service;

/**
 * Minimal interface to identify a job and to obtain its exit code.
 * 
 * @author erwindl
 *
 */
public interface IJob {

  /**
   * 
   * @return the Job ID as assigned by the IWorkflowClusterService
   */
  Long getJobID();
  
  /**
   * 
   * @return the job's correlation ID as set by the application during its job submission
   */
  String getCorrelationID();

  /**
   * 
   * @return the Job ID as assigned internally by the cluster implementation itself
   */
  String getInternalJobID();
  
  /**
   * 
   * @return true if the job is done or still pending/ongoing.
   */
  boolean isFinished();
  
  /**
   * 
   * @return a code to know whether the execution went fine (0) or ended in error (some other code)
   */
  int getExitCode();
  
  /**
   * 
   * @return some extra message that may explain what went OK/wrong during the job's execution
   */
  String getExitMessage();
}