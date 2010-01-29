package be.jorambarrez.jbpm4.helloworld;

import org.jbpm.api.Configuration;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;

public class Main {

	public static void main(String[] args) {
		
		// Build jBPM services
		ProcessEngine processEngine = new Configuration().setResource("my.jbpm.cfg.xml").buildProcessEngine();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		ExecutionService executionService = processEngine.getExecutionService();
		
		// Deploy helloWorld process definition and start a process instance
		repositoryService.createDeployment().addResourceFromClasspath("hello_world.jpdl.xml").deploy();
		executionService.startProcessInstanceByKey("helloWorld");
		
	}
	
}
