<?php
echo "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">
<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"fr\" >";
include "./header.html";
?>
<head>
    <title>Test Maintenance Report</title>
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
    //oracle connection variables
    //$connect = ocilogon("CQ_RO", "comverse", "cqprdcbs");



    echo "<h2>Coverage by Release/Application Report</h2>";

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





    $selectedApplication = $_POST[selectedApplication];
    $selectedBuild = $_POST[selectedBuild];

    $appQuery = "SELECT distinct application from full_regression_testsuite order by application;";
    $appResult = mysql_query($appQuery);


    $LastFiveBuildsQuery = "select distinct version from full_regression_testsuite";
    $LastFiveBuildsResult = mysql_query($LastFiveBuildsQuery);





    echo "<b>selected application is - " . $selectedApplication . "</b><br>";
    echo "<b>selected Release is - " . $selectedBuild . "</b><br>";




    echo "<form name=frmTest action='buildApplicationCoverageReport.php?tag=cv' method=POST>";
    echo "<table>";
    echo "<TR><TD><SELECT NAME='selectedApplication'>";
    echo " <OPTION VALUE=\"\">Select App</OPTION>";

    while ($row = mysql_fetch_assoc($appResult)) {

        echo "<OPTION VALUE='" . $row['application'] . "'>" . $row['application'] . "</OPTION>";
    }
    echo "</SELECT></TD>";


    echo "<TD><SELECT NAME='selectedBuild' onChange='frmTest.submit();'>";
    echo " <OPTION VALUE=\"\">Select Build</OPTION>";

    while ($row = mysql_fetch_assoc($LastFiveBuildsResult)) {

        echo "<OPTION VALUE='" . $row['version'] . "'>" . $row['version'] . "</OPTION>";
    }
    echo "</SELECT></TD></TR></TABLE>";



    echo "<input type='hidden' name='tag' value='" . $tag . "'";

    echo "</form>";


    if ($selectedApplication != "" && $selectedBuild != "") {



        $fullScope = array();
        $countCoveredTests = 0;
        $countNotCoveredTests = 0;
        $countOutOfScopeTests = 0;
        $tableContents = "";


        $fullScopeSQL = "select * from full_regression_testsuite where version = '" . $selectedBuild . "' and application = '" . $selectedApplication . "' order by test_id;";

        //echo "<br> " . $fullScopeSQL;

        $fullScopeResults = mysql_query($fullScopeSQL);


        $tableContents = "<center>";

        $tableContents = $tableContents . "<div id=\"myMarkedUpContainer\">";
        $tableContents = $tableContents . "<Table id='myTable'><thead>";
        $tableContents = $tableContents . "<TR><TH>Test ID</TH><th>Coverage Status</TH><th>Last Run</TH></TR></thead><tbody>";

        //  reset($fullScopeResults);

        while ($row = mysql_fetch_assoc($fullScopeResults)) {
            // echo " value => " . $value[0];

            $countOfRunningTestsSQL = "select count(*) as count from test_results where test_id = '" . $row['test_id'] . "' AND application = '" . $selectedApplication . "' AND version like ('" . $selectedBuild . "%')";
            // echo " executing ==> " . $countOfRunningTestsSQL;
            $countOfRunningTestsRESULT = mysql_query($countOfRunningTestsSQL);
            $passrow = mysql_fetch_assoc($countOfRunningTestsRESULT);





            $tableContents = $tableContents . "<TR>";
            $tableContents = $tableContents . "<TD>" . $row['test_id'] . "</TD>";

            if ($row['test_status'] == "OOS") {
                $tableContents = $tableContents . "<TD><CENTER><FONT COLOR=\"BLACK\">Out Of Scope</FONT></CENTER></TD>";
                $countOutOfScopeTests++;
            } else {
                if ($passrow['count'] > 0) {
                    $tableContents = $tableContents . "<TD><CENTER><FONT COLOR=\"GREEN\">Covered</FONT></CENTER></TD>";
                    $countCoveredTests++;
                } else {
                    $tableContents = $tableContents . "<TD><CENTER><FONT COLOR=\"RED\">NOT Covered</FONT></CENTER></TD>";
                    $countNotCoveredTests++;
                }
            }

            $lastBuildTestRunOnSQL = "select version from test_results where test_id = '" . $row['test_id'] . "' AND application = '" . $selectedApplication . "' AND version like ('" . $selectedBuild . "%') order by id desc limit 1";
            // echo " executing ==> " . $countOfRunningTestsSQL;
            $lastBuildTestRunOnRESULT = mysql_query($lastBuildTestRunOnSQL);
            $passrow = mysql_fetch_assoc($lastBuildTestRunOnRESULT);

            $tableContents = $tableContents . "<TD>" . $passrow['version'] . "</TD>";
        }
        $tableContents = $tableContents . "</TR></table></div>";

        $tableContents = $tableContents . "</center>";

        echo "<center>";
        echo "<h2>Coverage Stats</h2>";

        echo "<div id=\"my2MarkedUpContainer\">";
        echo "<Table id='my2Table'><thead>";
        echo "<TR><TH>Tests</TH><th>Number</TH></TR></thead><tbody>";

        echo "<tr><TD> Number of Covered </td><td>" . $countCoveredTests . "</td></tr>";
        echo "<tr><TD> Number of NOT Covered </td><td>" . $countNotCoveredTests . "</td></tr>";
        echo "<tr><TD> Number of Out of Scope Tests </td><td>" . $countOutOfScopeTests . "</td></tr>";
        echo "<tr><TD> Total In Scope </td><td>" . ( $countCoveredTests + $countNotCoveredTests) . "</td></tr>";
        echo "</table></div>";
        echo "</center>";

        echo $tableContents;
    }
    // 
    ?>

    <script type="text/javascript">



        var myDataSource = new YAHOO.util.DataSource(YAHOO.util.Dom.get("myTable"));
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_HTMLTABLE;
        myDataSource.responseSchema = {
            fields: [
                {key: "Test ID"},
                {key: "Coverage Status"},
                {key: "Last Run"}
            ]};

        var myColumnDefs = [
            {key: "Test ID", label: "Test ID", sortable: true},
            {key: "Coverage Status", label: "Coverage Status", sortable: true},
            {key: "Last Run", label: "Last Run", sortable: true}
        ];


        var myDataTable = new YAHOO.widget.DataTable("myMarkedUpContainer", myColumnDefs, myDataSource, {draggableColumns: true});


        var my2DataSource = new YAHOO.util.DataSource(YAHOO.util.Dom.get("my2Table"));
        my2DataSource.responseType = YAHOO.util.DataSource.TYPE_HTMLTABLE;
        my2DataSource.responseSchema = {
            fields: [
                {key: "Tests"},
                {key: "Number"}

            ]};

        var my2ColumnDefs = [
            {key: "Tests", label: "Tests", sortable: true},
            {key: "Number", label: "Number", sortable: true}

        ];


        var my2DataTable = new YAHOO.widget.DataTable("my2MarkedUpContainer", my2ColumnDefs, my2DataSource, {draggableColumns: true});


    </script>


</body>
</html>
