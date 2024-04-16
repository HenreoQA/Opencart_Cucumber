package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//Features= folder, Login.feature = specific feature file, .// = project directory or location
//we can specify multiple feature files using comma to separate them
//glue = keyword we use to specify step definitions which will select the corresponding feature file
//features = keyword we use to specify feature files
//target contains failed scenarios (rerun.txt)
//test-output contains screenshots of failed scenarios and cucumber extent report
//Reports(myreport.html) contains Cucumber Junit report
//tags = for grouping the scenarios

@RunWith(Cucumber.class)
@CucumberOptions(
					//features= {".//Features/"}, // This will execute all feature files in one shot
		            //features= {".//Features/Registration.feature"}, //Execute Registration feature
					features= {".//Features/Login.feature"}, //Execute Login feature
					//features= {".//Features/LoginDDTExcel.feature"}, // Execute DDT feature
					//features= {".//Features/Registration.feature", ".//Features/Login.feature"}, // Execute registration and login feature
					//features= {"@target/rerun.txt"}, // To rerun failed scenarios. Enable this feature when you want to run failed scenarios
					glue="stepDefinitions", // To specify step definitions
					plugin= {"pretty", "html:Reports/myreport.html", // This plugin will generate Cucumber Junit report
							  "rerun:target/rerun.txt", // This plugin will capture failed scenarios
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // This plugin will generate extent report
							},
						
				  //dryRun=true,    // checks mapping between scenarios and step definition methods
					dryRun=false,    // checks mapping between scenarios and step definition methods and then execute the application
					monochrome=true,    // to avoid junk characters(like ?, *) in output
				    publish=true   // to publish report in cucumber server(you can share the cucumber url as stated below to your team members to view)
					//publish=false   // not to publish report in cucumber server
					
				    //tags="@sanity" // this will execute scenarios tagged with @sanity
					//tags="@regression" // this will execute scenarios tagged with @regression
					//tags="@sanity and @regression" //Scenarios tagged with both @sanity and @regression (remember to enable the feature file that belongs to the tags)
					//tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
					//tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression
		)

public class TestRun 
{

}
