<?php
echo "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">
<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"fr\" >";

include "./header.html";
?>
<head>
    <title>Test Result Report</title>      
    <link type="text/css" rel="stylesheet" href="../yui/build/datatable/assets/skins/sam/datatable.css"/>
    <script type="text/javascript" src="yui/build/yahoo-dom-event/yahoo-dom-event.js"></script>
    <script type="text/javascript" src="yui/build/element/element-beta-min.js"></script>
    <script type="text/javascript" src="yui/build/datasource/datasource-beta-min.js"></script>
    <script type="text/javascript" src="yui/build/json/json-min.js"></script>
    <script type="text/javascript" src="yui/build/connection/connection-min.js"></script>
    <script type="text/javascript" src="yui/build/dragdrop/dragdrop-min.js"></script>
    <script type="text/javascript" src="yui/build/calendar/calendar-min.js"></script>
    <script type="text/javascript" src="yui/build/datatable/datatable-beta-min.js"></script>
</head>
<body class=" yui-skin-sam"> 

    <?php
    include "./constants.inc.php";
    include "./Mysql.obj.php";
    define("selectedApplication", "");
    echo "<h2>Test Build Report</h2>";

    $DBConnection = new mysql;
    $link = $DBConnection->opendbconnection(HOST, DB, USER, PASSWORD);

//        if ( isset( $_GET['tag'] ) )  {
//
//	    $tag = $_GET['tag'];	   
//	}
//        if ( isset( $_POST[tag] ) )  {
//
//	    $tag = $_POST[tag];	   
//	}
//	 echo "Deployment Mode - ".strtoupper($tag);

    $selectedApplication = $_POST['selectedApplication'];
    $appQuery = "SELECT distinct application from test_results;";
    $appResult = mysqli_query($link, $appQuery);






    echo "<BR>selected application is - " . $selectedApplication . "<br>";




    echo "<form name=frmTest action='BuildReport.php?' method=POST>";
    echo "<SELECT NAME='selectedApplication' onChange='frmTest.submit();'>";
    echo " <OPTION VALUE=\"\">Select App</OPTION>";

    while ($row = mysqli_fetch_array($appResult)) {

        echo "<OPTION VALUE='" . $row['application'] . "'>" . $row['application'] . "</OPTION>";
    }


    echo "</SELECT>";
//            echo "<input type='hidden' name='tag' value='".$tag."'";

    echo "</form>";


    if ($selectedApplication != "") {


        $AgeColours = array('#FFFFFF', '#FBF5EF', '#F8ECE0', '#F5D0A9', '#F7BE81', '#FAAC58', '#FE9A2E', '#FF8000');

        $TestCaseListArray = array();
        $FailResultArray = array();
        $PassResultArray = array();



        $DistinctQuery = "select distinct version, substring(version,CHAR_LENGTH(version) - 6, CHAR_LENGTH(version) ) as buildNumber from test_results where application = '" . $selectedApplication . "'
  ORDER BY time_stamp + 0 DESC LIMIT 0, 20";
        $DistinctResult = mysqli_query($link, $DistinctQuery);


        //Create $TestCaseListArray
        while ($row = mysqli_fetch_array($DistinctResult)) {

            $TestBuildListArray[] = $row;
        }

        echo "<center>";
        echo "<div id=\"myMarkedUpContainer\">";
        echo "<Table id='myTable'><thead>";
        echo "<TR><TH>Build Number</TH><TH>Total Passed</TH><TH>Total Failed</TH><TH>Total Executed</TH><TH>Pass Rate</TH><TH>Install Date</TH></TR></thead><tbody>";

        foreach ($TestBuildListArray as $row) {



            $BuildQuery = "select distinct test_id  from test_results where application = '" . $selectedApplication . "' and test_result = 'pass' AND  version like  '%" . $row['version'] . "%'";
            echo $BuildQuery;
            $BuildResult = mysqli_query($link, $BuildQuery);

            $numberOfPassed = mysqli_num_rows($BuildResult);


            $TotalTestsFailedQuery = "select distinct test_id from test_results where application = '" . $selectedApplication . "' and test_result = 'fail' AND  version like '%" . $row['version'] . "%' and bug_id !='NoBug'";
//            echo "query =" . $TotalTestsFailedQuery;
            $TotalTestsFailedResult = mysqli_query($link, $TotalTestsFailedQuery)or die(mysqli_error($link));
            $numberFailedWithBug = $num_rows = mysqli_num_rows($TotalTestsFailedResult);

            $TotalTestsRunQuery = "select distinct test_id  from test_results where application = '" . $selectedApplication . "' AND  version like  '%" . $row['version'] . "%'";
            $TotalTestsRunResult = mysqli_query($link, $TotalTestsRunQuery);
            $TotalRun = $num_rows = mysqli_num_rows($TotalTestsRunResult);

            $InstallDateQuery = "select time_stamp, min(id) from test_results where version like ('%" . $row['version'] . "%') group by version";
            $InstallDateResult = mysqli_query($link, $InstallDateQuery);
            $Daterow = mysqli_fetch_assoc($InstallDateResult);
            $InstalledDate = $Daterow['time_stamp'];




            echo "<TR>";


            echo "<TD>" . $row['version'] . "</TD>";
            echo "<TD>" . $numberOfPassed . "</TD>";
            echo "<TD>" . $numberFailedWithBug . "</TD>";
            echo "<TD>" . $TotalRun . "</TD>";
            echo "<TD>" . number_format((($numberOfPassed / $TotalRun) * 100), 1, '.', '') . "%</TD>";
            echo "<TD>" . $InstalledDate . " </TD>";
            echo "</TR>";
        }


        echo "</tbody></Table ></div>";
        echo "</center>";
    }

// 
    ?>

    <script type="text/javascript">

        var myDataSource = new YAHOO.util.DataSource(YAHOO.util.Dom.get("myTable"));
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_HTMLTABLE;
        myDataSource.responseSchema = {
            fields: [
                {key: "Build Number"},
                {key: "Total Passed"},
                {key: "Total Failed"},
                {key: "Total Executed"},
                {key: "Pass Rate"},
                {key: "Install Date"}
            ]};

        var myColumnDefs = [
            {key: "Build Number", label: "Version and Build", sortable: true},
            {key: "Total Passed", label: "Total Passed", sortable: true},
            {key: "Total Failed", label: "Total With Defects", sortable: true},
            {key: "Total Executed", label: "Total Executed", sortable: true},
            {key: "Pass Rate", label: "Pass Rate", sortable: true},
            {key: "Install Date", label: "Install Date", sortable: true}
        ];


        var myDataTable = new YAHOO.widget.DataTable("myMarkedUpContainer", myColumnDefs, myDataSource, {draggableColumns: true});

    </script>


</body>
</html>
