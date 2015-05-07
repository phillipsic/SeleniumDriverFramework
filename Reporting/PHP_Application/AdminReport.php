<?php	
	
echo "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">
<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"fr\" >";
	
	include "./header.html";
?>

<head>
       <title>Admin Section</title>
		<link type="text/css" rel="stylesheet" href="../yui/build/datatable/assets/skins/sam/datatable.css"/>
		<script type="text/javascript" src="../yui/build/yahoo-dom-event/yahoo-dom-event.js"></script>
		<script type="text/javascript" src="../yui/build/element/element-beta-min.js"></script>
		<script type="text/javascript" src="../yui/build/datasource/datasource-beta-min.js"></script>
		<script type="text/javascript" src="../yui/build/json/json-min.js"></script>
		<script type="text/javascript" src="../yui/build/connection/connection-min.js"></script>
		<script type="text/javascript" src="../yui/build/dragdrop/dragdrop-min.js"></script>
		<script type="text/javascript" src="../yui/build/calendar/calendar-min.js"></script>
		<script type="text/javascript" src="../yui/build/datatable/datatable-beta-min.js"></script>
	</head>
<body class=" yui-skin-sam"> 

<?php
	
	include "./constants.inc.php";
	include "./Mysql.obj.php";
	echo "<h2>Admin Section</h2>";
	
	$DBConnection = new mysql;
	$DBConnection->opendbconnection(HOST, DB, USER, PASSWORD);
	
	
		$selectedApplication = $_POST[selectedApplication];
	$appQuery = "SELECT distinct application from test_results;";
	$appResult = mysql_query($appQuery);
	

	
	

	
	echo "<BR>selected application is - ".$selectedApplication."<br>";

	
	
	
		echo "<form name=frmTest action='AdminReport.php' method=POST>";
        echo "<SELECT NAME='selectedApplication' onChange='frmTest.submit();'>";
        echo " <OPTION VALUE=\"\">Select App</OPTION>";
         
	   while ($row = mysql_fetch_assoc($appResult)){

		  echo "<OPTION VALUE='".$row['application']."'>".$row['application']."</OPTION>";

	   }

        
	    echo "</SELECT>";

        echo "</form>";
	
	
	if ( $selectedApplication != ""){
	
	
		$AgeColours = array('#FFFFFF','#FBF5EF', '#F8ECE0', '#F5D0A9', '#F7BE81', '#FAAC58', '#FE9A2E', '#FF8000' );
		
		$TestCaseListArray = array();
		$FailResultArray = array();
		$PassResultArray = array();
		
		
		$DistinctQuery = "select distinct version from test_results where application = '".$selectedApplication."'";
		$DistinctResult = mysql_query($DistinctQuery);
		
		
		//Create $TestCaseListArray
		 while ($row = mysql_fetch_assoc($DistinctResult)){
		 
			$TestBuildListArray[] = $row; 
		 }

		 echo "<form name='input' action='confirmBuildDelete.php' method='POST'>";
		echo "<div id=\"myMarkedUpContainer\">";
		echo "<Table id='myTable'><thead>";
		echo "<TR><TR><TH>Delete</TH><TH>Build Number</TH><TH>Total Passed</TH><TH>Total Executed</TH><TH>Pass Rate</TH></TR></thead><tbody>";
			
				foreach($TestBuildListArray as $row){
					
			
					
					$BuildQuery = "select distinct test_id  from test_results where application = '".$selectedApplication."' and test_result = 'pass' AND  version like  '%".$row['version'] ."%'";
					$BuildResult = mysql_query($BuildQuery);					
					
					$numberOfPassed = $num_rows = mysql_num_rows($BuildResult);
					
					$TotalTestsRunQuery = "select distinct test_id  from test_results where application = '".$selectedApplication."' AND  version like  '%".$row['version'] ."%'";
					$TotalTestsRunResult = mysql_query($TotalTestsRunQuery);
					$TotalRun = $num_rows = mysql_num_rows($TotalTestsRunResult);
					

					
					echo "<TR>";
					
					echo "<TD><input type='checkbox' name='build[]' value='".$row['version']."'/></TD>";
					echo "<TD>" .$row['version']."</TD>";
					echo "<TD>" .$numberOfPassed."</TD>";
					echo "<TD>" .$TotalRun."</TD>";
					echo "<TD>" .number_format((($numberOfPassed/$TotalRun) * 100), 1, '.', '') ."%</TD>";
					echo "</TR>";
				}
		

		echo "</tbody></Table ></div>";
                echo "Delete authorization code?";
                echo "<input type='hidden' name='application' value='".$selectedApplication."'/>";
                echo "<input type='password' name='password' /><br>";
                 echo "<input type='submit' value='D E L E T E' />";
                echo "</form>";
	}	
	
// ?>

<script type="text/javascript">

var myDataSource = new YAHOO.util.DataSource(YAHOO.util.Dom.get("myTable"));
myDataSource.responseType = YAHOO.util.DataSource.TYPE_HTMLTABLE;
myDataSource.responseSchema = {
    fields: [
            {key:"Delete"},
            {key:"Build Number"},
			{key:"Total Passed"},
			{key:"Total Executed"},
			{key:"Pass Rate"}
]};

var myColumnDefs = [
    {key:"Delete", label:"Delete", sortable:false},
    {key:"Build Number", label:"Version and Build", sortable:true},
    {key:"Total Passed", label:"Total Passed", sortable:true},
	{key:"Total Executed", label:"Total Executed", sortable:true},
	{key:"Pass Rate", label:"Pass Rate", sortable:true}
];


var myDataTable = new YAHOO.widget.DataTable("myMarkedUpContainer", myColumnDefs, myDataSource, {draggableColumns:true});

</script>

      
   </body>
</html>
