<?php	
	
echo "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">
<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"fr\" >";
	
	include "./header.html";
?>
<head>
       <title>Test Build Summary Result Report</title>
		<link type="text/css" rel="stylesheet" href="../CQ/yui/build/datatable/assets/skins/sam/datatable.css"/>
		<script type="text/javascript" src="../CQ/yui/build/yahoo-dom-event/yahoo-dom-event.js"></script>
		<script type="text/javascript" src="../CQ/yui/build/element/element-beta-min.js"></script>
		<script type="text/javascript" src="../CQ/yui/build/datasource/datasource-beta-min.js"></script>
		<script type="text/javascript" src="../CQ/yui/build/json/json-min.js"></script>
		<script type="text/javascript" src="../CQ/yui/build/connection/connection-min.js"></script>
		<script type="text/javascript" src="../CQ/yui/build/dragdrop/dragdrop-min.js"></script>
		<script type="text/javascript" src="../CQ/yui/build/calendar/calendar-min.js"></script>
		<script type="text/javascript" src="../CQ/yui/build/datatable/datatable-beta-min.js"></script>
	</head>
<body class=" yui-skin-sam"> 

<?php
	
	include "./constants.inc.php";
	include "./Mysql.obj.php";
	echo "<h2>Test Build Summary Result Report</h2>";
	
	$DBConnection = new mysql;
	$DBConnection->opendbconnection(HOST, DB, USER, PASSWORD);
	
	
        $selectedApplication = $_POST[selectedApplication];
        $selectedVersion = $_POST[selectedVersion];
	$appQuery = "SELECT distinct application from test_results;";
	$appResult = mysql_query($appQuery);
	

	
	

	
	echo "<BR>selected application is - ".$selectedApplication."<br>";
        echo "<form name=frmTest action='BuildRegexReport.php' method=POST>";
        echo "<SELECT NAME='selectedApplication' onChange='frmTest.submit();'>";
        echo " <OPTION VALUE=\"\">Select App</OPTION>";
         
	while ($row = mysql_fetch_assoc($appResult)){

            echo "<OPTION VALUE='".$row['application']."'>".$row['application']."</OPTION>";

	}

        
	echo "</SELECT>";
        echo "</form>";
	
	
	if ( $selectedApplication != ""){
	
	
//		echo "selected Version is :".$selectedVersion;
		$TestCaseListArray = array();
		$FailResultArray = array();
		$PassResultArray = array();
		

                $DistinctQuery = "select substring(version, 1, locate( '-', version)-1) as versionNumbers  from test_results where application = '".$selectedApplication."' group by versionNumbers";
		
                $DistinctResult = mysql_query($DistinctQuery);
//                echo "number of rows [".mysql_num_rows($DistinctResult)."]";
		
		

//                echo "<form name=frm1Test action='BuildRegexReport.php' method=POST>";
//                echo "<SELECT NAME='selectedVersion' onChange='frm1Test.submit();'>";
//                echo " <OPTION VALUE=\"\">Select Version</OPTION>";
//
//                while ($row = mysql_fetch_assoc($DistinctResult)){
//
//                     echo "<OPTION VALUE='".$row['versionNumbers']."'>".$row['versionNumbers']."</OPTION>";
//
//                 }
//
//
//                echo "</SELECT>";
//
//                echo "<input type='hidden' name='selectedApplication' value='".$selectedApplication."'";
//
//                echo "</form>";
//
//
//                if ( $selectedVersion != ""){



                    echo "<div id=\"myMarkedUpContainer\">";
                    echo "<Table id='myTable'><thead>";
                    echo "<TR><TH>Build Number</TH><TH>Total Passed</TH><TH>Total Executed</TH><TH>Pass Rate</TH></TR></thead><tbody>";
			
				while($row = mysql_fetch_assoc($DistinctResult)){
					
			
					
					$BuildQuery = "select distinct test_id  from test_results where application = '".$selectedApplication."' and tag = 'cv' and test_result = 'pass' AND  version like  '%".$row['versionNumbers'] ."%'";
                                        echo $BuildQuery;
					$BuildResult = mysql_query($BuildQuery);					
					
					$numberOfPassed = $num_rows = mysql_num_rows($BuildResult);
                                        echo "number of rows Passed [".$numberOfPassed."]";
					
					$TotalTestsRunQuery = "select distinct test_id  from test_results where application = '".$selectedApplication."' AND  version like  '%".$row['versionNumbers'] ."%'";
					$TotalTestsRunResult = mysql_query($TotalTestsRunQuery);
					$TotalRun = $num_rows = mysql_num_rows($TotalTestsRunResult);
					

					
					echo "<TR>";
					
					
					echo "<TD>" .$row['versionNumbers']."</TD>";
					echo "<TD>" .$numberOfPassed."</TD>";
					echo "<TD>" .$TotalRun."</TD>";
					echo "<TD>" .number_format((($numberOfPassed/$TotalRun) * 100), 1, '.', '') ."%</TD>";
					echo "</TR>";
				}
		

		echo "</tbody></Table ></div>";
//            }
	}	
	
// ?>

<script type="text/javascript">

var myDataSource = new YAHOO.util.DataSource(YAHOO.util.Dom.get("myTable"));
myDataSource.responseType = YAHOO.util.DataSource.TYPE_HTMLTABLE;
myDataSource.responseSchema = {
    fields: [
            {key:"Build Number"},
			{key:"Total Passed"},
			{key:"Total Executed"},
			{key:"Pass Rate"}
]};

var myColumnDefs = [
    {key:"Build Number", label:"Version", sortable:true},
    {key:"Total Passed", label:"Total Passed", sortable:true},
	{key:"Total Executed", label:"Total Executed", sortable:true},
	{key:"Pass Rate", label:"Pass Rate", sortable:true}
];


var myDataTable = new YAHOO.widget.DataTable("myMarkedUpContainer", myColumnDefs, myDataSource, {draggableColumns:true});

</script>

      
   </body>
</html>
