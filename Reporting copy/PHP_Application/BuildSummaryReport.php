<?php
echo "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">
<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"fr\" >";
include "./header.html";
?>
<head>
    <title>Test Maintenance Report</title>
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
    //oracle connection variables
    //$connect = ocilogon("CQ_RO", "comverse", "cqprdcbs");







    echo "<h2>Build Summary Report</h2>";

    include "./constants.inc.php";
    include "./Mysql.obj.php";


    $DBConnection = new mysql;
    $DBConnection->opendbconnection(HOST, DB, USER, PASSWORD);

    if (isset($_GET['tag'])) {

        $tag = $_GET['tag'];
    }
    if (isset($_POST[tag])) {

        $tag = $_POST[tag];
    }





    //  $selectedApplication = $_POST[selectedApplication];
    $selectedBuild = $_POST[selectedBuild];

    $appQuery = "SELECT distinct application from test_results;";
    $appResult = mysql_query($appQuery);


    $LastFiveBuildsQuery = "select distinct version from autotest.test_results  order by time_stamp desc limit 10;";
    $LastFiveBuildsResult = mysql_query($LastFiveBuildsQuery);




    echo "<b>Deployment Mode - " . strtoupper($tag) . "</b><br>";
    // echo "<b>selected application is - " . $selectedApplication . "</b><br>";
    echo "<b>selected build is - " . $selectedBuild . "</b><br>";




    echo "<form name=frmTest action='BuildSummaryReport.php?tag=cv' method=POST>";
    echo "<table>";
    //echo "<TR><TD><SELECT NAME='selectedApplication'>";
    //  echo " <OPTION VALUE=\"\">Select App</OPTION>";
    //   while ($row = mysql_fetch_assoc($appResult)) {
    //      echo "<OPTION VALUE='" . $row['application'] . "'>" . $row['application'] . "</OPTION>";
    //   }
    //   echo "</SELECT></TD>";


    echo "<TD><SELECT NAME='selectedBuild' onChange='frmTest.submit();'>";
    echo " <OPTION VALUE=\"\">Select Build</OPTION>";

    while ($row = mysql_fetch_assoc($LastFiveBuildsResult)) {

        echo "<OPTION VALUE='" . $row['version'] . "'>" . $row['version'] . "</OPTION>";
    }


    echo "</SELECT></TD></TR></TABLE>";



    echo "<input type='hidden' name='tag' value='" . $tag . "'";

    echo "</form>";


    if ($selectedBuild != "") {


        /* while ($row = mysql_fetch_assoc($appResult)) {

          $selectedApplication = $row['application'];

          echo "Selected application is : " . $selectedApplication;

          $DistinctQuery = "select distinct version, substring(version,CHAR_LENGTH(version) - 6, CHAR_LENGTH(version) ) as buildNumber from test_results where application = '" . $selectedApplication . "'
          AND tag='" . $tag . "' ORDER BY buildNumber + 0 DESC LIMIT 0, 20";
          $DistinctResult = mysql_query($DistinctQuery);

         */



        echo "<div id=\"myMarkedUpContainer\">";
        echo "<Table id='myTable'><thead>";
        echo "<TR><TH>Build Number</TH><TH>Total Passed</TH><TH>Total Failed</TH><TH>Total Executed</TH><TH>Pass Rate</TH><TH>Total</TH><TH>Install Date</TH></TR></thead><tbody>";



        while ($row = mysql_fetch_assoc($appResult)) {

            $selectedApplication = $row['application'];



            $BuildQuery = "select distinct test_id  from test_results where application = '" . $selectedApplication . "' and tag = '" . $tag . "' and test_result = 'pass' AND  version like  '%" . $selectedBuild . "%'";
            echo $BuildQuery;
            $BuildResult = mysql_query($BuildQuery);

            $numberOfPassed = $num_rows = mysql_num_rows($BuildResult);


            $TotalTestsFailedQuery = "select distinct test_id from test_results where application = '" . $selectedApplication . "' and tag = '" . $tag . "' and test_result = 'fail' AND  version like '%" . $selectedBuild . "%' and bug_id !='NoBug'";
            $TotalTestsFailedResult = mysql_query($TotalTestsFailedQuery);
            $numberFailedWithBug = $num_rows = mysql_num_rows($TotalTestsFailedResult);

            $TotalTestsRunQuery = "select distinct test_id  from test_results where application = '" . $selectedApplication . "' and tag = '" . $tag . "' AND  version like  '%" . $selectedBuild . "%'";
            $TotalTestsRunResult = mysql_query($TotalTestsRunQuery);
            $TotalRun = $num_rows = mysql_num_rows($TotalTestsRunResult);

            $InstallDateQuery = "select time_stamp, min(id) from test_results where version like ('%" . $selectedBuild . "%') group by version";
            $InstallDateResult = mysql_query($InstallDateQuery);
            $Daterow = mysql_fetch_assoc($InstallDateResult);
            $InstalledDate = $Daterow['time_stamp'];


            $TotalExistingTestCasesQuery = "select distinct test_id from test_results where application = '" . $selectedApplication . "' and WebTestFlag is null";
            $TotalExistingTestCasesResult = mysql_query($TotalExistingTestCasesQuery);
            $totalTestCasesForApplication = $num_rows = mysql_num_rows($TotalExistingTestCasesResult);


            echo "<TR>";


            echo "<TD>" . $selectedApplication . "</TD>";
            echo "<TD>" . $numberOfPassed . "</TD>";
            echo "<TD>" . $numberFailedWithBug . "</TD>";
            echo "<TD>" . $TotalRun . "</TD>";
            echo "<TD>" . number_format((($numberOfPassed / $TotalRun) * 100), 1, '.', '') . "%</TD>";
            echo "<TD>" . $totalTestCasesForApplication . "</TD>";
            echo "<TD>" . $InstalledDate . " </TD>";
            echo "</TR>";
        }
    }


    echo "</tbody></Table ></div>";

    // ?>

    <script type="text/javascript">

        var myDataSource = new YAHOO.util.DataSource(YAHOO.util.Dom.get("myTable"));
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_HTMLTABLE;
        myDataSource.responseSchema = {
            fields: [
                {key:"Build Number"},
                {key:"Total Passed"},
                {key:"Total Failed"},
                {key:"Total Executed"},
                {key:"Pass Rate"},
                 {key:"Total"},
                {key:"Install Date"}
            ]};

        var myColumnDefs = [
            {key:"Build Number", label:"Version and Build", sortable:true},
            {key:"Total Passed", label:"Total Passed", sortable:true},
            {key:"Total Failed", label:"Total With Defects", sortable:true},
            {key:"Total Executed", label:"Total Executed", sortable:true},
            {key:"Pass Rate", label:"Pass Rate", sortable:true},
             {key:"Total", label:"Total", sortable:true},
            {key:"Install Date", label:"Install Date", sortable:true}
        ];


        var myDataTable = new YAHOO.widget.DataTable("myMarkedUpContainer", myColumnDefs, myDataSource, {draggableColumns:true});

    </script>


</body>
</html>
