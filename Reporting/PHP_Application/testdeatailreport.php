<?php

	include "./constants.inc.php";
	include "./Mysql.obj.php";
	
	$RowNumberMaxLimit = 20;
	
	$DBConnection = new mysql;
	$DBConnection->opendbconnection(HOST, DB, USER, PASSWORD);
	


	if ( isset( $_GET['test_id'] ) )  {
     
	    $selectedTest = $_GET['test_id'];
	   echo "<h1> Selected Use Case is " . $_GET['test_id'] . "</h1>";
}



        if (isset($_GET['app'])) {

            $selectedApp = $_GET['app'];
            echo "<h2> Selected Application is " . $_GET['app']."</h2>";
        }
           echo "<br> ";
	


        $TotalRunsPassQuery = "select count(*) as totalpass from test_results where test_id = '".$selectedTest."'  AND application ='" . $selectedApp . "' and test_result = 'pass'";
        $LastPassBuildResult = mysql_query($TotalRunsPassQuery);
        $LastPassBuildArray = mysql_fetch_assoc($LastPassBuildResult);
        
        $TotalRunsFailQuery = "select count(*) as totalfail from test_results where test_id = '".$selectedTest."' AND application ='" . $selectedApp . "' and test_result = 'fail'";
        $TotalRunsFailResult = mysql_query($TotalRunsFailQuery);
        $TotalRunsFailArray = mysql_fetch_assoc($TotalRunsFailResult);


        $LastPassBuildQuery = "select * from test_results where test_id = '".$selectedTest."' AND application ='" . $selectedApp . "' and test_result = 'pass' order by id desc limit 1";
        $LastPassBuildResult = mysql_query($LastPassBuildQuery);
        $LastPassResultArray = mysql_fetch_assoc($LastPassBuildResult);

        $LastFailBuildQuery = "select * from test_results where test_id = '".$selectedTest."' AND application ='" . $selectedApp . "' and test_result = 'fail' order by id desc limit 1";
        $LastFailBuildResult = mysql_query($LastFailBuildQuery);
        $LastFailResultArray = mysql_fetch_assoc($LastFailBuildResult);


        echo "<Table border=1 >";
	echo "<TR><TD>Last Pass </TD><TD> Last Fail</TD><TD>Total Pass </TD><TD> Total Fail</TD><TD> Total Run</TD></TR>";
        echo "<TR>";
        echo " <TD>".$LastPassResultArray['version']."</TD><TD>".$LastFailResultArray['version']."</TD>";
        echo " <TD>".$LastPassBuildArray['totalpass']."</TD><TD>".$TotalRunsFailArray['totalfail']."</TD>";
        $totalRun = $LastPassBuildArray['totalpass'] + $TotalRunsFailArray['totalfail'];

        echo " <TD>".  $totalRun ."</TD>";
        echo "</TR>";
        echo "</Table >";
        
        echo"<BR><BR><BR>";



        $BuildsPassQuery = "select distinct(version) from test_results where test_id = '".$selectedTest."' ";
        $BuildsPassQuery .= "and test_result = 'pass' AND application ='" . $selectedApp . "' ORDER BY id DESC LIMIT ".$RowNumberMaxLimit;
        $ListPassedBuildsResult = mysql_query($BuildsPassQuery);

        echo "<h2> Builds test has Passed on</h2>";
        echo "<Table border=1 >";
	echo "<TR><TD>Build ID </TD></TR>";


	while ($row = mysql_fetch_assoc($ListPassedBuildsResult)){

		echo "<TR>";
		echo "<TD>" .$row['version']."</TD>";
		
        }
        echo "</TR>";
        echo "</Table >";




	
	$TestDetailQuery = "SELECT * FROM test_results WHERE test_id ='".$selectedTest."' AND application ='" . $selectedApp . "' ORDER BY id DESC LIMIT ".$RowNumberMaxLimit;
	$TestDetailResult = mysql_query($TestDetailQuery);



        echo "<h2> Last 20 test runs</h2>";
	echo "<Table border=1 >";
	echo "<TR><TD>ID </TD><TD> Test ID</TD><TD>Application</TD><TD>Build/Version</TD><TD>Browser</TD><TD>OS</TD><TD> Time Stamp</TD><TD> Client</TD><TD>Result</TD><TD>Bug ID</TD><TD>Tag</TD></TR>";
	
	
	while ($row = mysql_fetch_assoc($TestDetailResult)){
 
		echo "<TR>";
		echo "<TD>".$row['id']."</TD>";
		echo "<TD>".$row['test_id']."</TD>";
		echo "<TD>" .$row['application']."</TD>";
		echo "<TD>" .$row['version']."</TD>";
                echo "<TD>" .$row['browser']."</TD>";
                echo "<TD>" .$row['OS']."</TD>";
		echo "<TD>" .$row['time_stamp']."</TD>";
		echo "<TD>" .$row['ip']."</TD>";
		if ($row['test_result'] == 'fail' ) {
			$bgColor = "RED";			
		}else{
			$bgColor = "GREEN";
		}
		
		echo "<TD bgcolor=". $bgColor.">" .$row['test_result']."</TD>";
		echo "<TD>" .$row['bug_id']."</TD>";
                echo "<TD>" .$row['tag']."</TD>";
		echo "</TR>";	 
	}
	echo "</Table >";
	

?>